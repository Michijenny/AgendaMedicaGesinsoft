/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.Rol;
import com.gesinsoft.AgendaMedica.repository.RolRepository;
import com.gesinsoft.AgendaMedica.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


/**
 *
 * @author enriq
 */
@Service
public class RolServicelmpl extends GenericServiceImpl<Rol, Integer> implements RolService {

    @Autowired
       private   RolRepository rolRepository;

    @Override
    public CrudRepository<Rol, Integer> getDao() {
        return rolRepository;
    }
    
//    public Optional <Rol> getByNombre (RolNombres rolnombre){
//        return rolRepository.findByRolNombre(rolnombre);
//    }

    @Override
    public Rol findByRolNombre(String RolNombre) {
       return rolRepository.findByRolNombre(RolNombre);
    }

}
