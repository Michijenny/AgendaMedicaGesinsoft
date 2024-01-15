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
@Table(name = "horarioMedico")
public class HorarioMedico {
     @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_horarioMedico;
    private boolean disponible;

    public HorarioMedico() {
    }

    public HorarioMedico(Integer id_horarioMedico, boolean disponible) {
        this.id_horarioMedico = id_horarioMedico;
        this.disponible = disponible;
    }
    
      //RELACION CON LA TABLA Horario
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    private Horario idhorario;
   
     //RELACION CON LA TABLA Doctor
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor iddoctor;
   
    //RELACION DE HORARIOMEDICO con doctor
    @JsonIgnore
    @OneToMany(mappedBy = "idhorarioM")
    private List <Turno> turno;

}
