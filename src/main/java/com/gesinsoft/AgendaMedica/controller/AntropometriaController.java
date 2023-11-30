/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Antropometria;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gesinsoft.AgendaMedica.servicios.AntropometriaService;
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

/**
 *
 * @author enriq
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/antropometria")
public class AntropometriaController {

    @Autowired
    AntropometriaService antropometriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Antropometria>> listarAntropometria() {


        return new ResponseEntity<>(antropometriaService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Antropometria> crearAntropometria(
            @RequestBody Antropometria a) {
        return new ResponseEntity<>(antropometriaService.save(a),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Antropometria> actualizarAntropometria(@PathVariable Integer id, @RequestBody Antropometria a) {
        Antropometria ant = antropometriaService.findById(id);
        if (ant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ant.setIdAntropometria(a.getIdAntropometria());
                ant.setFecha(a.getFecha());
                ant.setEdad(a.getEdad());
                ant.setPeso(a.getPeso());
                ant.setTalla(a.getTalla());
                ant.setTronco(a.getTronco());
                ant.setDsuspino(a.getDsuspino());
                ant.setEnvergadura(a.getEnvergadura());
                ant.setBicipital(a.getBicipital());
                ant.setIleocristal(a.getIleocristal());
                ant.setSupraespinal(a.getSupraespinal());
                ant.setAxilar(a.getAxilar());
                ant.setAbdominal(a.getAbdominal());
                ant.setTricipital(a.getTricipital());
                ant.setSubescapular(a.getSubescapular());
                ant.setPectoral(a.getPectoral());
                ant.setGemelo(a.getGemelo());
                ant.setMuslofrontal(a.getMuslofrontal());
                ant.setHumeral(a.getHumeral());
                ant.setFemoral(a.getFemoral());
                ant.setBiacromial(a.getBiacromial());
                ant.setBiileocretideo(a.getBiileocretideo());
                ant.setToraxap(a.getToraxap());
                ant.setMuslo(a.getMuslo());
                ant.setTobillo(a.getTobillo());
                ant.setBiliacodi(a.getBiliacodi());
                ant.setMuneca(a.getMuneca());
                ant.setToraxtrans(a.getToraxtrans());
                ant.setCefalico(a.getCefalico());
                ant.setTorax(a.getTorax());
                ant.setAntebrazo(a.getAntebrazo());
                ant.setTobillo1(a.getTobillo1());
                ant.setCintura(a.getCintura());
                ant.setCuello(a.getCuello());
                ant.setBicipitalrel(a.getBicipitalrel());
                ant.setBicitalflex(a.getBicitalflex());
                ant.setMuslo1(a.getMuslo1());
                ant.setCadera(a.getCadera());
                ant.setMuneca1(a.getMuneca1());
                ant.setGemelo1(a.getGemelo1());
                ant.setAbdomen(a.getAbdomen());
                ant.setAcroestiloide(a.getAcroestiloide());
                ant.setMedioestdact(a.getMedioestdact());
                ant.setTrocanterea(a.getTrocanterea());
                ant.setTribiallateral(a.getTribiallateral());
                ant.setTibMdMaleolar(a.getTibMdMaleolar());
                ant.setAcroradial(a.getAcroradial());
                ant.setIlioespinal(a.getIlioespinal());
                ant.setTrocTipLat(a.getTrocTipLat());
                ant.setPie(a.getPie());
                ant.setAnotaciones(a.getAnotaciones());
                ant.setPrescripciones(a.getPrescripciones());
                ant.setIdPaciente(a.getIdPaciente());
                return new ResponseEntity<>(antropometriaService.save(ant), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Antropometria> eliminarAntropometria(@PathVariable Integer id) {
        antropometriaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getAntropometriaById(@PathVariable("id") Integer id) {
        try {
            Antropometria nc = antropometriaService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("ANTROPOMETRIA NO ENCONTRADO", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
