/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.DoctorPaciente;
import com.gesinsoft.AgendaMedica.servicios.DoctorPacienteService;
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
 * @author USUARIO
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/doctorP")
public class DoctorPacienteController {

    @Autowired
    DoctorPacienteService doctorPacienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<DoctorPaciente>> listarDoctorPaciente() {
        return new ResponseEntity<>(doctorPacienteService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<DoctorPaciente> crearDoctorPaciente(
            @RequestBody DoctorPaciente Dp) {
        return new ResponseEntity<>(doctorPacienteService.save(Dp),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DoctorPaciente> actualizarDoctorPaciente(@PathVariable Integer id, @RequestBody DoctorPaciente dp) {
        DoctorPaciente docP = doctorPacienteService.findById(id);
        if (docP == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                docP.setFecha(dp.getFecha());
                return new ResponseEntity<>(doctorPacienteService.save(docP), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<DoctorPaciente> eliminarDoctorPaciente(@PathVariable Integer id) {
        doctorPacienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getDoctorPacienteById(@PathVariable("id") Integer id) {
        try {
            DoctorPaciente nc = doctorPacienteService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("DocPaciente NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
