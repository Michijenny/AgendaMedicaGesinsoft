/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Evolucion;
import com.gesinsoft.AgendaMedica.servicios.EvolucionService;
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
@RequestMapping("/api/evolucion")
public class EvolucionController {

    @Autowired
    EvolucionService evolucionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Evolucion>> listarEvolucion() {
        return new ResponseEntity<>(evolucionService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Evolucion> crearEvolucion(
            @RequestBody Evolucion e) {
        return new ResponseEntity<>(evolucionService.save(e),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Evolucion> actualizarEvolucion(@PathVariable Integer id, @RequestBody Evolucion e) {
        Evolucion ev = evolucionService.findById(id);
        if (ev == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ev.setFecha(e.getFecha());
                ev.setAltura(e.getAltura());
                ev.setSesiones(e.getSesiones());
                ev.setResultados(e.getResultados());
                ev.setItem6(e.getItem6());
                ev.setItem7(e.getItem7());
                ev.setNotas(e.getNotas());
                return new ResponseEntity<>(evolucionService.save(ev), HttpStatus.OK);
            } catch (DataAccessException ea) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Evolucion> eliminarEvolucion(@PathVariable Integer id) {
        evolucionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getEvolucionById(@PathVariable("id") Integer id) {
        try {
            Evolucion nc = evolucionService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("Evolucion NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
