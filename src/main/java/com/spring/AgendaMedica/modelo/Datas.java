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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Size;

/**
 *s
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
    @Size(max = 100, message = "La variable no puede contener mas de 100 caracteres")
    private String variable;
    @Size(max = 300, message = "El valor no puede contener mas de 300 caracteres")
    private String valor;
    private Long idMedico;

    public Datas(Integer idData, String variable, String valor, Long idMedico) {
        this.idData = idData;
        this.variable = variable;
        this.valor = valor;
        this.idMedico = idMedico;
    }

    public Datas() {
    }

}
