/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gesinsoft.AgendaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gesinsoft.AgendaMedica.modelo.Antropometria;

/**
 *
 * @author enriq
 */
@Repository
public interface AntropometriaRepository extends JpaRepository<Antropometria, Integer> {

}
