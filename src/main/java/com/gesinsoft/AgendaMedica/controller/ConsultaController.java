/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Consulta;
import com.gesinsoft.AgendaMedica.servicios.ConsultaService;
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
@RequestMapping("/api/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Consulta>> listarConsulta() {
        return new ResponseEntity<>(consultaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Consulta> crearConsulta(
            @RequestBody Consulta C) {
        return new ResponseEntity<>(consultaService.save(C),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Consulta> actualizarConsulta(@PathVariable Integer id, @RequestBody Consulta c) {
        Consulta consul = consultaService.findById(id);
        if (consul == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                consul.setFecha(c.getFecha()); 
                consul.setMotivo(c.getMotivo()); 
                consul.setComentario(c.getComentario()); 
                return new ResponseEntity<>(consultaService.save(consul), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Consulta> eliminarConsulta(@PathVariable Integer id) {
        consultaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getConsultaById(@PathVariable("id") Integer id) {
        try {
            Consulta nc = consultaService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("CONSULTA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
