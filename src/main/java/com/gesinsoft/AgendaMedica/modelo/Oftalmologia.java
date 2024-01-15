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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "oftalmologia")
public class Oftalmologia {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idOftamologia;
    private String fecha;
    private String resultado;
    private String examenes;
    private String exploracion;
    private String ojoizquierdo;
    private String ojoderecho;
    private String anotaciones;

    public Oftalmologia() {
    }

    public Oftalmologia(Integer idOftamologia, String fecha, String resultado, String examenes, String exploracion, String ojoizquierdo, String ojoderecho, String anotaciones) {
        this.idOftamologia = idOftamologia;
        this.fecha = fecha;
        this.resultado = resultado;
        this.examenes = examenes;
        this.exploracion = exploracion;
        this.ojoizquierdo = ojoizquierdo;
        this.ojoderecho = ojoderecho;
        this.anotaciones = anotaciones;
    }



    //RELACION CON LA TABLA PACIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idPaciente;

    //RELACION CON LA TABLA DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor id_autor;
}
