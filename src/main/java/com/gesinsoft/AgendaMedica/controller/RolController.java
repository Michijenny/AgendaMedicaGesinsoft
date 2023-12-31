/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Rol;
import com.gesinsoft.AgendaMedica.service.RolServicelmpl;
import com.gesinsoft.AgendaMedica.servicios.RolService;
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
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listarRol() {
        return new ResponseEntity<>(rolService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(
            @RequestBody Rol r) {
        return new ResponseEntity<>(rolService.save(r),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol r) {
        Rol rol = rolService.findById(id);
        if (rol == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                rol.setRolNombre(r.getRolNombre());
                return new ResponseEntity<>(rolService.save(r), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Rol> eliminarRol(@PathVariable Integer id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //LISTAR ROL POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getRolById(@PathVariable("id") Integer id) {
        try {
            Rol nc = rolService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("ROL NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
