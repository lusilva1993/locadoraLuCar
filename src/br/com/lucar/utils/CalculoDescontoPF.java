package br.com.lucar.utils;

import br.com.lucar.interfaces.CalculoDesconto;

public class CalculoDescontoPF implements CalculoDesconto {
    @Override
    public Double calcularDesconto(long diarias) {
        if (diarias <= 5L){
            return 0.0;
        }return 0.05;
    }

}