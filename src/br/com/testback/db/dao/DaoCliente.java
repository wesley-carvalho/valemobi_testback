package br.com.testback.db.dao;

import br.com.testback.db.utils.ConnectionUtils;
import br.com.testback.model.cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class DaoCliente {

    public static void inserirCliente(Cliente cliente)
            throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tb_customer_account (cpf_cnpj, nm_customer, is_active, vl_total) "
                + "VALUES (?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getCpf_cnpj());
            preparedStatement.setString(2, cliente.getNm_customer());
            preparedStatement.setBoolean(3, cliente.isIs_active());
            preparedStatement.setDouble(4, cliente.getVl_total());

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizarCliente(Cliente cliente)
            throws SQLException, ClassNotFoundException {
        String sql = "UPDATE tb_customer_account SET cpf_cnpj=?, nm_customer=?, is_active=?,"
                + " vl_total=? WHERE (tb_customer_account.id_customer=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getCpf_cnpj());
            preparedStatement.setString(2, cliente.getNm_customer());
            preparedStatement.setBoolean(3, cliente.isIs_active());
            preparedStatement.setDouble(4, cliente.getVl_total());
            preparedStatement.setInt(5, cliente.getId_customer());

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static List<Cliente> listarClientes()
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_customer_account WHERE (is_active=?)";

        List<Cliente> listaClientes = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new LinkedList<>();
                }
                Cliente cliente = new Cliente();
                cliente.setId_customer(result.getInt("id_customer"));
                cliente.setCpf_cnpj(result.getString("cpf_cnpj"));
                cliente.setNm_customer(result.getString("nm_customer"));
                cliente.setIs_active(result.getBoolean("is_active"));
                cliente.setVl_total(result.getDouble("vl_total"));

                listaClientes.add(cliente);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }

    public static Cliente obterCliente(int id)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_customer_account WHERE (id_customer=? AND is_active=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_customer(result.getInt("id_customer"));
                cliente.setCpf_cnpj(result.getString("cpf_cnpj"));
                cliente.setNm_customer(result.getString("nm_customer"));
                cliente.setIs_active(result.getBoolean("is_active"));
                cliente.setVl_total(result.getDouble("vl_total"));

                return cliente;
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return null;
    }

    public static void excluirCliente(int id)
            throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tb_customer_account SET is_active=? WHERE (tb_customer_account.id_customer=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, false);
            preparedStatement.setLong(2, id);

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
