package com.gesinsoft.AgendaMedica.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
    private String fecha;
    private String hora;

    public Turno() {

    }

    public Turno(Integer id, String turno, String fecha,String hora) {
        this.id = id;
        this.turno = turno;
        this.fecha = fecha;
        this.hora = hora;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idpaciente", referencedColumnName = "idPaciente")
    private Paciente paciente;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddoctor", referencedColumnName = "idDoctor")
    private Doctor idDoctor;
}
//11