/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Rol;
import com.spring.AgendaMedica.repository.RolRepository;
import com.spring.AgendaMedica.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class RolServicelmpl extends GenericServiceImpl<Rol, Long> implements RolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolRepository;
    }

}
