package com.gesinsoft.AgendaMedica.controller;



import com.gesinsoft.AgendaMedica.modelo.Turno;
import com.gesinsoft.AgendaMedica.servicios.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/turno")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Turno>> listarTurno() {
        return new ResponseEntity<>(turnoService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Turno> crearTurno(
            @RequestBody Turno d) {
        return new ResponseEntity<>(turnoService.save(d),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Turno> actualizarTurno(@PathVariable Integer id, @RequestBody Turno d) {
        Turno tur = turnoService.findById(id);
        if (tur == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {

                tur.setFecha(d.getFecha());
                tur.setTurno(d.getTurno());


                return new ResponseEntity<>(turnoService.save(tur), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Turno> eliminarTurno(@PathVariable Integer id) {
        turnoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getTurnoById(@PathVariable("id") Integer id) {
        try {
            Turno nc = turnoService.findById(id);
            if (nc != null) {
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("DOCTOR NO ENCONTRADO ", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
