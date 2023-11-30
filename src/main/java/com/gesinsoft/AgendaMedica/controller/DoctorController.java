/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Doctor;
import com.gesinsoft.AgendaMedica.service.DoctorServicelmpl;
import com.gesinsoft.AgendaMedica.servicios.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author enriq
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Doctor>> listarDoctor() {
        return new ResponseEntity<>(doctorService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Doctor> crearDoctor(
            @RequestBody Doctor d) {
        return new ResponseEntity<>(doctorService.save(d),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Doctor> actualizarDoctor(@PathVariable Integer id, @RequestBody Doctor d) {
        Doctor doc = doctorService.findById(id);
        if (doc == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                doc.setId(d.getId());
                doc.setNombre(d.getNombre());
                doc.setClavesecreta(d.getClavesecreta());
                doc.setComentarios(d.getComentarios());
                doc.setDireccion(d.getDireccion());
                doc.setEspecialidad(d.getEspecialidad());
                doc.setTelefono(d.getTelefono());
                doc.setClave(d.getClave());
                doc.setNotaAuto(d.getNotaAuto());
                doc.setNota(d.getNota());
                doc.setCfg(d.getCfg());
                doc.setCfgsec(d.getCfgsec());
                doc.setEmail(d.getEmail());
                doc.setMatricula(d.getMatricula());
                return new ResponseEntity<>(doctorService.save(doc), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Doctor> eliminarDoctor(@PathVariable Integer id) {
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable("id") Integer id) {
        try {
            Doctor nc = doctorService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("DOCTOR NO ENCONTRADO ", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
