/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;
import com.spring.AgendaMedica.modelo.Data1;
import com.spring.AgendaMedica.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author enriq
 */
@Service
public class DataServicelmpl extends GenericServiceImpl<Data1, Long> implements GenericService<Data1, Long> {

    @Autowired
    DataRepository dataRepository;

    @Override
    public CrudRepository<Data1, Long> getDao() {
        return dataRepository;
    }
}
