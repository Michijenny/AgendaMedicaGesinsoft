/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;
import  com.spring.AgendaMedica.repository.ImagenesRepository;
import  com.spring.AgendaMedica.modelo.Imagenes;
import com.spring.AgendaMedica.servicios.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
public class ImagenesServicelmpl extends GenericServiceImpl<Imagenes, Long> implements ImagenesService {

    @Autowired
    ImagenesRepository imagenesRepository;

    @Override
    public CrudRepository<Imagenes, Long> getDao() {
        return imagenesRepository;
    }

}
