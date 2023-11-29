/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.Vademecum;
import com.gesinsoft.AgendaMedica.repository.VademecumRepository;
import com.gesinsoft.AgendaMedica.servicios.VademecumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class VademecumServicelmpl extends GenericServiceImpl<Vademecum, Integer> implements VademecumService {

    @Autowired
    VademecumRepository vademecumRepository;

    @Override
    public CrudRepository<Vademecum, Integer> getDao() {
        return vademecumRepository;
    }
}
