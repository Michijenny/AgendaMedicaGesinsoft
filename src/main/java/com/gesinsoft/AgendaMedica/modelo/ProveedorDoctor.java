/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import jakarta.persistence.Column;
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

/**
 *
 * @author USUARIO
 */
@Data
@Entity
@Table(name = "proveedorDoctor")
public class ProveedorDoctor {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ProveedorD;

    public ProveedorDoctor() {
    }

    public ProveedorDoctor(Integer id_ProveedorD) {
        this.id_ProveedorD = id_ProveedorD;
    }
    
     //RELACION CON LA TABLA Doctor
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor iddoctor;
   
   //RELACION CON LA TABLA proveedor
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    private Proveedor idproveedor;
   
}
