/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "imagenes")
public class Imagenes {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagen;
    private Date fecha;
    private String path;
    private String nota;
    private String tipo;
    private String firma;

    public Imagenes() {
    }

    public Imagenes(Integer idImagen, Integer idPaciente, Date fecha, String path, String nota, String tipo, String idAutor, String firma) {
        this.idImagen = idImagen;
        this.fecha = fecha;
        this.path = path;
        this.nota = nota;
        this.tipo = tipo;
        this.firma = firma;
    }

    //RELACION TABLA IMAGENES - PACIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor idAutor;

    //RELACION TABLA IMAGENES - DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idPaciente;

}
