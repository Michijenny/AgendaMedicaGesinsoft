/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Paciente;
import com.spring.AgendaMedica.repository.PacienteRepository;
import com.spring.AgendaMedica.servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class PacienteServicelmpl extends GenericServiceImpl<Paciente, Integer> implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public CrudRepository<Paciente, Integer> getDao() {
        return pacienteRepository;
    }
}
