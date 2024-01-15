/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Tratamiento;
import com.gesinsoft.AgendaMedica.servicios.TratamientoService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
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
@RequestMapping("/api/tratamiento")
public class TratamientoController {

    @Autowired
    TratamientoService tratamientoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Tratamiento>> listarTratamiento() {
        return new ResponseEntity<>(tratamientoService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Tratamiento> crearTratamiento(
            @RequestBody Tratamiento t) {
        return new ResponseEntity<>(tratamientoService.save(t),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Tratamiento> actualizarTratamiento(@PathVariable Integer id, @RequestBody Tratamiento t) {
        Tratamiento tra = tratamientoService.findById(id);
        if (tra == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                tra.setFecha(t.getFecha());
                tra.setDuracion(t.getDuracion());
                tra.setIndicacion(t.getIndicacion());
                tra.setResultado(t.getResultado());
                return new ResponseEntity<>(tratamientoService.save(tra), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Tratamiento> eliminarTratamiento(@PathVariable Integer id) {
        tratamientoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getTratamientoById(@PathVariable("id") Integer id) {
        try {
            Tratamiento nc = tratamientoService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("Tratamiento NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
