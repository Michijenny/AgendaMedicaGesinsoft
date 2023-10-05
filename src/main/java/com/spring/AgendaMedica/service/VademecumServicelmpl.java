/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Vademecum;
import com.spring.AgendaMedica.repository.VademecumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class VademecumServicelmpl extends GenericServiceImpl<Vademecum, Long> implements GenericService<Vademecum, Long> {

    @Autowired
    VademecumRepository vademecumRepository;

    @Override
    public CrudRepository<Vademecum, Long> getDao() {
        return vademecumRepository;
    }
}
