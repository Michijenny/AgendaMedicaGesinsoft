/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Proveedor;
import com.spring.AgendaMedica.repository.ProveedorRepository;
import com.spring.AgendaMedica.servicios.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class ProveedorServicelmpl extends GenericServiceImpl<Proveedor, Long> implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public CrudRepository<Proveedor, Long> getDao() {
        return proveedorRepository;
    }

}
