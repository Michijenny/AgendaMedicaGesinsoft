/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Nomenclador;
import com.spring.AgendaMedica.repository.NomencladorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class NomencladorServicelmpl extends GenericServiceImpl<Nomenclador, Long> implements GenericService<Nomenclador, Long> {

    @Autowired
    NomencladorRepository nomencladorRepository;

    @Override
    public CrudRepository<Nomenclador, Long> getDao() {
        return nomencladorRepository;
    }

}
