/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gesinsoft.AgendaMedica.repository;

import org.springframework.data.repository.CrudRepository;
import com.gesinsoft.AgendaMedica.modelo.Persona;
import org.springframework.stereotype.Repository;

/**
 *
 * @author enriq
 */
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
