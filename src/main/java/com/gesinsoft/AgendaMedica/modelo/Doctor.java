/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    @Column(name = "idDoctor")
    private Integer id;
    private String nombre;
    private String clavesecreta;
    private String comentarios;
    private String direccion;
    private String especialidad;
    private String telefono;
    private String clave;
    private String notaAuto;
    private String nota;
    private String comparte;
    private String cfg;
    private String cfgsec;
    private String email;
    private String matricula;

    public Doctor() {
    }

    public Doctor(Integer id, Integer idRol, String nombre, String clavesecreta, String comentarios, String direccion, String especialidad, String telefono, String clave, String notaAuto, String nota, String comparte, String cfg, String cfgsec, String email, String matricula) {
        this.id = id;
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
        this.matricula = matricula;

    }

    //RELACION CON LA TABLA DOCTOR - VADEMECUM}
    @JsonIgnore
    @OneToMany(mappedBy = "iddoctor")
    private List<Vademecum> vademecum;

    //RELACION CON LA TABLA DOCTOR - VADECATEG
    @JsonIgnore
    @OneToMany(mappedBy = "iddoctor")
    private List<Vadecateg> vadecateg;

    //RELACION CON LA TABLA DOCTOR - IMAGENES 
    @JsonIgnore
    @OneToMany(mappedBy = "id_autor")
    private List<Imagenes> imagenes;

    //RELACION LA TABLA DOCTOR - DATA
    @JsonIgnore
    @OneToMany(mappedBy = "iddoctor")
    private List<Datas> data;


    //RELACION CON LA TABLA DOCTOR- LIBROS
    @JsonIgnore
    @OneToMany(mappedBy = "iddoctor")
    private List<Libros> libro;

    //RELACION DE DOCTOR CON PACIENTE
    @JsonIgnore
    @OneToMany(mappedBy = "id_autor")
    private List <Paciente> paciente;
    
  
    //RELACION CON LA TABLA DOCTOR /USUARIO
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario user;
}
