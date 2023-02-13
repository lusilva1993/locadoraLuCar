package br.com.lucar.classes;

import br.com.lucar.enums.TipoCliente;

public class Cliente {

    private String cpfCnpj;
    private String nome;
    private TipoCliente tipoCliente;

    public Cliente() {
    }

    public Cliente(String cpfCnpj, String nome, TipoCliente tipoCliente) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.tipoCliente = tipoCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpfCnpj='" + cpfCnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}