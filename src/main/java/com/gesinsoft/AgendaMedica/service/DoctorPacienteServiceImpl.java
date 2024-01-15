/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.DoctorPaciente;
import com.gesinsoft.AgendaMedica.repository.DoctorPacienteRepository;
import com.gesinsoft.AgendaMedica.servicios.DoctorPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class DoctorPacienteServiceImpl extends GenericServiceImpl<DoctorPaciente, Integer> implements DoctorPacienteService {
      @Autowired
    DoctorPacienteRepository doctorPacienteRepository;

    @Override
    public CrudRepository<DoctorPaciente, Integer> getDao() {
        return doctorPacienteRepository;
    }
}
