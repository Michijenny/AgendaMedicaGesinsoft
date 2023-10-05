/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import org.springframework.stereotype.Service;
import com.spring.AgendaMedica.modelo.Persona;
import com.spring.AgendaMedica.repository.PersonaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author enriq
 */
@Service
public class PersonaServicelmpl extends GenericServiceImpl<Persona, Long> implements GenericService<Persona, Long> {

    PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }

}
