/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import java.io.Serializable;
import com.spring.AgendaMedica.modelo.Odontologia;
import com.spring.AgendaMedica.repository.OdontologiaRepository;
import com.spring.AgendaMedica.servicios.OdontologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class OdontologiaServicelmpl extends GenericServiceImpl<Odontologia, Integer> implements OdontologiaService {

    @Autowired
    OdontologiaRepository odontologiaRepository;

    @Override
    public CrudRepository<Odontologia, Integer> getDao() {
        return odontologiaRepository;
    }

}
