/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.security.dtos;

import com.spring.AgendaMedica.modelo.Persona;
import com.spring.AgendaMedica.modelo.Rol;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author enriq
 */
@Setter
@Getter
@AllArgsConstructor
public class NewUser {
    
     @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Persona persona;

    private List<Rol> roles;
}
