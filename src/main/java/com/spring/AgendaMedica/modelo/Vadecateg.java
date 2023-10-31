/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "vadecateg")
public class Vadecateg {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    @Column (unique = true)
    private String titulo;
    private String tipo;
    
    
    //CONSTRUCTORES
    public Vadecateg() {
    }

    public Vadecateg(Integer idCategoria, String titulo, String tipo) {
        this.idCategoria = idCategoria;
        this.titulo = titulo;
        this.tipo = tipo;
    }
    
    //RELACION CON LA TABLA VADECATEG/ DOCTOR 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idDoctor", referencedColumnName ="idDoctor")
    private Doctor doctor;
    
    //RELACION TABLA VADECATEG - VADEMECUM
    @JsonIgnore
    @OneToMany(mappedBy = "vadecateg")
    private List <Vademecum> vademecum;
    
    
}
