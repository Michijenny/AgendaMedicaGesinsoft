/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import java.io.Serializable;
import com.spring.AgendaMedica.repository.AntropometriaRepository;
import com.spring.AgendaMedica.modelo.Antropometria;
import com.spring.AgendaMedica.servicios.AntropometriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class AntropometriaServicelmpl extends GenericServiceImpl<Antropometria, Integer> implements AntropometriaService {

    @Autowired
    AntropometriaRepository antropometriaRepository;

    @Override
    public CrudRepository<Antropometria, Integer> getDao() {
        return antropometriaRepository;
    }

}
