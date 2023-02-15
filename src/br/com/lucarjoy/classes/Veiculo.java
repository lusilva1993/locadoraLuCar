package br.com.lucarjoy.classes;

import br.com.lucarjoy.interfaces.Entities;

public abstract class Veiculo implements Entities {

    private String marca;
    private String modelo;
    private String placa;

    public Veiculo(){

    }

    public Veiculo(String marca, String modelo, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getFabricante() {
        return marca;
    }

    public void setFabricante(String fabricante) {
        this.marca = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getId() {
        return this.placa;
    }

    @Override
    public String toString() {
        return  marca + " - " + modelo + " Placa: " + placa ;
    }

}