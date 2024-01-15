/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;

import com.gesinsoft.AgendaMedica.modelo.Consulta;
import com.gesinsoft.AgendaMedica.repository.ConsultaRepository;
import com.gesinsoft.AgendaMedica.servicios.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ConsultaServiceImpl extends GenericServiceImpl<Consulta, Integer> implements ConsultaService {
      @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public CrudRepository<Consulta, Integer> getDao() {
        return consultaRepository;
    }
}
