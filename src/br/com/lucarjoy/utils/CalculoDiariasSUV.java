package br.com.lucarjoy.utils;

import br.com.lucarjoy.interfaces.Calculadora;

import java.math.BigDecimal;

public class CalculoDiariasSUV implements Calculadora {

    @Override
    public BigDecimal calcularTotal(long diarias) {
        BigDecimal diaria = new BigDecimal(200.0);
        BigDecimal total = diaria.multiply(BigDecimal.valueOf(diarias));
        return total;
    }
}
