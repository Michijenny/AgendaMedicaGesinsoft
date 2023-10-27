/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

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
@Table(name = "odontologia")
public class Odontologia {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOdontologia;
    private String fecha;
    private Integer numerodiente;
    private String marca;
    private String referecia1;
    private String referencia2;
    private String referencia3;
    private String referencia4;
    private String referencia5;
    private String anotaciones;

    public Odontologia() {
    }

    public Odontologia(Integer idOdontologia, String fecha, Integer numerodiente, String marca, String referecia1, String referencia2, String referencia3, String referencia4, String referencia5, String anotaciones) {
        this.idOdontologia = idOdontologia;
        this.fecha = fecha;
        this.numerodiente = numerodiente;
        this.marca = marca;
        this.referecia1 = referecia1;
        this.referencia2 = referencia2;
        this.referencia3 = referencia3;
        this.referencia4 = referencia4;
        this.referencia5 = referencia5;
        this.anotaciones = anotaciones;
    }
    
    //RELACION CON LA TABLA PACIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPaciente", referencedColumnName ="idPaciente")
    private Paciente paciente;

    
    
    

}
