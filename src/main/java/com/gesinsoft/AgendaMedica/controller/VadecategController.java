/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Rol;
import com.gesinsoft.AgendaMedica.modelo.Vadecateg;
import com.gesinsoft.AgendaMedica.service.VadecategServicelmpl;
import com.gesinsoft.AgendaMedica.servicios.VadecategService;
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
@RequestMapping("/api/vadecateg")
public class VadecategController {

    @Autowired
    VadecategService vadeService;

    @GetMapping("/listar")
    public ResponseEntity<List<Vadecateg>> listarCategoria() {
        return new ResponseEntity<>(vadeService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Vadecateg> crearCategoria(
            @RequestBody Vadecateg v) {
        return new ResponseEntity<>(vadeService.save(v),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Vadecateg> actualizarCategoria(@PathVariable Integer id, @RequestBody Vadecateg v) {
        Vadecateg vad = vadeService.findById(id);
        if (vad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                vad.setTitulo(v.getTitulo());
                vad.setTipo(v.getTipo());
                return new ResponseEntity<>(vadeService.save(vad), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Vadecateg> eliminarCategoria(@PathVariable Integer id) {
        vadeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getVadecategById(@PathVariable("id") Integer id) {
        try {
            Vadecateg nc = vadeService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("CATEGORIA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
