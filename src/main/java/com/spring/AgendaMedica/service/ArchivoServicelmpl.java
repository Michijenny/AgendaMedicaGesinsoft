/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import java.io.Serializable;
import com.spring.AgendaMedica.modelo.Archivos;
import com.spring.AgendaMedica.repository.ArchivoRepository;
import com.spring.AgendaMedica.servicios.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class ArchivoServicelmpl extends GenericServiceImpl<Archivos, Integer> implements ArchivoService {

    @Autowired
    ArchivoRepository archivoRepository;

    @Override
    public CrudRepository<Archivos, Integer> getDao() {
        return archivoRepository;
    }

}
