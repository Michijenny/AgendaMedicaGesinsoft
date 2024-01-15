/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

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

/**
 *
 * @author USUARIO
 */
@Data
@Entity
@Table(name = "provincias")
public class Provincia {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer id_provincia;
    private String nombre;

    
    public Provincia() {
    }

    public Provincia(Integer id_provincia, String nombre) {
        this.id_provincia = id_provincia;
        this.nombre = nombre;
    }
    
     //RELACION DE PROVINCIA CON CIUDAD     
    @JsonIgnore
    @OneToMany(mappedBy = "idprovincia")
    private List <Ciudad> ciudad;
}
