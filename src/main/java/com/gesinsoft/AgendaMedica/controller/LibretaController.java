/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Proveedor;
import com.gesinsoft.AgendaMedica.service.LibretaServicelmpl;
import com.gesinsoft.AgendaMedica.servicios.LibretaService;
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
@RequestMapping("/api/libreta")
public class LibretaController {

    @Autowired
    LibretaService libretaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Proveedor>> listarLibreta() {
        return new ResponseEntity<>(libretaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Proveedor> crearLibreta(
            @RequestBody Proveedor l) {
        return new ResponseEntity<>(libretaService.save(l),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedor> actualizarlibreta(@PathVariable Integer id, @RequestBody Proveedor l) {
        Proveedor libre = libretaService.findById(id);
        if (libre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                libre.setNombre(l.getNombre());
                libre.setTelefono(l.getTelefono());
                libre.setCelular(l.getCelular());
                libre.setEmail(l.getEmail());
                libre.setWeb(l.getWeb());
                libre.setDireccion(l.getDireccion());
                libre.setNotas(l.getNotas());
                return new ResponseEntity<>(libretaService.save(libre), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Proveedor> eliminarLibreta(@PathVariable Integer id) {
        libretaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getLibretaById(@PathVariable("id") Integer id) {
        try {
            Proveedor nc = libretaService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("LIBRETA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
