/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.ObraSocial;
import com.spring.AgendaMedica.service.ObraSocialServicelmpl;
import com.spring.AgendaMedica.servicios.ObraSocialService;
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
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/obrasocial")
public class ObraSocialController {

    @Autowired
    ObraSocialService obraService;

    @GetMapping("/listar")
    public ResponseEntity<List<ObraSocial>> listarObraSocial() {
        return new ResponseEntity<>(obraService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ObraSocial> crearObraSocial(
            @RequestBody ObraSocial o) {
        return new ResponseEntity<>(obraService.save(o),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ObraSocial> actualizarObraSocial(@PathVariable Long id, @RequestBody ObraSocial o) {
        ObraSocial obra = obraService.findById(id);
        if (obra == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                obra.setNombre(o.getNombre());
                obra.setDirector(o.getDirector());
                obra.setSecretario(o.getSecretario());
                obra.setSecretario(o.getSecretario());
                obra.setTesorero(o.getTesorero());
                obra.setAcesortecnico(o.getAcesortecnico());
                obra.setAnotaciones(o.getAnotaciones());
                return new ResponseEntity<>(obraService.save(o), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ObraSocial> eliminarObraSocial(@PathVariable Long id) {
        obraService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
