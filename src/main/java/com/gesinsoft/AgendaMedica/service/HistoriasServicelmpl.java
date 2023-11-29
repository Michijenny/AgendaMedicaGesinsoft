/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;
import com.gesinsoft.AgendaMedica.modelo.Historias;
import com.gesinsoft.AgendaMedica.repository.HistoriasRepository;
import com.gesinsoft.AgendaMedica.servicios.HistoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class HistoriasServicelmpl extends GenericServiceImpl<Historias, Integer> implements HistoriasService{
    
    @Autowired
    HistoriasRepository historiaRepository;

    @Override
    public CrudRepository<Historias, Integer> getDao() {
        return historiaRepository;
    }

    
}
