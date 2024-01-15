/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;


import com.gesinsoft.AgendaMedica.modelo.Tratamiento;
import com.gesinsoft.AgendaMedica.repository.TratamientoRepository;
import com.gesinsoft.AgendaMedica.servicios.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class TratamientoServiceImpl extends GenericServiceImpl<Tratamiento, Integer> implements TratamientoService  {
    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public CrudRepository<Tratamiento, Integer> getDao() {
        return tratamientoRepository;
    } 
}
