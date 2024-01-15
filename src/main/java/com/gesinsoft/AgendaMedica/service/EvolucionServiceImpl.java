/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.Evolucion;
import com.gesinsoft.AgendaMedica.repository.EvolucionRepository;
import com.gesinsoft.AgendaMedica.servicios.EvolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class EvolucionServiceImpl extends GenericServiceImpl<Evolucion, Integer> implements EvolucionService {
      @Autowired
    EvolucionRepository evolucionRepository;

    @Override
    public CrudRepository<Evolucion, Integer> getDao() {
        return evolucionRepository;
    }
    
}
