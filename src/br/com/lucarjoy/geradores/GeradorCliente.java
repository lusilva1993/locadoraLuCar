package br.com.lucarjoy.geradores;

import br.com.lucarjoy.classes.Cliente;
import br.com.lucarjoy.classes.PessoaJuridica;
import br.com.lucarjoy.repository.Clientes;

import java.util.List;

public class GeradorCliente {
    private final Clientes clientes;

    public GeradorCliente(Clientes clientes) {
        this.clientes = clientes;
    }

    public void cadastrar (Cliente cliente){
        if (isCadastrado(cliente.getId())){
            throw new IllegalArgumentException("Cliente já cadastrado no sistema!");
        }
        clientes.save(cliente);
    }
    public void editar (Cliente cLiente){
        if (!isCadastrado(cLiente.getId())){
            throw new IllegalArgumentException("ID não cadastrado no sistema!");
        }
        clientes.update(cLiente);
    }

    public void editar (String cnpj, String nome){
        if (!isCadastrado(cnpj)){
            throw new IllegalArgumentException("ID não cadastrado no sistema!");
        }

        PessoaJuridica editarCliente = (PessoaJuridica) clientes.searchItem(cnpj);
        editarCliente.setNome(nome);
        clientes.update(editarCliente);
    }


    public Cliente buscarCliente (String id){
        return (clientes.searchItem(id));
    }


    public void excluir (Cliente cliente){
        if (!isCadastrado(cliente)){
            throw new IllegalArgumentException("Cliente inexistente!");
        }
        clientes.delete(cliente.getId());
    }

    public List<Cliente> listClientes (){
        return clientes.listAll();
    }

    private boolean isCadastrado (Cliente cliente){
        return clientes.searchItem(cliente.getId()) != null;
    }
    private boolean isCadastrado (String id){
        return clientes.searchItem(id) != null;
    }

}