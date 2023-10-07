/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author enriq
 * @param <T>
 * @param <ID>
 */
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    public abstract CrudRepository<T, ID> getDao();

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T findById(ID id) {
        Optional<T> optional = getDao().findById(id);
        return optional.orElse(null);
    }

   @Override
    public List<T> findByAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(data -> list.add(data));
        return list;
    }
    
    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }
}