/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;
import com.gesinsoft.AgendaMedica.modelo.Libreta;
import com.gesinsoft.AgendaMedica.repository.LibretaRepository;
import com.gesinsoft.AgendaMedica.servicios.LibretaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class LibretaServicelmpl extends GenericServiceImpl<Libreta, Integer> implements LibretaService {

    @Autowired
    LibretaRepository libretaRepository;

    @Override
    public CrudRepository<Libreta, Integer> getDao() {
        return libretaRepository;
    }

}
