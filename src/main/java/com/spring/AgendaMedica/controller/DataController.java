/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Data1;
import com.spring.AgendaMedica.service.DataServicelmpl;
import com.spring.AgendaMedica.servicios.DataService;
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
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    DataService dataService;

    @GetMapping("/listar")
    public ResponseEntity<List<Data1>> listarData() {
        return new ResponseEntity<>(dataService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Data1> crearData(
            @RequestBody Data1 d) {
        return new ResponseEntity<>(dataService.save(d),
                 HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Data1> actualizarData(@PathVariable Long id, @RequestBody Data1 d) {
        Data1 data = dataService.findById(id);
        if (data == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                data.setIdMedico(d.getIdMedico());
                data.setValor(d.getValor());
                data.setVariable(d.getVariable());
                return new ResponseEntity<>(dataService.save(d), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Data1> eliminarDat(@PathVariable Long id) {
        dataService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
