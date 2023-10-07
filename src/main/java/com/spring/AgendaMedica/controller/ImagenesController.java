/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Imagenes;
import com.spring.AgendaMedica.service.ImagenesServicelmpl;
import com.spring.AgendaMedica.servicios.ImagenesService;
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
@RequestMapping("/api/imagenes")
public class ImagenesController {

    @Autowired
    ImagenesService imagenService;

    @GetMapping("/listar")
    public ResponseEntity<List<Imagenes>> listarImagenes() {
        return new ResponseEntity<>(imagenService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Imagenes> crearImagen(
            @RequestBody Imagenes a) {
        return new ResponseEntity<>(imagenService.save(a),
                 HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Imagenes> actualizarImagen(@PathVariable Long id, @RequestBody Imagenes i) {
        Imagenes ima = imagenService.findById(id);
        if (ima == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ima.setFecha(i.getFecha());
                ima.setPath(i.getPath());
                ima.setNota(i.getNota());
                ima.setTipo(i.getTipo());
                ima.setIdAutor(i.getIdAutor());
                ima.setFirma(i.getFirma());
                return new ResponseEntity<>(imagenService.save(i), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Imagenes> eliminarImagrn(@PathVariable Long id) {
        imagenService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
