/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;


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
import jakarta.persistence.OneToOne;
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
    private String apellido;
    private String nombre;
    private String documento;
    private String fechanacimiento;
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
    private String campoCfg1;
    private String campoCfg2;
    private String campoCfg3;
    private String tipodocumento;
    private String abrir;
    private String genero;
    private String foto;
    //ESTOS ATRIBUTOS SE UILIZARA EN LA PARTE MOVIL
    private String username;
    private String password;        
    

    public Paciente() {
    }

    //RELACION CON LA TABLA ANTROPOMETRIA
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List<Antropometria> antropometria;

    
    //RELACION CON LA TABLA ARCHIVOS
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List<Archivos> archivo;

    //RELACION CON LA TABLA ODONTOLOGIA
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List<Odontologia> odontologia;

    //RELACION CON LA TABLA OFTALMOLOGIA
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List<Oftalmologia> oftalmologia;

    //RELACION CON LA TABLA PACIENTE / IMAGENES
    @JsonIgnore
    @OneToMany(mappedBy = "idPaciente")
    private List<Imagenes> imagenes;
    
    //RELACION CON LA TABLA PACIENTE / DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor idAutor;

    
    
}
