/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.service;
import com.gesinsoft.AgendaMedica.modelo.Doctor;
import com.gesinsoft.AgendaMedica.repository.DoctorRepository;
import com.gesinsoft.AgendaMedica.servicios.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



/**
 *
 * @author enriq
 */
@Service
public class DoctorServicelmpl extends GenericServiceImpl<Doctor, Integer> implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public CrudRepository< Doctor, Integer> getDao() {
        return doctorRepository;
    }

}
