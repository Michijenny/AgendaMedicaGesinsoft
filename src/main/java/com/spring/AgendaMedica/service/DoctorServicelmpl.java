/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;
import com.spring.AgendaMedica.modelo.Doctor;
import com.spring.AgendaMedica.repository.DoctorRepository;
import com.spring.AgendaMedica.servicios.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



/**
 *
 * @author enriq
 */
@Service
public class DoctorServicelmpl extends GenericServiceImpl<Doctor, Long> implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public CrudRepository< Doctor, Long> getDao() {
        return doctorRepository;
    }

}
