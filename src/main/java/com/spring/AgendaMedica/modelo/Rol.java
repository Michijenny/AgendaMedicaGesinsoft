/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "rol")
public class Rol {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private RolNombres rolNombre;
    
    //RELACION 
    @ManyToMany (mappedBy = "roles")
    private List <Usuario> usuarios;
    
   
    
    

   

    
    
    

}
