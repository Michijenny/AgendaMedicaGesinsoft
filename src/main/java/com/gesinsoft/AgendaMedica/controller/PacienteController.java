/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Paciente;
import com.gesinsoft.AgendaMedica.service.PacienteServicelmpl;
import com.gesinsoft.AgendaMedica.servicios.PacienteService;
import com.gesinsoft.AgendaMedica.servicios.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author enriq
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/paciente")
@AllArgsConstructor
public class PacienteController {

    @Autowired
    private final StorageService storageService;

    @Autowired
    private final HttpServletRequest request;

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listarPaciente() {
        return new ResponseEntity<>(pacienteService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Paciente> crearPaciente(
            @RequestBody Paciente p,
            @RequestPart(value = "file", required = false) MultipartFile multipartFile,
            HttpServletRequest request) {
        //Ingreso de la foto del paciente    
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String path = storageService.store(multipartFile);
            String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
            String url = ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/api/usuarios/")
                    .path(path)
                    .toUriString();
            p.setFoto(url);
        } else {
            // Establecer foto a nulo (o a una ruta predeterminada de foto nulo)
            p.setFoto(null);
        }

        return new ResponseEntity<>(pacienteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Integer id, @RequestBody Paciente p) {
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
                pac.setCampoCfg1(p.getCampoCfg1());
                pac.setCampoCfg2(p.getCampoCfg2());
                pac.setCampoCfg3(p.getCampoCfg3());
                pac.setTipodocumento(p.getTipodocumento());
                pac.setAbrir(p.getAbrir());
                pac.setGenero(p.getGenero());
                return new ResponseEntity<>(pacienteService.save(pac), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Paciente> eliminarPaciente(@PathVariable Integer id) {
        pacienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getPacienteById(@PathVariable("id") Integer id) {
        try {
            Paciente nc = pacienteService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PACIENTE NO ENCONTRADO", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo que permitir subir un archivo o imagen
    @PostMapping("/upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String path = storageService.store(multipartFile);
        System.out.println("Ruta de almacenamiento: " + path);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/api/paciente/")
                .path(path)
                .toUriString();
        return Map.of("url", url);
    }

    //Metodo para recuperar la imagen desde el sistema de archivos
    @GetMapping("{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);

    }

}
