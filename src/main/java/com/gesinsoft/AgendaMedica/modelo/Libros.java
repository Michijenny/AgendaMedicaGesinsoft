/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import jakarta.persistence.Column;
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
@Table(name = "libros")
public class Libros {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;
    @Column(unique = true)
    private String titulo;
    private String autor;
    private String edicion;
    private String ubicacion;
    private String estado;
    private String keywords;
    private String notas;
    private String compartido;
    private String digital;

    public Libros() {
    }

    public Libros(Integer idLibro, String titulo, String autor, String edicion, String ubicacion, String estado, String keywords, String notas, Long idDoctor, String compartido, String digital) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.keywords = keywords;
        this.notas = notas;
        this.compartido = compartido;
        this.digital = digital;
    }

    //RELACION CON LA TABLA LIBROS - DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor idDoctor;

}
