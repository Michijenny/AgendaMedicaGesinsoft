/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;


import com.gesinsoft.AgendaMedica.modelo.Recetas;
import com.gesinsoft.AgendaMedica.servicios.RecetasService;
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
@RequestMapping("/api/recetas")
public class RecetasController {
    
     @Autowired
    RecetasService recetasService;

     @GetMapping("/listar")
    public ResponseEntity<List<Recetas>> listarResetas() {
        return new ResponseEntity<>(recetasService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Recetas> crearResetas(
            @RequestBody Recetas r) {
        return new ResponseEntity<>(recetasService.save(r),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Recetas> actualizarRecetas(@PathVariable Integer id, @RequestBody Recetas r) {
        Recetas rece = recetasService.findById(id);
        if (rece == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {

                return new ResponseEntity<>(recetasService.save(r), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Recetas> eliminarRecetas(@PathVariable Integer id) {
        recetasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getRecetasById(@PathVariable("id") Integer id) {
        try {
            Recetas nc = recetasService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("RECETA NO ENCONTRADO", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
