package br.com.lucarjoy.utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculoDiaria {

    public long calcularDiarias (LocalDateTime inicio, LocalDateTime fim){
        if (isDiariaIncompleta(inicio, fim)){
            return calcularMinutos(inicio, fim)/(24*60) + 1;
        }
        return calcularMinutos(inicio, fim)/(24*60);
    }
    private long calcularMinutos(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return Duration.between(dataInicial, dataFinal).toMinutes();
    }
    private boolean isDiariaIncompleta(LocalDateTime inicio, LocalDateTime fim){
        return calcularMinutos(inicio, fim) % (24*60) > 0;
    }
}
