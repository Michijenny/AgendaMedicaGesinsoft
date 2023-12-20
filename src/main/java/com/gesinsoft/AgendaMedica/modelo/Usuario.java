/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "usuario")
public class Usuario {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String username;
    private String password;
    private Boolean estado;

    public Usuario(Integer idUsuario, String username, String password, Boolean estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.estado = estado;
    }

    public Usuario(String username, String password, Boolean estado) {
        this.username = username;
        this.password = password;
        this.estado = estado;
    }

    public Usuario() {
        
    }

    
    //RELACION DE LA TABLA USUARIO - PERSONA
    /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Persona persona;
    
    
//CREACION DE LA TABLA USERS_ROLES
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idRol"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"idUsuario", "idRol"})
    )
    
    private List<Rol> roles;*/
    
    
    //RELACION USUARIO - DOCTOR
    /* @OneToOne(mappedBy = "user")
    private Doctor doctor;*/
    //RELACION USUARIO - ADMINISTRADOR
    /* @OneToOne(mappedBy = "user")
    private Administrador administrador;*/
}
