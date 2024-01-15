/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.ProveedorDoctor;
import com.gesinsoft.AgendaMedica.repository.LibretaDoctorRepository;
import com.gesinsoft.AgendaMedica.servicios.LibretaDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class LibretaDoctorServiceImpl extends GenericServiceImpl<ProveedorDoctor, Integer> implements LibretaDoctorService  {
  @Autowired
    LibretaDoctorRepository libretaDoctorRepository;

    @Override
    public CrudRepository<ProveedorDoctor, Integer> getDao() {
        return libretaDoctorRepository;
    }    
}
