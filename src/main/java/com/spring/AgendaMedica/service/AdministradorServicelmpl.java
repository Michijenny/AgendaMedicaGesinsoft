/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;
import com.spring.AgendaMedica.modelo.Administrador;
import com.spring.AgendaMedica.repository.AdministradorRepository;
import com.spring.AgendaMedica.servicios.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class AdministradorServicelmpl extends GenericServiceImpl<Administrador, Long> implements AdministradorService{
    
    @Autowired
    AdministradorRepository administradorRepositoy;

    @Override
    public CrudRepository<Administrador, Long> getDao() {
        return administradorRepositoy;
    }

}
