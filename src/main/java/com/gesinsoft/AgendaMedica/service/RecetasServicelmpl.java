/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;


import com.gesinsoft.AgendaMedica.modelo.Recetas;
import com.gesinsoft.AgendaMedica.repository.RecetasRepository;
import com.gesinsoft.AgendaMedica.servicios.RecetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class RecetasServicelmpl extends GenericServiceImpl<Recetas, Integer> implements RecetasService{
    
     @Autowired
    RecetasRepository recetasRepository;

    @Override
    public CrudRepository<Recetas, Integer> getDao() {
        return recetasRepository;
    }
}
