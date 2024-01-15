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
@Table(name = "vademecum")
public class Vademecum {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVademecum")
    private Integer id;
    private String compartido;
    private String laboratorio;
    private String medicamento;
    private String composicion;
    private String indicaciones;
    private String contraindicaciones;
    private String posologia;
    private String equivalencias;
    private String anotaciones;
    private int stock;

    //CONSTRUCTORES
    public Vademecum() {
    }

    public Vademecum(Integer id, String compartido, String laboratorio, String medicamento, String composicion, String indicaciones, String contraindicaciones, String posologia, String equivalencias, String anotaciones, int stock) {
        this.id = id;
        this.compartido = compartido;
        this.laboratorio = laboratorio;
        this.medicamento = medicamento;
        this.composicion = composicion;
        this.indicaciones = indicaciones;
        this.contraindicaciones = contraindicaciones;
        this.posologia = posologia;
        this.equivalencias = equivalencias;
        this.anotaciones = anotaciones;
        this.stock = stock;
    }

//    //RELACION CON LA TABLA VADEMECUM / DOCTOR
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
//    private Doctor iddoctor;

    //RELACION CON LA TABLA VADEMECUM - VADECATEG
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idVadecateg", referencedColumnName = "idVadecateg")
    private Vadecateg id_categoria;

}
