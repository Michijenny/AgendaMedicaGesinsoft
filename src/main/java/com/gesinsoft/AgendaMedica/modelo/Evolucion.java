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
@Table(name = "evolucion")
public class Evolucion {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_evolucion;
    private Date fecha;
    private double altura;
    private String sesiones;
    private String resultados;
    private String item6;
    private String item7;
    private String notas;

    public Evolucion() {
    }

    public Evolucion(Integer id_evolucion, Date fecha, double altura, String sesiones, String resultados, String item6, String item7, String notas) {
        this.id_evolucion = id_evolucion;
        this.fecha = fecha;
        this.altura = altura;
        this.sesiones = sesiones;
        this.resultados = resultados;
        this.item6 = item6;
        this.item7 = item7;
        this.notas = notas;
    }

    //RELACION CON LA TABLA paciente
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idpaciente;
}
