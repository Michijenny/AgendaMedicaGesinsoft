/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;


import com.gesinsoft.AgendaMedica.modelo.Provincia;
import com.gesinsoft.AgendaMedica.repository.ProvinciaRepository;
import com.gesinsoft.AgendaMedica.servicios.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ProvinciaServiceImpl extends GenericServiceImpl<Provincia, Integer> implements ProvinciaService  {
    @Autowired
    ProvinciaRepository provinciaRepository;

    @Override
    public CrudRepository<Provincia, Integer> getDao() {
        return provinciaRepository;
    }   
}
