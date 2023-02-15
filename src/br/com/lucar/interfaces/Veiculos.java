package br.com.lucar.interfaces;

import br.com.lucar.classes.Veiculo;
import br.com.lucar.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;

public interface Veiculos extends Repository<Veiculo> {

    public default List<Veiculo> buscarModelo(String modelo){
        List<Veiculo> search = new ArrayList<>();
        for (int i = 0; i < listAll().size(); i++) {
            if (listAll().get(i).getModelo().contains(modelo)){
                search.add(listAll().get(i));
            }
        }
        return search;
    }

    default List<Veiculo> buscarMarca(String marca){
        List<Veiculo> search = new ArrayList<>();
        for (int i = 0; i < listAll().size(); i++) {
            if (listAll().get(i).getMarca().contains(marca)){
                search.add(listAll().get(i));
            }
        }
        return search;
    }
}