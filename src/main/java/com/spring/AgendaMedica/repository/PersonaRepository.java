/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.AgendaMedica.repository;

import org.springframework.data.repository.CrudRepository;
import com.spring.AgendaMedica.modelo.Persona;

/**
 *
 * @author enriq
 */
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
