/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.AgendaMedica.servicios;
import com.spring.AgendaMedica.modelo.Usuario;
import com.spring.AgendaMedica.service.GenericService;
import java.io.Serializable;
/**
 *
 * @author enriq
 */
public interface UsuarioService extends GenericService<Usuario, Integer> {
    
    Usuario findByUsername(String username);
    boolean existsByUsername(String username);
}
