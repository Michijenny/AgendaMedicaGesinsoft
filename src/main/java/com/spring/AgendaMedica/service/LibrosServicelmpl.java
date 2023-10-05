/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Libros;
import com.spring.AgendaMedica.repository.LibrosRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class LibrosServicelmpl extends GenericServiceImpl<Libros, Long> implements GenericService<Libros, Long> {

    @Autowired
    LibrosRepository librosRepository;

    @Override
    public CrudRepository<Libros, Long> getDao() {
        return librosRepository;
    }
}
