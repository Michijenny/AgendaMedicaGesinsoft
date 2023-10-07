/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;

import com.spring.AgendaMedica.modelo.Vadecateg;
import com.spring.AgendaMedica.repository.VadecategRepository;
import com.spring.AgendaMedica.servicios.VadecategService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class VadecategServicelmpl extends GenericServiceImpl<Vadecateg, Long> implements VadecategService {

    @Autowired
    VadecategRepository vadecategRepository;

    @Override
    public CrudRepository<Vadecateg, Long> getDao() {
        return vadecategRepository;
    }

}
