package com.gesinsoft.AgendaMedica.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "turno")
public class Turno {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurno")
    private Integer id;
    private String turno;
    private LocalDateTime fecha;


    public Turno() {

    }

    public Turno(Integer id, String turno, LocalDateTime fecha) {
        this.id = id;
        this.turno = turno;
        this.fecha = fecha;

    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idpaciente", referencedColumnName = "idPaciente")
    private Paciente idPaciente;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddoctor", referencedColumnName = "idDoctor")
    private Doctor idDoctor;
}
