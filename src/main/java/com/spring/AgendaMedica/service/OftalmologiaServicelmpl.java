/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import java.io.Serializable;
import com.spring.AgendaMedica.modelo.Oftalmologia;
import com.spring.AgendaMedica.repository.OftalmologiaRepository;
import com.spring.AgendaMedica.servicios.OftalmologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
/**
 *
 * @author enriq
 */
@Service
public class OftalmologiaServicelmpl extends GenericServiceImpl<Oftalmologia, Integer> implements OftalmologiaService{
    
    @Autowired
    OftalmologiaRepository oftalmologiaRepository;
    
    @Override
    public CrudRepository <Oftalmologia, Integer> getDao(){
        return oftalmologiaRepository;
    }
    
    
}
