/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "doctor")
public class Doctor {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDoctor;
    @NotNull
    private String nombre;
    @NotNull
    private String clavesecreta;
    private String comentarios;
    private String direccion;
    @NotNull
    private String especialidad;
    private String telefono;
    @NotNull
    private String clave;
    private String notaAuto;
    private String nota;
    private String comparte;
    private String cfg;
    private String cfgsec;
    @NotNull
    private String email;

    public Doctor() {
    }

    public Doctor(Integer idDoctor, Integer idRol, String nombre, String clavesecreta, String comentarios, String direccion, String especialidad, String telefono, String clave, String notaAuto, String nota, String comparte, String cfg, String cfgsec, String email) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.clavesecreta = clavesecreta;
        this.comentarios = comentarios;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.clave = clave;
        this.notaAuto = notaAuto;
        this.nota = nota;
        this.comparte = comparte;
        this.cfg = cfg;
        this.cfgsec = cfgsec;
        this.email = email;

    }

    //RELACION CON LA TABLA DOCTOR - VADEMECUM}
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Vademecum> vademecum;

    //RELACION CON LA TABLA DOCTOR - VADECATEG
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Vadecateg> vadecateg;

    //RELACION CON LA TABLA DOCTOR - IMAGENES 
    @JsonIgnore
    @OneToMany(mappedBy = "idAutor")
    private List<Imagenes> imagenes;

    //RELACION LA TABLA DOCTOR - DATA
    @JsonIgnore
    @OneToMany(mappedBy = "idMedico")
    private List<Datas> data;

    //RELACION LA TABLA DOCTOR - IMAGENES
    @JsonIgnore
    @OneToMany(mappedBy = "idDoctor")
    private List<Libreta> libreta;
    
    //RELACION CON LA TABLA DOCTOR- LIBROS
    @JsonIgnore
    @OneToMany(mappedBy = "idDoctor")
    private List<Libros> libro;
    
    //RELACION CON LA TABLA DOCTOR - USUARIO
    /*@OneToMany(mappedBy = "doctor")
    private List<Usuario> usuarios;*/

    
    //RELACION CON LA TABLA DOCTOR - ODONTOLOGIA
    @JsonIgnore
    @OneToMany(mappedBy = "idDoctor")
    private List<Odontologia> odontologias;
    
    //RELACION CON LA TABLA DOCTOR - OFTALMOLOGIA
    @JsonIgnore
    @OneToMany(mappedBy = "idDoctor")
    private List<Oftalmologia> oftalmologias;
    
    //RELACION CON LA TABLA DOCTOR - ANTROPOMETRIA
    @JsonIgnore
    @OneToMany(mappedBy = "idDoctor")
    private List<Antropometria> antropometrias;
}
