/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Persona;
import com.spring.AgendaMedica.service.PersonaServicelmpl;
import com.spring.AgendaMedica.servicios.PersonaService;
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
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    PersonaService perService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listarPersona() {
        return new ResponseEntity<>(perService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(
            @RequestBody Persona p) {
        return new ResponseEntity<>(perService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona p) {
        Persona per = perService.findById(id);
        if (per == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                per.setCedula(p.getCedula());
                per.setPrimerNombre(p.getPrimerNombre());
                per.setPrimerApellido(p.getPrimerApellido());
                per.setSegundoNombre(p.getSegundoApellido());
                per.setGenero(p.getGenero());
                per.setFechanacimiento(p.getFechanacimiento());
                per.setCorreo(p.getCorreo());
                per.setDireccion(p.getDireccion());
                per.setTelefono(p.getTelefono());
                return new ResponseEntity<>(perService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarAdministrador(@PathVariable Long id) {
        perService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
