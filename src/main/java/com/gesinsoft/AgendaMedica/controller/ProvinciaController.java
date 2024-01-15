/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Provincia;
import com.gesinsoft.AgendaMedica.servicios.ProvinciaService;
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
@RequestMapping("/api/provincia")
public class ProvinciaController {

    @Autowired
    ProvinciaService provinciaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Provincia>> listarProvincia() {
        return new ResponseEntity<>(provinciaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Provincia> crearProvincia(
            @RequestBody Provincia p) {
        return new ResponseEntity<>(provinciaService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Provincia> actualizarProvincia(@PathVariable Integer id, @RequestBody Provincia p) {
        Provincia prov = provinciaService.findById(id);
        if (prov == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                prov.setNombre(p.getNombre());
                return new ResponseEntity<>(provinciaService.save(prov), HttpStatus.OK);
            } catch (DataAccessException ea) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Provincia> eliminarProvincia(@PathVariable Integer id) {
        provinciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getProvinciaById(@PathVariable("id") Integer id) {
        try {
            Provincia nc = provinciaService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("Provincia NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
