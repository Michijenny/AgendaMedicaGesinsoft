/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
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
@Table(name = "tratamiento")
public class Tratamiento {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_tratamiento;
    private Date fecha;
    private String indicacion;
    private String duracion;
    private String resultado;

    public Tratamiento() {
    }

    public Tratamiento(Integer id_tratamiento, Date fecha, String indicacion, String duracion, String resultado) {
        this.id_tratamiento = id_tratamiento;
        this.fecha = fecha;
        this.indicacion = indicacion;
        this.duracion = duracion;
        this.resultado = resultado;
    }

    //RELACION CON LA TABLA paciente
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idpaciente;

    //RELACION DE TRATAMIENTO CON RECETA
    @JsonIgnore
    @OneToMany(mappedBy = "idtratamiento")
    private List<Recetas> recetas;
}
