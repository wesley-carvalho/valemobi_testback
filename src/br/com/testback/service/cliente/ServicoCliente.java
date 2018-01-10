package br.com.testback.service.cliente;

import br.com.testback.db.dao.DaoCliente;
import br.com.testback.model.cliente.Cliente;
import br.com.testback.model.validador.cliente.ValidadorCliente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ServicoCliente {

    public static void cadastrarCliente(Cliente cliente) {
        try {
            ValidadorCliente.validar(cliente);

            DaoCliente.inserirCliente(cliente);
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso",
                "Cadastro efetuado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void atualizarCliente(Cliente cliente) {
        try {
            ValidadorCliente.validar(cliente);

            DaoCliente.atualizarCliente(cliente);
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso",
                "Atualização efetuada", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Cliente> listarClientes() {
        try {
            return DaoCliente.listarClientes();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static Cliente obterCliente(int id) {
        try {
            return DaoCliente.obterCliente(id);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static void excluirCliente(int id) {
        try {
            DaoCliente.excluirCliente(id);
            
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso",
                "Exclusão efetuada", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
