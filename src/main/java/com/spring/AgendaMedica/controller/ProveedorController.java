/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Proveedor;
import com.spring.AgendaMedica.service.ProveedorServicelmpl;
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
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorServicelmpl proveedorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Proveedor>> listarProveedor() {
        return new ResponseEntity<>(proveedorService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Proveedor> crearProveedor(
            @RequestBody Proveedor p) {
        return new ResponseEntity<>(proveedorService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor p) {
        Proveedor pro = proveedorService.findById(id);
        if (pro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                pro.setServicio(p.getServicio());
                pro.setTelefono1(p.getTelefono1());
                pro.setTelefono2(p.getTelefono2());
                pro.setSitioweb(p.getSitioweb());
                pro.setDireccion(p.getDireccion());
                pro.setAnotaciones(p.getAnotaciones());
                return new ResponseEntity<>(proveedorService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Proveedor> eliminarProveedor(@PathVariable Long id) {
        proveedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
