/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;
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
    private Integer id;
    private Integer idDoctor;
    @NotNull
    private String compartido;
    private String laboratorio;
    private String medicamento;
    private String composicion;
    private String indicaciones;
    private String contraindicaciones;
    private String posologia;
    private Long idCategoria;
    private String equivalencias;
    private String anotaciones;
    private int stock;
    
    //CONSTRUCTORES

    public Vademecum() {
    }

    public Vademecum(Integer id, Integer idDoctor, String compartido, String laboratorio, String medicamento, String composicion, String indicaciones, String contraindicaciones, String posologia, Long idCategoria, String equivalencias, String anotaciones, int stock) {
        this.id = id;
        this.idDoctor = idDoctor;
        this.compartido = compartido;
        this.laboratorio = laboratorio;
        this.medicamento = medicamento;
        this.composicion = composicion;
        this.indicaciones = indicaciones;
        this.contraindicaciones = contraindicaciones;
        this.posologia = posologia;
        this.idCategoria = idCategoria;
        this.equivalencias = equivalencias;
        this.anotaciones = anotaciones;
        this.stock = stock;
    }
    
    

}
