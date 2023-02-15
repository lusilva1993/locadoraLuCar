package br.com.lucar.repository;

import br.com.lucar.interfaces.Entities;
import br.com.lucar.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenerica<T extends Entities> implements Repository<T> {
    private List<T> lista;

    public ClasseGenerica() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void save(T entity) {
        if (searchItem(entity.getId()) != null){
            throw new IllegalArgumentException("Não é possível cadastrar, ID já existente!");
        }
        lista.add(entity);
    }

    @Override
    public void update(T entity) {
        if (searchItem(entity.getId()) == null){
            throw new IllegalArgumentException("Não é possível atualizar, ID não existente!");
        }
        delete(entity.getId());
        save(entity);
    }

    @Override
    public void delete(String id) {
        if (searchItem(id) == null){
            throw new IllegalArgumentException("Não é possível deletar, ID não existente!");
        }
        lista.remove(searchItem(id));
    }

    @Override
    public T searchItem(String id) {
        for (T entity : lista) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<T> listAll() {
        return new ArrayList<>(lista);
    }
}