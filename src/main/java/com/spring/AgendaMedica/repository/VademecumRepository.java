/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.AgendaMedica.repository;

import com.spring.AgendaMedica.modelo.Vademecum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author enriq
 */
@Repository
public interface VademecumRepository extends JpaRepository<Vademecum, Integer> {

}
