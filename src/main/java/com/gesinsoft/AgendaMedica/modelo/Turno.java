package com.gesinsoft.AgendaMedica.modelo;


import jakarta.persistence.*;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "turno")
public class Turno {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurno")
    private Integer id;
    private Date fecha;
    private String motivo;
    private String ubicacion;
    private boolean finalizado;
  //  private LocalDateTime fecha;


    public Turno() {

    }

    public Turno(Integer id, Date fecha, String motivo, String ubicacion, boolean finalizado) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.ubicacion = ubicacion;
        this.finalizado = finalizado;            
    }

   /* public Turno(Integer id, String turno, LocalDateTime fecha) {
        this.id = id;
        this.turno = turno;
        this.fecha = fecha;

    }*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente idPaciente;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_horarioMedico", referencedColumnName = "id_horarioMedico")
    private HorarioMedico idhorarioM;

//   @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "iddoctor", referencedColumnName = "idDoctor")
//    private Doctor idDoctor;
    
}
