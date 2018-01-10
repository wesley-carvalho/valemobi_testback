package br.com.testback.model.cliente;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class Cliente implements Comparable<Cliente>{
    private int id_customer;
    private String cpf_cnpj;
    private String nm_customer;
    private boolean is_active;
    public Double vl_total;

    public Cliente() {        
    }

    public Cliente(int id_customer, String cpf_cnpj, String nm_customer, boolean is_active, double vl_total) {
        this.id_customer = id_customer;
        this.cpf_cnpj = cpf_cnpj;
        this.nm_customer = nm_customer;
        this.is_active = is_active;
        this.vl_total = vl_total;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Double getVl_total() {
        return vl_total;
    }

    public void setVl_total(double vl_total) {
        this.vl_total = vl_total;
    }    

    @Override
    public int compareTo(Cliente o) {
        if (this.getVl_total() > o.getVl_total()) {
            return -1;
        }
        if (this.getVl_total() < o.getVl_total()) {
            return 1;
        }
        return 0;
    }
}
