/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Oftalmologia;
import com.spring.AgendaMedica.servicios.OftalmologiaService;
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
@RequestMapping("/api/oftalmologia")
public class OftalmologiaController {

    @Autowired
    OftalmologiaService oftalmologiaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Oftalmologia>> listarOftalmologia() {
        return new ResponseEntity<>(oftalmologiaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Oftalmologia> crearOftalmologia(
            @RequestBody Oftalmologia a) {
        return new ResponseEntity<>(oftalmologiaService.save(a),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Oftalmologia> actualizarOftalmologia(@PathVariable Integer id, @RequestBody Oftalmologia o) {
        Oftalmologia oft = oftalmologiaService.findById(id);
        if (oft == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                oft.setFecha(o.getFecha());
                oft.setResultado(o.getResultado());
                oft.setOjoizquierdo(o.getOjoizquierdo());
                oft.setOjoderecho(o.getOjoderecho());
                oft.setAnotaciones(o.getAnotaciones());
                return new ResponseEntity<>(oftalmologiaService.save(o), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Oftalmologia> eliminarOftalmologia(@PathVariable Integer id) {
        oftalmologiaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
