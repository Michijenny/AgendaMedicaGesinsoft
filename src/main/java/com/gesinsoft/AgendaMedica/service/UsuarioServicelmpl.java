/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import java.io.Serializable;
import org.springframework.stereotype.Service;
import com.gesinsoft.AgendaMedica.modelo.Usuario;
import com.gesinsoft.AgendaMedica.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import com.gesinsoft.AgendaMedica.repository.UsuarioRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author enriq
 */
@Service
public class UsuarioServicelmpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService{
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }

   /* @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
    */
    
}
