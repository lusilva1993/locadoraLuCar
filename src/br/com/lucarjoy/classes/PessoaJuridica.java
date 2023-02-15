package br.com.lucarjoy.classes;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String getId() {
        return this.cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return  getNome() + " " +
                "CNPJ: "+ cnpj ;
    }

}