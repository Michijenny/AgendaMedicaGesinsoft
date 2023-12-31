/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Archivos;

import com.gesinsoft.AgendaMedica.servicios.ArchivoService;
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
@RequestMapping("/api/archivos")
public class ArchivosController {

    @Autowired
    ArchivoService archivoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Archivos>> listarArchivo() {
        return new ResponseEntity<>(archivoService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Archivos> crearArchivos(
            @RequestBody Archivos a) {
        return new ResponseEntity<>(archivoService.save(a),
                HttpStatus.CREATED);
    }

    /*@PutMapping("/actualizar/{id}")
    public ResponseEntity<Archivos> actualizarArchivos(@PathVariable Integer id, @RequestBody Archivos a) {
        Archivos arc = archivoService.findById(id);
        if (arc == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                arc.setFecha(a.get));
                arc.setTipo(a.getTipo());
                arc.setRuta(a.getRuta());
                arc.setStorage(a.getStorage());
                return new ResponseEntity<>(archivoService.save(arc), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }*/

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Archivos> eliminarArchivo(@PathVariable Integer id) {
        archivoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getArchivosById(@PathVariable("id") Integer id) {
        try {
            Archivos nc = archivoService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("ARCHIVO NO ENCONTRADO", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
