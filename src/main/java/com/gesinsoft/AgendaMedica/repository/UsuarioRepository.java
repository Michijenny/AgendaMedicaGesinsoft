/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gesinsoft.AgendaMedica.repository;

import com.gesinsoft.AgendaMedica.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author enriq
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    
   // public Usuario findByUsername(String username);
    public Usuario findByNombre(String nombre);
   // boolean existsByUsername(String username);
    boolean existsByNombre(String nombre);
    
    
}
