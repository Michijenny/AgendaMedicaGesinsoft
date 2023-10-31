/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
import lombok.Data;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table (name= "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private boolean estado;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPersona", referencedColumnName ="idPersona")
    private Persona persona;
    
    //
    /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Rol> roles;
*/
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idRol"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "idUsuario", "idRol" })
    )
    private List<Rol> roles;

    public Usuario(Integer idUsuario, String NombreUsuario, String contraseña, boolean estado, Persona persona, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = NombreUsuario;
        this.contraseña = contraseña;
        this.estado = estado;
        this.persona = persona;
        this.roles = roles;
    }

    public Usuario() {
    }
    
    //RELACION TABLA USUARIO - ADMINISTRADOR
   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idAdministrador", referencedColumnName ="idAdministrador")
    private Administrador administrador;
    
    
    //RELACION TABLA USUARIO - PACIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPaciente", referencedColumnName ="idPaciente")
    private Paciente paciente;
    
    
    //RELACION TABLA USUARIO - DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idDoctor", referencedColumnName ="idDoctor")
    private Doctor doctor;*/
    
    
    
    
    
}
