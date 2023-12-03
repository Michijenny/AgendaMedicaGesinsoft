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

    public Turno() {

    }

    public Turno(Integer id, String turno, String fecha) {
        this.id = id;
        this.turno = turno;
        this.fecha = fecha;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "idTurno")
    private List<Paciente> paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddoctor", referencedColumnName = "idDoctor")
    private Doctor idDoctor;
}
