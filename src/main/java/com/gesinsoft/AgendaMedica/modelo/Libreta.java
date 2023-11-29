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
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "libreta")
public class Libreta {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibreta;
    private String nombre;
    @Size(max = 10, message = "El telefono no puede contener mas de 10 caracteres")
    private String telefono;
    @Size(max = 10, message = "El celular no puede contener mas de 30 caracteres")
    private String celular;
    @Size(max = 30, message = "El email no puede contener mas de 30 caracteres")
    private String email;
    @Size(max = 30, message = "Web no puede contener mas de 30 caracteres")
    private String web;
    @Size(max = 50, message = "La direccion no puede contener mas de 50 caracteres")
    private String direccion;
    private String notas;

    public Libreta() {
    }

    public Libreta(Integer idLibreta, String nombre, String telefono, String celular, String email, String web, String direccion, String notas) {
        this.idLibreta = idLibreta;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.web = web;
        this.direccion = direccion;
        this.notas = notas;
    }

    //RELACION LIBRETA - DOCTOR 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor idDoctor;

}
