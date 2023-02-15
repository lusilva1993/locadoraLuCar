package br.com.lucar.utils;

import br.com.lucar.interfaces.CalculoDesconto;

public class CalculoDescontoPJ implements CalculoDesconto {

    @Override
    public Double calcularDesconto(long diarias) {
        if (diarias <= 3L){
            return 0.0;
        }return 0.1;
    }
}
