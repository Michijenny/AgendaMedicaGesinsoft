/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Odontologia;
import com.spring.AgendaMedica.modelo.Rol;
import com.spring.AgendaMedica.servicios.OdontologiaService;
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
@RequestMapping("/api/odontologia")
public class OdontologiaController {

    @Autowired
    OdontologiaService odontologiaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Odontologia>> listarOdontologia() {
        return new ResponseEntity<>(odontologiaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Odontologia> crearOdontologia(
            @RequestBody Odontologia o) {
        return new ResponseEntity<>(odontologiaService.save(o),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Odontologia> actualizarOdontologia(@PathVariable Integer id, @RequestBody Odontologia o) {
        Odontologia odon = odontologiaService.findById(id);
        if (odon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                odon.setFecha(o.getFecha());
                odon.setNumerodiente(o.getNumerodiente());
                odon.setMarca(o.getMarca());
                odon.setReferecia1(o.getReferecia1());
                odon.setReferencia2(o.getReferencia2());
                odon.setReferencia3(o.getReferencia3());
                odon.setReferencia4(o.getReferencia4());
                odon.setReferencia5(o.getReferencia5());
                odon.setAnotaciones(o.getAnotaciones());
                return new ResponseEntity<>(odontologiaService.save(o), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Odontologia> eliminarOdontologia(@PathVariable Integer id) {
        odontologiaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getOdontologiaById(@PathVariable("id") Integer id) {
        try {
            Odontologia nc = odontologiaService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("ODONTOLOGIA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
