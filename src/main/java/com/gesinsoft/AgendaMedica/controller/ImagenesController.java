/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.modelo.Imagenes;
import com.gesinsoft.AgendaMedica.servicios.ImagenesService;
import com.gesinsoft.AgendaMedica.servicios.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/imagenes")
@AllArgsConstructor
public class ImagenesController {
    
    
    @Autowired
    private final StorageService storageService;

    @Autowired
    private final HttpServletRequest request;

    @Autowired
    ImagenesService imagenService;

    @GetMapping("/listar")
    public ResponseEntity<List<Imagenes>> listarImagenes() {
        return new ResponseEntity<>(imagenService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Imagenes> crearImagen(
            @RequestBody Imagenes a,
            @RequestPart(value = "file", required = false) MultipartFile multipartFile,
            HttpServletRequest request) {
             if (multipartFile != null && !multipartFile.isEmpty()) {
            String path = storageService.store(multipartFile);
            String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
            String url = ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/api/usuarios/")
                    .path(path)
                    .toUriString();
            a.setPath(url);
        } else {
            // Establecer foto a nulo (o a una ruta predeterminada de foto nulo)
            a.setPath(null);
        }
        return new ResponseEntity<>(imagenService.save(a),
                HttpStatus.CREATED);
    }

    
    //ACTUALIZAR IMAGENES
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Imagenes> actualizarImagen(@PathVariable Integer id, @RequestBody Imagenes i,
            @RequestPart(value = "file", required = false) MultipartFile multipartFile,
            HttpServletRequest request) {
        Imagenes ima = imagenService.findById(id);
        if (ima == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ima.setId(i.getId());
                ima.setFecha(i.getFecha());
                ima.setNota(i.getNota());
                ima.setTipo(i.getTipo());
                ima.setFirma(i.getFirma());            
                //EDITAR LA IMAGEN
                //Atualizar la foto
                if (multipartFile != null && !multipartFile.isEmpty()) {
                    String path = storageService.store(multipartFile);
                    String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
                    String url = ServletUriComponentsBuilder
                            .fromHttpUrl(host)
                            .path("/api/usuarios/")
                            .path(path)
                            .toUriString();

                    // Eliminar la foto  anterior si existe
                    if (i.getPath() != null) {
                        String[] fotoParts = i.getPath().split("/");
                        String fotoFilename = fotoParts[fotoParts.length - 1];
                        storageService.delete(fotoFilename); // Elimina el archivo del almacenamiento
                    }

                    ima.setPath(url); // Actualiza la nueva foto
                } else if (i.getPath() != null) {
                    ima.setPath(i.getPath());
                } else {
                    ima.setPath(null); // Actualiza el avatar a null
                }
                return new ResponseEntity<>(imagenService.save(ima), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Imagenes> eliminarImagrn(@PathVariable Integer id) {
        imagenService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getImagenesById(@PathVariable("id") Integer id) {
        try {
            Imagenes nc = imagenService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("IMAGEN NO ENCONTRADA", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
