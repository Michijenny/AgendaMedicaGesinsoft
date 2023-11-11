/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import com.spring.AgendaMedica.modelo.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author enriq
 */
@Data
@Entity
@Table(name = "administrador")
public class Administrador {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrador;
    
    //RELACION CON LA TABLA ADMINISTRADOR USUARIO 
    /*@OneToMany(mappedBy = "administrador")
    private List<Usuario> usuarios;*/
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    

}
