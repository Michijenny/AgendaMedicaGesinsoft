/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.HorarioMedico;
import com.gesinsoft.AgendaMedica.repository.HorarioMedicoRepository;
import com.gesinsoft.AgendaMedica.servicios.HorarioMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class HorarioMedicoServiceImpl  extends GenericServiceImpl<HorarioMedico, Integer> implements HorarioMedicoService {
    @Autowired
    HorarioMedicoRepository horarioMedicoRepository;

    @Override
    public CrudRepository<HorarioMedico, Integer> getDao() {
        return horarioMedicoRepository;
    }
}
