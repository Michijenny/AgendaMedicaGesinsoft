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
import javax.validation.constraints.Size;

/**
 * s
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "data")
public class Datas {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idData;
    private String variables;
    private String valor;

    public Datas(Integer idData, String variable, String valor) {
        this.idData = idData;
        this.variables = variable;
        this.valor = valor;

    }

    public Datas() {
    }

    //RELACION DE LA TABLA DATA CON EL DOCTOR 
    //RELACION TABLA IMAGENES - PACIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor idMedico;

}
