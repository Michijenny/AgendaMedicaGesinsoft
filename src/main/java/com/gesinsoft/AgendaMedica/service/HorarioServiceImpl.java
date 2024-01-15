/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;


import com.gesinsoft.AgendaMedica.modelo.Horario;
import com.gesinsoft.AgendaMedica.repository.HorarioRepository;
import com.gesinsoft.AgendaMedica.servicios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class HorarioServiceImpl  extends GenericServiceImpl<Horario, Integer> implements HorarioService {
    @Autowired
    HorarioRepository horarioRepository;

    @Override
    public CrudRepository<Horario, Integer> getDao() {
        return horarioRepository;
    }
    
}
