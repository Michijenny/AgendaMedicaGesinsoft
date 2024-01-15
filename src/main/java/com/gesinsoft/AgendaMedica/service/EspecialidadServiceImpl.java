/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;


import com.gesinsoft.AgendaMedica.modelo.Especialidad;
import com.gesinsoft.AgendaMedica.repository.EspecialidadRepository;
import com.gesinsoft.AgendaMedica.servicios.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<Especialidad, Integer> implements EspecialidadService {
      @Autowired
    EspecialidadRepository especialidadRepository;

    @Override
    public CrudRepository<Especialidad, Integer> getDao() {
        return especialidadRepository;
    }
}
