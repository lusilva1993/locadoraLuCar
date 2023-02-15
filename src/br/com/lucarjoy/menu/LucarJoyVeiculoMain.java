package br.com.lucarjoy.menu;

import br.com.lucarjoy.classes.*;
import br.com.lucarjoy.geradores.GeradorAluguel;
import br.com.lucarjoy.geradores.GeradorCliente;
import br.com.lucarjoy.geradores.GeradorVeiculo;
import br.com.lucarjoy.repository.Clientes;
import br.com.lucarjoy.repository.Disponiveis;
import br.com.lucarjoy.repository.Locados;

import java.time.LocalDateTime;
import java.time.Month;

public class LucarJoyVeiculoMain {
    public static void main(String[] args) {

        PessoaFisica joao = new PessoaFisica("João Pé de Feijão", "12345678978");
        PessoaFisica maria = new PessoaFisica("Maria Comilona", "98765432121");
        PessoaFisica pedro = new PessoaFisica("Pedro Pedroso", "14725836914");
        PessoaJuridica americanas = new PessoaJuridica("Americanas SA", "12123123000125");
        PessoaJuridica ada = new PessoaJuridica("Ada Tech", "36852147000125");

        PortePequeno celta1 = new PortePequeno("Chevrolet", "Celta", "LHG2525");
        PortePequeno celta2 = new PortePequeno("Chevrolet", "Celta", "FRE5142");
        PortePequeno mobi = new PortePequeno("Fiat", "Mobi", "FERT8794");
        PorteMedio jetta = new PorteMedio("Volkswagen", "Jetta", "TEY5823");
        PorteMedio cerato = new PorteMedio("Kia", "Cerato", "GTG5858");
        PorteMedio cruze = new PorteMedio("Chevrolet", "Cruze", "UJU5649");
        SUV tCross = new SUV("Volkswagen", "T-Cross", "DSE2514");
        SUV ecoSport = new SUV("Ford", "EcoSport", "ZAW1414");
        SUV duster = new SUV("Renault", "Duster", "SDD4744");

        Clientes clientes = new Clientes();
        Disponiveis disponiveis = new Disponiveis();
        Locados locados = new Locados();

        GeradorVeiculo geradorVeiculo = new GeradorVeiculo(disponiveis, locados);
        GeradorCliente geradorCliente = new GeradorCliente(clientes);
        GeradorAluguel geradorAluguel = new GeradorAluguel(geradorCliente, geradorVeiculo);

        geradorCliente.cadastrar(joao);
        geradorCliente.cadastrar(maria);
        geradorCliente.cadastrar(pedro);
        geradorCliente.cadastrar(americanas);
        geradorCliente.cadastrar(ada);

        System.out.println("Clientes: ");
        System.out.print(geradorCliente.listClientes());
        System.out.println();

        //Fazendo update nos clientes:
        PessoaFisica mariaEditada = new PessoaFisica("Maria Conceição", "98765432121");
        geradorCliente.editar(mariaEditada);
        System.out.println("Listagem após edição: ");
        System.out.println(geradorCliente.listClientes());
        System.out.println();

        //Cadastrando Veiculos
        geradorVeiculo.cadastrar(celta1);
        geradorVeiculo.cadastrar(celta2);
        geradorVeiculo.cadastrar(cerato);
        geradorVeiculo.cadastrar(cruze);
        geradorVeiculo.cadastrar(duster);
        geradorVeiculo.cadastrar(ecoSport);
        geradorVeiculo.cadastrar(jetta);
        geradorVeiculo.cadastrar(mobi);
        geradorVeiculo.cadastrar(tCross);

        System.out.println("Veículos disponíveis para locação: ");
        System.out.println(geradorVeiculo.listarDisponiveis());
        System.out.println("Locados: ");
        System.out.println(geradorVeiculo.listarAlugados());
        System.out.println();

        //Alterando veículos
        SUV dusterEditada = new SUV("Renault", "Duster 2023", "SDD4744");
        geradorVeiculo.editar(dusterEditada);

        System.out.println("Listagem de disponíveis após edição: ");
        System.out.println(geradorVeiculo.listarDisponiveis());
        System.out.println("Locados: ");
        System.out.println(geradorVeiculo.listarAlugados());
        System.out.println();

        //Buscando veículos por parte da marca ou  modelo
        System.out.println("Busca por modelos que contenham a letra C");
        System.out.println(geradorVeiculo.buscarPorModelo("C"));
        System.out.println("Busca por marcas que contenham iat");
        System.out.println(geradorVeiculo.buscarVeiculoPorMarca("iat"));
        System.out.println();

        //Bora locar?
        Locacao locacao1 = geradorAluguel.alugarVeiculo(maria, LocalDateTime.of(2023, Month.FEBRUARY, 9, 10, 58), cruze);
        Locacao locacao2 = geradorAluguel.alugarVeiculo(americanas, LocalDateTime.of(2023, Month.FEBRUARY, 2, 10, 58), duster);
        Locacao locacao3 = geradorAluguel.alugarVeiculo(pedro, LocalDateTime.of(2023, Month.FEBRUARY, 10, 10, 58), celta2);
        Locacao locacao4 = geradorAluguel.alugarVeiculo(ada, LocalDateTime.of(2023, Month.FEBRUARY, 13, 10, 58), cerato);

        System.out.println("Disponíveis: ");
        System.out.println(geradorVeiculo.listarDisponiveis());
        System.out.println("Locados: ");
        System.out.println(geradorVeiculo.listarAlugados());
        System.out.println();

        //Fazendo devolução
        geradorAluguel.devolver(locacao1, LocalDateTime.of(2023, Month.APRIL, 14, 15, 25));
        geradorAluguel.devolver(locacao2, LocalDateTime.of(2023, Month.FEBRUARY, 14, 15, 25));
        geradorAluguel.devolver(locacao3, LocalDateTime.of(2023, Month.FEBRUARY, 14, 15, 25));

        System.out.println("\nDisponíveis: ");
        System.out.println(geradorVeiculo.listarDisponiveis());
        System.out.println("Alugados: ");
        System.out.println(geradorVeiculo.listarAlugados());
        System.out.println();

    }
}