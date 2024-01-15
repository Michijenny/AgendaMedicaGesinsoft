/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.ProveedorDoctor;
import com.gesinsoft.AgendaMedica.servicios.LibretaDoctorService;

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
@RequestMapping("/api/libretaD")
public class LibretaDoctorController {

    @Autowired
    LibretaDoctorService libretaDoctorService;

    @GetMapping("/listar")
    public ResponseEntity<List<ProveedorDoctor>> listarLibretaDoctor() {
        return new ResponseEntity<>(libretaDoctorService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ProveedorDoctor> crearLibretaDoctor(
            @RequestBody ProveedorDoctor l) {
        return new ResponseEntity<>(libretaDoctorService.save(l),
                HttpStatus.CREATED);
    }

//    @PutMapping("/actualizar/{id}")
//    public ResponseEntity<ProveedorDoctor> actualizarLibretaDoctor(@PathVariable Integer id, @RequestBody ProveedorDoctor l) {
//        ProveedorDoctor lib = libretaDoctorService.findById(id);
//        if (lib == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            try {
//                          
//                return new ResponseEntity<>(libretaDoctorService.save(lib), HttpStatus.OK);
//            } catch (DataAccessException e) {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ProveedorDoctor> eliminarLibretaDoctor(@PathVariable Integer id) {
        libretaDoctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getLibretaDoctorById(@PathVariable("id") Integer id) {
        try {
            ProveedorDoctor nc = libretaDoctorService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("LibretaDoctor NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
