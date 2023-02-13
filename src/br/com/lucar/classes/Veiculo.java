package br.com.lucar.classes;

import br.com.lucar.enums.PorteVeiculo;

public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private Boolean disponivel;

    private PorteVeiculo porte;

    public Veiculo(){
    };

    public Veiculo(String marca, String modelo, int ano, String placa, Boolean disponivel, PorteVeiculo porte) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.disponivel = disponivel;
        this.porte = porte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca= marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", placa='" + placa + '\'' +
                ", disponivel=" + disponivel +
                ", porte=" + porte +
                '}';
    }
}
