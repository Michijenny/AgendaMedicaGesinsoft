/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Vademecum;
import com.spring.AgendaMedica.service.VademecumServicelmpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("/vademecum")
public class VademecumController {

    @Autowired
    VademecumServicelmpl vaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Vademecum>> listarVademecum() {
        return new ResponseEntity<>(vaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Vademecum> crearVademecum(
            @RequestBody Vademecum v) {
        return new ResponseEntity<>(vaService.save(v),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Vademecum> actualizarVademecum(@PathVariable Long id, @RequestBody Vademecum v) {
        Vademecum vade = vaService.findById(id);
        if (vade == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                vade.setId_doctor(v.getId_doctor());
                vade.setCompartido(v.getCompartido());
                vade.setLaboratorio(v.getLaboratorio());
                vade.setMedicamento(v.getMedicamento());
                vade.setComposicion(v.getComposicion());
                vade.setIndicaciones(v.getIndicaciones());
                vade.setContraindicaciones(v.getContraindicaciones());
                vade.setPosologia(v.getPosologia());
                vade.setId_categoria(v.getId_categoria());
                vade.setEquivalencias(v.getEquivalencias());
                vade.setAnotaciones(v.getAnotaciones());
                vade.setStock(v.getStock());
                return new ResponseEntity<>(vaService.save(v), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Vademecum> eliminarVademecum(@PathVariable Long id) {
        vaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
