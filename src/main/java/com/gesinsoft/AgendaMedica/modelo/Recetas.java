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
@Table(name = "recetas")
public class Recetas {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReceta")
    private Integer id;
    private String fecha;
    private String nombreMedicamento;
    private String cantidadMedicamento;
    private String prescripcion;
    private String duracionTratamiento;
    private String diagnostico;

    public Recetas() {
    }

//    public Recetas(Integer id, String fecha, String nombreMedicamento, String cantidadMedicamento, String prescripcion, String duracionTratamiento, String diagnostico) {
//        this.id = id;
//        this.fecha = fecha;
//        this.nombreMedicamento = nombreMedicamento;
//        this.cantidadMedicamento = cantidadMedicamento;
//        this.prescripcion = prescripcion;
//        this.duracionTratamiento = duracionTratamiento;
//        this.diagnostico = diagnostico;
//    }

    //RELACIONES
    ////RELACION CON LA TABLA RECETAS / DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor id_autor;
    
    ////RELACION CON LA TABLA RECETAS / DOCTOR
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idpaciente;
}
