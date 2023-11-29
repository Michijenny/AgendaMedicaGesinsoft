/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import java.io.Serializable;
import com.gesinsoft.AgendaMedica.modelo.Archivos;
import com.gesinsoft.AgendaMedica.repository.ArchivoRepository;
import com.gesinsoft.AgendaMedica.servicios.ArchivoService;
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
