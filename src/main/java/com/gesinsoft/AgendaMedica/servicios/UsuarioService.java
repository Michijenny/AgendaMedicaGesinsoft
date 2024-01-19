/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gesinsoft.AgendaMedica.servicios;
import com.gesinsoft.AgendaMedica.modelo.Usuario;
import com.gesinsoft.AgendaMedica.service.GenericService;
import java.io.Serializable;
/**
 *
 * @author enriq
 */
public interface UsuarioService extends GenericService<Usuario, Integer> {
    
   // Usuario findByUsername(String username);
   // boolean existsByUsername(String username);
    
    Usuario findByUserName(String username);
    boolean existsByUserName(String username);
}
