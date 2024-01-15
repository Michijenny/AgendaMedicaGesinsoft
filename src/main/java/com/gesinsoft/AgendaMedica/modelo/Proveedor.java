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
import jakarta.persistence.OneToMany;
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
@Table(name = "proveedor")
public class Proveedor {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedor")
    private Integer id;
    private String nombre;
    private String telefono;
    private String celular;
    private String email;
    private String web;
    private String direccion;
    private String notas;

    public Proveedor() {
    }

    public Proveedor(Integer id, String nombre, String telefono, String celular, String email, String web, String direccion, String notas) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.web = web;
        this.direccion = direccion;
        this.notas = notas;
    }

      //RELACION DE Proveedor CON PROVEEDORDOCTOR
    @JsonIgnore
    @OneToMany(mappedBy = "idproveedor")
    private List <ProveedorDoctor> proveedorD;


}
