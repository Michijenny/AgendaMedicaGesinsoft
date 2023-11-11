/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.AgendaMedica.servicios;
import com.spring.AgendaMedica.modelo.Usuario;
/**
 *
 * @author enriq
 */
public interface UsuarioService {
    
    Usuario findByUsername(String username);
    boolean existsByUsername(String username);
}
