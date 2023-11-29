/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.servicios;

import com.gesinsoft.AgendaMedica.modelo.Rol;
import com.gesinsoft.AgendaMedica.service.GenericService;
import java.util.Optional;

/**
 *
 * @author ASUS ROG
 */
public interface RolService extends GenericService<Rol, Integer>{
    
    Rol findByRolNombre(String rolNombre);
    
}
