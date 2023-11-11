/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import java.io.Serializable;
import org.springframework.stereotype.Service;
import com.spring.AgendaMedica.modelo.Usuario;
import com.spring.AgendaMedica.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.AgendaMedica.repository.UsuarioRepository;
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

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
    
}
