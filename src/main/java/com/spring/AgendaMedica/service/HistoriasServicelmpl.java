/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;
import com.spring.AgendaMedica.modelo.Historias;
import com.spring.AgendaMedica.repository.HistoriasRepository;
import com.spring.AgendaMedica.servicios.HistoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class HistoriasServicelmpl extends GenericServiceImpl<Historias, Long> implements HistoriasService{
    
    @Autowired
    HistoriasRepository historiaRepository;

    @Override
    public CrudRepository<Historias, Long> getDao() {
        return historiaRepository;
    }

    
}
