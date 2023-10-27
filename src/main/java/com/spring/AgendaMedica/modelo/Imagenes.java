/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
    private Integer idPaciente;
    private Date fecha;
    private String path;
    private String nota;
    private String tipo;
    private String idAutor;
    private String firma;

    public Imagenes() {
    }

    public Imagenes(Integer idImagen, Integer idPaciente, Date fecha, String path, String nota, String tipo, String idAutor, String firma) {
        this.idImagen = idImagen;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.path = path;
        this.nota = nota;
        this.tipo = tipo;
        this.idAutor = idAutor;
        this.firma = firma;
    }

}
