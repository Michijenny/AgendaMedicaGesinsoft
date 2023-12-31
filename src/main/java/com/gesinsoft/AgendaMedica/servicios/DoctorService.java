/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.servicios;

import com.gesinsoft.AgendaMedica.modelo.Doctor;
import com.gesinsoft.AgendaMedica.service.GenericService;

/**
 *
 * @author ASUS ROG
 */
public interface DoctorService extends GenericService<Doctor, Integer>{
    
    Doctor findByNombre(String username);
    boolean existsByNombre(String username);
    
}
