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
@Table(name = "horario")
public class Horario {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_horario;
    private String dia;
    private String hora_inicio;
    private String hora_fin;

    public Horario() {
    }

    public Horario(Integer id_horario, String dia, String hora_inicio, String hora_fin) {
        this.id_horario = id_horario;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }
    
     //RELACION DE HORARIO CON HORARIOMEDICO
    @JsonIgnore
    @OneToMany(mappedBy = "idhorario")
    private List <HorarioMedico> horarioMedico;

}
