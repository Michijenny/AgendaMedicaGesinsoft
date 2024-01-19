/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Persona;
import com.gesinsoft.AgendaMedica.service.PersonaServicelmpl;
import com.gesinsoft.AgendaMedica.servicios.PersonaService;
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
/*
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listarPersona() {
        return new ResponseEntity.ok(perService.findByAll());
    }
    */
    @GetMapping
    ResponseEntity<List<?>> list() {
        return ResponseEntity.ok(perService.findByAll());
    }

    
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(
            @RequestBody Persona p) {
        return new ResponseEntity<>(perService.save(p),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarAdministrador(@PathVariable Integer id) {
        perService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //LISTAR PERSONA POR ID
     @GetMapping("/listar/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable("id") Integer id){
        try {
            Persona nc = perService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PERSONA NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /*
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona p) {
        Persona per = perService.findById(id);
        if (per == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                per.setDocumento(p.getDocumento());
                per.setNombre(p.getNombre());
                per.setFechanacimiento(p.getFechanacimiento());
                per.setEmail(p.getEmail());
                per.setDireccion(p.getDireccion());
                per.setTelefono(p.getTelefono());
                return new ResponseEntity<>(perService.save(per), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    
}
    */
}
