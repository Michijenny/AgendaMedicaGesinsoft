/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "historias")
public class Historias {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoria;
    private Integer idPaciente;
    private Date fecha;
    private String nota;
    private String idAutor;
    private String firma;

    public Historias() {
    }

    public Historias(Integer idHistoria, Integer idPaciente, Date fecha, String nota, String idAutor, String firma) {
        this.idHistoria = idHistoria;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.nota = nota;
        this.idAutor = idAutor;
        this.firma = firma;
    }

}
