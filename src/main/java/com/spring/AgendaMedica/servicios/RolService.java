/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.servicios;

import com.spring.AgendaMedica.modelo.Rol;
import com.spring.AgendaMedica.modelo.RolNombres;
import com.spring.AgendaMedica.service.GenericService;
import java.util.Optional;

/**
 *
 * @author ASUS ROG
 */
public interface RolService extends GenericService<Rol, Integer>{
    
    Optional<Rol> findByRolNombre(RolNombres integer);
    
}
