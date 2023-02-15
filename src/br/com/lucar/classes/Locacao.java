package br.com.lucar.classes;

import br.com.lucar.interfaces.Entities;

import java.time.LocalDateTime;

public class Locacao implements Entities {

    private final Cliente cliente;

    private final LocalDateTime inicio;
    private final Veiculo veiculo;

    public Locacao(Cliente cliente, LocalDateTime inicio, Veiculo veiculo) {
        this.cliente = cliente;
        this.inicio = inicio;
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    @Override
    public String getId() {
        return veiculo.getId();
    }

    @Override
    public String toString() {
        return this.veiculo + " alugado para " + this.cliente + " em " + inicio ;
    }
}