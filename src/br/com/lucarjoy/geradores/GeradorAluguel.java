package br.com.lucarjoy.geradores;

import br.com.lucarjoy.classes.*;
import br.com.lucarjoy.utils.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GeradorAluguel {

    private GeradorCliente geradorCliente;
    private GeradorVeiculo geradorVeiculo;

    private final CalculoDescontoPF calculoDescontoPF = new CalculoDescontoPF();
    private final CalculoDescontoPJ calculoDescontoPJ = new CalculoDescontoPJ();
    private final CalculoPortePequeno calculadoraDeDiariasVeiculoPequeno = new CalculoPortePequeno();
    private final CalculoPorteMedio calculoDiariasPorteMedio = new CalculoPorteMedio();
    private final CalculoDiariasSUV calculadoraDeDiariasVeiculoSUV = new CalculoDiariasSUV();
    private final CalculoDiaria calcularDiarias = new CalculoDiaria();

    public GeradorAluguel(GeradorCliente geradorCliente, GeradorVeiculo geradorVeiculo) {
        this.geradorCliente = geradorCliente;
        this.geradorVeiculo = geradorVeiculo;
    }

    public Locacao alugarVeiculo (Cliente cliente, LocalDateTime inicio, Veiculo veiculo){
        Locacao locacao = new Locacao(cliente, inicio, veiculo);
        geradorVeiculo.irParaLocados(veiculo);
        return locacao;
    }

    public void devolver (Locacao locacao, LocalDateTime dataDevolucao){
        geradorVeiculo.moverParaDisponiveis(locacao.getVeiculo());
        BigDecimal valorDoAluguel = calcularValor(locacao, dataDevolucao);
        Long diarias = calcularDiarias(locacao, dataDevolucao);
        System.out.println("Quantidade de Diárias: " + diarias);
        System.out.println("Valor do aluguel: $" + valorDoAluguel);
    }

    private BigDecimal calcularValorTotal(Locacao locacao, LocalDateTime dataDevolucao){
        long diarias = calcularDiarias(locacao, dataDevolucao);
        if (locacao.getVeiculo() instanceof PortePequeno){
            return calculadoraDeDiariasVeiculoPequeno.calcularTotal(diarias);
        } else if (locacao.getVeiculo() instanceof PorteMedio) {
            return calculoDiariasPorteMedio.calcularTotal(diarias);
        } else if (locacao.getVeiculo() instanceof SUV){
            return calculadoraDeDiariasVeiculoSUV.calcularTotal(diarias);
        } else {
            throw new IllegalArgumentException("Tipo de veículo Inválido!!!");
        }
    }
    private Double calcularDesconto (Locacao locacao, LocalDateTime dataDevolucao) {
        long diarias = calcularDiarias(locacao, dataDevolucao);
        if (locacao.getCliente() instanceof PessoaFisica){
            return calculoDescontoPF.calcularDesconto(diarias);
        } else if (locacao.getCliente() instanceof PessoaJuridica){
            return calculoDescontoPJ.calcularDesconto(diarias);
        } else {
            throw new IllegalArgumentException("Tipo de cliente inválido");
        }
    }
    public BigDecimal calcularValor (Locacao locacao, LocalDateTime dataDevolucao){
        BigDecimal valorTotal =  calcularValorTotal(locacao, dataDevolucao);
        Double desconto = calcularDesconto(locacao, dataDevolucao);
        return valorTotal.multiply(BigDecimal.valueOf(1L-desconto));
    }
    public long calcularDiarias (Locacao locacao, LocalDateTime dataDevolucao){
        return calcularDiarias.calcularDiarias(locacao.getInicio(), dataDevolucao);
    }

}