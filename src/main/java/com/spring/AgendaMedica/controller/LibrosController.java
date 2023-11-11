/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Libros;
import com.spring.AgendaMedica.service.LibrosServicelmpl;
import com.spring.AgendaMedica.servicios.LibrosService;
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
@RequestMapping("/api/libros")
public class LibrosController {

    @Autowired
    LibrosService libroService;

    @GetMapping("/listar")
    public ResponseEntity<List<Libros>> listarLibros() {
        return new ResponseEntity<>(libroService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Libros> crearLibro(
            @RequestBody Libros l) {
        return new ResponseEntity<>(libroService.save(l),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Libros> actualizarLibros(@PathVariable Integer id, @RequestBody Libros l) {
        Libros lib = libroService.findById(id);
        if (lib == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                lib.setTitulo(l.getTitulo());
                lib.setAutor(l.getAutor());
                lib.setEdicion(l.getEdicion());
                lib.setUbicacion(l.getUbicacion());
                lib.setEstado(l.getEstado());
                lib.setKeywords(l.getKeywords());
                lib.setNotas(l.getNotas());
                lib.setIdDoctor(l.getIdDoctor());
                lib.setCompartido(l.getCompartido());
                lib.setDigital(l.getDigital());
                return new ResponseEntity<>(libroService.save(l), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Libros> eliminarLibros(@PathVariable Integer id) {
        libroService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getLibroById(@PathVariable("id") Integer id) {
        try {
            Libros nc = libroService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("LIBRO NO ENCONTRADO", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
