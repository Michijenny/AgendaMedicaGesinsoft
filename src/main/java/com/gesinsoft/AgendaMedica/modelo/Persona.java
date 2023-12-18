/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
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
    private String nombre;
    private String fechanacimiento;
    private String email;
    private String direccion;
    private String telefono;

    public Persona() {
    }

    public Persona(Integer idPersona, String documento, String nombre, String fechanacimiento, String email, String direccion, String telefono) {
        this.idPersona = idPersona;
        this.documento = documento;
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //RELACION PERSONA USUARIO
   /* @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;*/

}
