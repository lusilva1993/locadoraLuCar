package br.com.lucar.classes;

public class PessoaFisica extends Cliente{

    private String cpf;

    public PessoaFisica() {
    }
    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String getId() {
        return this.cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return getNome() + " (" +
                " cpf: "+ cpf + ")";
    }
}
