/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.Vadecateg;
import com.gesinsoft.AgendaMedica.repository.VadecategRepository;
import com.gesinsoft.AgendaMedica.servicios.VadecategService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class VadecategServicelmpl extends GenericServiceImpl<Vadecateg, Integer> implements VadecategService {

    @Autowired
    VadecategRepository vadecategRepository;

    @Override
    public CrudRepository<Vadecateg, Integer> getDao() {
        return vadecategRepository;
    }

}
