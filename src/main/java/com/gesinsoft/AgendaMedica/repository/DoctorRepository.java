/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gesinsoft.AgendaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gesinsoft.AgendaMedica.modelo.Doctor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author enriq
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    public Doctor findByNombre(String nombre);

    boolean existsByNombre(String nombre);

}
