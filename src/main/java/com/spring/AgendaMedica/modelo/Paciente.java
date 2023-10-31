/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
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
    private Integer idPaciente;
    private Integer idRol;
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
    private Long idDoctor;
    private String campoCfg1;
    private String campoCfg2;
    private String campoCfg3;
    private String tipodocumento;
    private String abrir;
    private String genero;
    


    public Paciente() {
    }

    public Paciente(Integer idPaciente, Integer idRol, String apellido, String nombre, String documento, Date fechanacimiento, String grupo, String sexo, String direccion, String cp, String obra, String afiliado, String telefono1, String telefono2, String telefono3, String clinicos, String diagnostico, String cormobilidades, String familiar, String comentarios, String extra1, String extra2, String extra3, String extra4, String extra5, String extra6, String extra7, String extra8, String extra9, String extra10, String civil, Long idDoctor, String campoCfg1, String campoCfg2, String campoCfg3, String tipodocumento, String abrir, String genero) {
        this.idPaciente = idPaciente;
        this.idRol = idRol;
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechanacimiento = fechanacimiento;
        this.grupo = grupo;
        this.sexo = sexo;
        this.direccion = direccion;
        this.cp = cp;
        this.obra = obra;
        this.afiliado = afiliado;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        this.clinicos = clinicos;
        this.diagnostico = diagnostico;
        this.cormobilidades = cormobilidades;
        this.familiar = familiar;
        this.comentarios = comentarios;
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.extra3 = extra3;
        this.extra4 = extra4;
        this.extra5 = extra5;
        this.extra6 = extra6;
        this.extra7 = extra7;
        this.extra8 = extra8;
        this.extra9 = extra9;
        this.extra10 = extra10;
        this.civil = civil;
        this.idDoctor = idDoctor;
        this.campoCfg1 = campoCfg1;
        this.campoCfg2 = campoCfg2;
        this.campoCfg3 = campoCfg3;
        this.tipodocumento = tipodocumento;
        this.abrir = abrir;
        this.genero = genero;
    }
    
    
    //RELACION CON LA TABLA ANTROPOMETRIA
    @JsonIgnore
    @OneToMany (mappedBy = "idPaciente")
    private List<Antropometria> antropometria;
    
    
    //RELACION CON LA TABLA ARCHIVOS
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List <Archivos> archivo;
    
    //RELACION CON LA TABLA ODONTOLOGIA
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List <Odontologia> odontologia;
    
    //RELACION CON LA TABLA OFTALMOLOGIA
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List <Oftalmologia> oftalmologia;
    
    //RELACION CON LA TABLA PACIENTE / IMAGENES
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List <Imagenes> imagenes;
    
    //RELACION CON LA TABLA PACIENTE USUARIO
    /*@OneToMany(mappedBy = "paciente")
    private List<Usuario> usuarios;*/

}
