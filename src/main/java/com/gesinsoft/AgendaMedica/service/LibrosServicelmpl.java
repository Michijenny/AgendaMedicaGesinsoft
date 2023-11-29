/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.Libros;
import com.gesinsoft.AgendaMedica.repository.LibrosRepository;
import com.gesinsoft.AgendaMedica.servicios.LibrosService;
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
