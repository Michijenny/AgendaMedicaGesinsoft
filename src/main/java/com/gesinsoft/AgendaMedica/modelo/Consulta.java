/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_consulta;
    private Date fecha;
    private String motivo;
    private String comentario;

    public Consulta() {
    }

    public Consulta(Integer id_consulta, Date fecha, String motivo, String comentario) {
        this.id_consulta = id_consulta;
        this.fecha = fecha;
        this.motivo = motivo;
        this.comentario = comentario;
    }

    //RELACION CON LA TABLA paciente
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idpaciente;
}
