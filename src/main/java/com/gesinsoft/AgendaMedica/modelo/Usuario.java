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
import jakarta.persistence.OneToMany;
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
   // private String username;
  //  private String password;
  //  private Boolean estado;
    
    
   // @Column(name = "idUsuario")
   // private Integer id;
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
    
    @OneToOne
    private Persona persona;
    
    @ManyToOne
    private Rol rol;
    

   /* public Usuario(Integer idUsuario, String username, String password, Boolean estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.estado = estado;
    }*/

   /* public Usuario(String username, String password, Boolean estado, Persona persona) {
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.persona = persona;
    }*/

  /*  public Usuario() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Persona persona;
    
    

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


    public Usuario(String nombre, String clavesecreta, String comentarios, String direccion, String especialidad, String telefono, String clave, String notaAuto, String nota, String comparte, String cfg, String cfgsec, String email, String matricula) {
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

    public Usuario() {
    }
    
    
    
    

}
