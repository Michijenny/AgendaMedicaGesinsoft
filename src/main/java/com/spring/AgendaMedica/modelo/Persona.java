/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author enriq
 */
@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    @Column(unique = true)
    private String documento;
    private String nombres;
    private String apellidos;
    private Date fechanacimiento;
    private String email;
    private String direccion;
    private String telefono;

    public Persona() {
    }

    public Persona(Integer idPersona, String documento, String nombres, String apellidos, Date fechanacimiento, String email, String direccion, String telefono, List<Usuario> usuario) {
        this.idPersona = idPersona;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    //RELACION PERSONA USUARIO
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;

}
