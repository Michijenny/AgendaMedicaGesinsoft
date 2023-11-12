/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Historias;
import com.spring.AgendaMedica.modelo.Rol;
import com.spring.AgendaMedica.service.HistoriasServicelmpl;
import com.spring.AgendaMedica.servicios.HistoriasService;
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
@RequestMapping("/api/historias")
public class HistoriasController {

    @Autowired
    HistoriasService historiaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Historias>> listarHistorias() {
        return new ResponseEntity<>(historiaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Historias> crearHistoria(
            @RequestBody Historias h) {
        return new ResponseEntity<>(historiaService.save(h),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Historias> actualizarAdministrador(@PathVariable Integer id, @RequestBody Historias h) {
        Historias his = historiaService.findById(id);
        if (his == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                his.setFecha(h.getFecha());
                his.setNota(h.getNota());
                his.setIdAutor(h.getIdAutor());
                his.setFirma(h.getFirma());
                return new ResponseEntity<>(historiaService.save(his), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Historias> eliminarHistoria(@PathVariable Integer id) {
        historiaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getHistoriasById(@PathVariable("id") Integer id) {
        try {
            Historias nc = historiaService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("ROL NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
