/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.HorarioMedico;
import com.gesinsoft.AgendaMedica.servicios.HorarioMedicoService;

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
@RequestMapping("/api/horarioM")
public class HorarioMedicoController {

    @Autowired
    HorarioMedicoService horarioMedicoService;

    @GetMapping("/listar")
    public ResponseEntity<List<HorarioMedico>> listarHorarioMedico() {
        return new ResponseEntity<>(horarioMedicoService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<HorarioMedico> crearHorarioMedico(
            @RequestBody HorarioMedico h) {
        return new ResponseEntity<>(horarioMedicoService.save(h),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HorarioMedico> actualizarHorarioMedico(@PathVariable Integer id, @RequestBody HorarioMedico h) {
        HorarioMedico hor = horarioMedicoService.findById(id);
        if (hor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                hor.setDisponible(h.isDisponible());     //revisar           
                return new ResponseEntity<>(horarioMedicoService.save(hor), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HorarioMedico> eliminarHorarioMedico(@PathVariable Integer id) {
        horarioMedicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getHorarioMedicoById(@PathVariable("id") Integer id) {
        try {
            HorarioMedico nc = horarioMedicoService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("HorarioMedico NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
