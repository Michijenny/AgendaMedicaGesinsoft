/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.ObraSocial;
import com.spring.AgendaMedica.repository.ObraSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class ObraSocialServicelmpl extends GenericServiceImpl<ObraSocial, Long> implements GenericService<ObraSocial, Long> {

    @Autowired
    ObraSocialRepository obraRepository;

    @Override
    public CrudRepository<ObraSocial, Long> getDao() {
        return obraRepository;
    }

}
