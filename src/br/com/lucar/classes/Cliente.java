package br.com.lucar.classes;

import br.com.lucar.interfaces.Entities;

public class Cliente implements Entities {

    private String nome;

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                '}';
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getId() {
      return this.getId();
    }
}