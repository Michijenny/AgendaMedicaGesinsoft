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
    private Integer idRol;
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
    private String extraAsister;
    private String field;

    //RELACION CON LA TABLA VADECATEG
//    @JsonIgnore
//    @OneToMany(mappedBy = "idDoctor")
//    private List <Vadecateg> listaCategoria;
    //RELACION CON LA TABLA LIBROS
//    @JsonIgnore
//    @OneToMany (mappedBy = "idDotor")
//    private List<Libros> listaLibros;
    //RELACION CON LA TABLA DATA
//    @JsonIgnore
//    @OneToMany (mappedBy = "idMedico")
//    private List <Data1> listaData;
    //RELACION CON LA TABLA VADEMECUM
//    @JsonIgnore
//    @OneToMany (mappedBy = "idDoctor")
//    private List <Vademecum> listaVade;
    public Doctor() {
    }

    public Doctor(Integer idDoctor, Integer idRol, String nombre, String clavesecreta, String comentarios, String direccion, String especialidad, String telefono, String clave, String notaAuto, String nota, String comparte, String cfg, String cfgsec, String email, String extraAsister, String field) {
        this.idDoctor = idDoctor;
        this.idRol = idRol;
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
        this.extraAsister = extraAsister;
        this.field = field;
    }

}
