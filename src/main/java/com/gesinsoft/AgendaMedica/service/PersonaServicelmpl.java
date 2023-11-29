/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import org.springframework.stereotype.Service;
import com.gesinsoft.AgendaMedica.modelo.Persona;
import com.gesinsoft.AgendaMedica.repository.PersonaRepository;
import com.gesinsoft.AgendaMedica.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author enriq
 */
@Service

public class PersonaServicelmpl extends GenericServiceImpl<Persona, Integer> implements PersonaService  {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return personaRepository;
    }

}
