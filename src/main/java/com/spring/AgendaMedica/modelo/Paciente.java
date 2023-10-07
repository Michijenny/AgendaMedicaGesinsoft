/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "paciente")
public class Paciente {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private Long idRol;
    private String apellido;
    private String nombre;
    private String documento;
    private Date fechanacimiento;
    private String grupo;
    private String sexo;
    private String direccion;
    private String cp;
    private String obra;
    private String afiliado;
    private String telefono1;
    private String telefono2;
    private String telefono3;
    private String clinicos;
    private String diagnostico;
    private String cormobilidades;
    private String familiar;
    private String comentarios;
    private String extra1;
    private String extra2;
    private String extra3;
    private String extra4;
    private String extra5;
    private String extra6;
    private String extra7;
    private String extra8;
    private String extra9;
    private String extra10;
    private String civil;
    private Long id_doctor;
    private String campoCfg_1;
    private String campoCfg_2;
    private String campoCfg_3;
    private String tipodocumento;
    private String abrir;
    private String field;

}
