/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.spring.AgendaMedica.modelo.Paciente;
import com.spring.AgendaMedica.service.PacienteServicelmpl;
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
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteServicelmpl pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listarPaciente() {
        return new ResponseEntity<>(pacienteService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Paciente> crearPaciente(
            @RequestBody Paciente p) {
        return new ResponseEntity<>(pacienteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente p) {
        Paciente pac = pacienteService.findById(id);
        if (pac == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                pac.setApellido(p.getApellido());
                pac.setNombre(p.getNombre());
                pac.setDocumento(p.getDocumento());
                pac.setFechanacimiento(p.getFechanacimiento());
                pac.setGrupo(p.getGrupo());
                pac.setSexo(p.getSexo());
                pac.setDireccion(p.getDireccion());
                pac.setCp(p.getCp());
                pac.setObra(p.getObra());
                pac.setAfiliado(p.getAfiliado());
                pac.setTelefono1(p.getTelefono1());
                pac.setTelefono2(p.getTelefono2());
                pac.setTelefono3(p.getTelefono3());
                pac.setClinicos(p.getClinicos());
                pac.setDiagnostico(p.getDiagnostico());
                pac.setCormobilidades(p.getCormobilidades());
                pac.setFamiliar(p.getFamiliar());
                pac.setComentarios(p.getComentarios());
                pac.setExtra1(p.getExtra1());
                pac.setExtra2(p.getExtra2());
                pac.setExtra3(p.getExtra3());
                pac.setExtra4(p.getExtra4());
                pac.setExtra5(p.getExtra5());
                pac.setExtra6(p.getExtra6());
                pac.setExtra7(p.getExtra7());
                pac.setExtra8(p.getExtra8());
                pac.setExtra9(p.getExtra9());
                pac.setExtra10(p.getExtra10());
                pac.setCivil(p.getCivil());
                pac.setId_doctor(p.getId_doctor());
                pac.setCampo_cfg_1(p.getCampo_cfg_1());
                pac.setCampo_cfg_2(p.getCampo_cfg_2());
                pac.setCampo_cfg_3(p.getCampo_cfg_3());
                pac.setTipodocumento(p.getTipodocumento());
                pac.setAbrir(p.getAbrir());
                pac.setField(p.getField());
                return new ResponseEntity<>(pacienteService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Paciente> eliminarPaciente(@PathVariable Long id) {
        pacienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
