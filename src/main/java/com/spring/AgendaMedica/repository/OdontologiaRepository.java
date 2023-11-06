/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.AgendaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.AgendaMedica.modelo.Odontologia;
import org.springframework.stereotype.Repository;
/**
 *
 * @author enriq
 */
@Repository
public interface OdontologiaRepository extends JpaRepository<Odontologia, Integer>{
    
}