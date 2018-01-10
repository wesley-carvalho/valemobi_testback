package br.com.testback.model.validador.cliente;

import br.com.testback.model.cliente.Cliente;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ValidadorCliente {

    public static void validar(Cliente cliente) {
        if(cliente == null){
            throw new IllegalArgumentException("Não foi informado um cliente");
        }
        if(cliente.getCpf_cnpj().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um CPF/CNPJ");
        }
        if(cliente.getNm_customer().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um nome");
        }
        if(cliente.getVl_total().toString().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um saldo");
        }
    }
}
