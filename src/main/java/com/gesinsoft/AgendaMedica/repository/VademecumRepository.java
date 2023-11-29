/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gesinsoft.AgendaMedica.repository;

import com.gesinsoft.AgendaMedica.modelo.Vademecum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author enriq
 */
@Repository
public interface VademecumRepository extends JpaRepository<Vademecum, Integer> {

}
