/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Nomenclador;
import com.spring.AgendaMedica.service.NomencladorServicelmpl;
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
@RequestMapping("/nomenclador")
public class NomencladorController {

    @Autowired
    NomencladorServicelmpl nomenService;

    @GetMapping("/listar")
    public ResponseEntity<List<Nomenclador>> listarNomenclador() {
        return new ResponseEntity<>(nomenService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Nomenclador> crearNomenclador(
            @RequestBody Nomenclador n) {
        return new ResponseEntity<>(nomenService.save(n),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Nomenclador> actualizarNomenclador(@PathVariable Long id, @RequestBody Nomenclador n) {
        Nomenclador nom = nomenService.findById(id);
        if (nom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                nom.setDescripcion(n.getDescripcion());
                nom.setValor(n.getValor());
                return new ResponseEntity<>(nomenService.save(n), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Nomenclador> eliminarNomenclador(@PathVariable Long id) {
        nomenService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
