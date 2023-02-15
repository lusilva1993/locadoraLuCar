package br.com.lucarjoy.geradores;

import br.com.lucarjoy.classes.Veiculo;
import br.com.lucarjoy.repository.Disponiveis;
import br.com.lucarjoy.repository.Locados;

import java.util.ArrayList;
import java.util.List;

public class GeradorVeiculo {

    private final Disponiveis disponiveis;
    private final Locados locados;

    public GeradorVeiculo(Disponiveis disponiveis, Locados locados) {
        this.disponiveis = disponiveis;
        this.locados = locados;
    }

    public void cadastrar(Veiculo veiculo) {
        if (isDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo já cadastrado em sistema!");
        }
        if (isLocado(veiculo)){
            throw new IllegalArgumentException("Veículo já encontra-se alugado!");
        }
        disponiveis.save(veiculo);
    }

    public void irParaLocados(Veiculo veiculo) {
        if (!isDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo não cadastrado ou já locado!");
        }
        if (isLocado(veiculo)){
            throw new IllegalArgumentException("Veículo já está locado!");
        }

        disponiveis.delete(veiculo.getId());
        locados.save(veiculo);
    }
    public void moverParaDisponiveis(Veiculo veiculo) {
        if (!isLocado(veiculo)){
            throw new IllegalArgumentException("Veículo inexistente!");
        }
        if (isDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo não está alugado!");
        }

        locados.delete(veiculo.getId());
        disponiveis.save(veiculo);
    }
    public void removerVeiculo (Veiculo veiculo){
        if (!isDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo alugado ou não cadastrado no sistema");
        }
        if ((isLocado(veiculo))){
            throw new IllegalArgumentException("Não é possível remover pois veículo está alugado e os dados serão perdidos!");
        }
        disponiveis.delete(veiculo.getId());
    }
    public void editar(Veiculo veiculo){
        if (!isDisponivel(veiculo) && !isLocado(veiculo)){
            throw new IllegalArgumentException("Veículo não cadastrado");
        }
        if (isDisponivel(veiculo)){
            disponiveis.delete(veiculo.getId());
            disponiveis.save(veiculo);
        }
        if (isLocado(veiculo)){
            locados.delete(veiculo.getId());
            locados.save(veiculo);
        }
    }
    public List<Veiculo> buscarPorModelo(String modelo){
        List<Veiculo> veiculosDisponiveis = disponiveis.buscarModelo(modelo);
        List<Veiculo> veiculosAlugados = locados.buscarModelo(modelo);
        List<Veiculo> todosEncontrados = new ArrayList<>();
        todosEncontrados.addAll(veiculosDisponiveis);
        todosEncontrados.addAll(veiculosAlugados);
        return todosEncontrados;
    }
    public List<Veiculo> buscarVeiculoPorMarca(String marca){
        List<Veiculo> disponiveis = this.disponiveis.buscarMarca(marca);
        List<Veiculo> locados = this.locados.buscarMarca(marca);
        List<Veiculo> todos = new ArrayList<>();
        todos.addAll(disponiveis);
        todos.addAll(locados);
        return todos;
    }

    public List<Veiculo> listarDisponiveis(){
        return disponiveis.listAll();
    }
    public List<Veiculo> listarAlugados(){
        return locados.listAll();
    }

    public boolean isDisponivel(Veiculo veiculo) {
        return disponiveis.searchItem(veiculo.getId()) != null;
    }

    public boolean isLocado(Veiculo veiculo) {
        return locados.searchItem(veiculo.getId()) != null;
    }

}