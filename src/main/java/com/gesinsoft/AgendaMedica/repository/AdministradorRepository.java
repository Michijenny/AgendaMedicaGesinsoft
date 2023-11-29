/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gesinsoft.AgendaMedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gesinsoft.AgendaMedica.modelo.Administrador;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author enriq
 */
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

}
