package br.com.lucar.interfaces;

import java.util.List;

public interface Repository <T> {

    void save(T entity);

    void update(T entidade);

    void delete(String id);

    T searchItem(String id);

    List<T> listAll();


}