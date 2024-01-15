/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
@Table(name = "doctorPaciente")
public class DoctorPaciente {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_doctorPaciente;
    private Date fecha;

    public DoctorPaciente() {
    }

    public DoctorPaciente(Integer id_doctorPaciente, Date fecha) {
        this.id_doctorPaciente = id_doctorPaciente;
        this.fecha = fecha;
    }

     //RELACION CON LA TABLA Doctor
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor iddoctor;
    
      //RELACION CON LA TABLA PACIENTE
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idpaciente;
}
