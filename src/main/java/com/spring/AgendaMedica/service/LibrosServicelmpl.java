/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Libros;
import com.spring.AgendaMedica.repository.LibrosRepository;
import com.spring.AgendaMedica.servicios.LibrosService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class LibrosServicelmpl extends GenericServiceImpl<Libros, Integer> implements LibrosService {

    @Autowired
    LibrosRepository librosRepository;

    @Override
    public CrudRepository<Libros, Integer> getDao() {
        return librosRepository;
    }
}
