/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;
import  com.gesinsoft.AgendaMedica.repository.ImagenesRepository;
import  com.gesinsoft.AgendaMedica.modelo.Imagenes;
import com.gesinsoft.AgendaMedica.servicios.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class ImagenesServicelmpl extends GenericServiceImpl<Imagenes, Integer> implements ImagenesService {

    @Autowired
    ImagenesRepository imagenesRepository;

    @Override
    public CrudRepository<Imagenes, Integer> getDao() {
        return imagenesRepository;
    }

}
