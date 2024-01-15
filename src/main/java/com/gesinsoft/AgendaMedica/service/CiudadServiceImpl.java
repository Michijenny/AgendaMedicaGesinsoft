/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.Ciudad;
import com.gesinsoft.AgendaMedica.repository.CiudadRepository;
import com.gesinsoft.AgendaMedica.servicios.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CiudadServiceImpl extends GenericServiceImpl<Ciudad, Integer> implements CiudadService {
      @Autowired
    CiudadRepository ciudadRepository;

    @Override
    public CrudRepository<Ciudad, Integer> getDao() {
        return ciudadRepository;
    }
}
