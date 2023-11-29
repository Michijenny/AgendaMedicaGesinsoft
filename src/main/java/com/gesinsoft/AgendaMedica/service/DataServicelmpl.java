/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;
import com.gesinsoft.AgendaMedica.modelo.Datas;
import com.gesinsoft.AgendaMedica.repository.DataRepository;
import com.gesinsoft.AgendaMedica.servicios.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author enriq
 */
@Service
public class DataServicelmpl extends GenericServiceImpl<Datas, Integer> implements DataService {

    @Autowired
    DataRepository dataRepository;

    @Override
    public CrudRepository<Datas, Integer> getDao() {
        return dataRepository;
    }
}
