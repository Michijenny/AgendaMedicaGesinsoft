/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;
import com.gesinsoft.AgendaMedica.modelo.Proveedor;
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
public class LibretaServicelmpl extends GenericServiceImpl<Proveedor, Integer> implements LibretaService {

    @Autowired
    LibretaRepository libretaRepository;

    @Override
    public CrudRepository<Proveedor, Integer> getDao() {
        return libretaRepository;
    }

}
