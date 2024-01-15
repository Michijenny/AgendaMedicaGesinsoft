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
@Table(name = " archivos")
public class Archivos {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchivo;
    private String nombre;
    private String tipoArchivo;
    private Long tamano;
    private String ruta;
    private String storage;

    public Archivos() {
    }

    public Archivos(Integer idArchivo, String nombre, String tipoArchivo, Long tamano, String ruta, String storage, Paciente idPaciente) {
        this.idArchivo = idArchivo;
        this.nombre = nombre;
        this.tipoArchivo = tipoArchivo;
        this.tamano = tamano;
        this.ruta = ruta;
        this.storage = storage;
        this.idPaciente = idPaciente;
    }

    //RELACION LA TABLA ARCHIVOS CON PACIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idPaciente;

}
