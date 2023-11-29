/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.security.dtos;

import com.gesinsoft.AgendaMedica.modelo.Persona;
import com.gesinsoft.AgendaMedica.modelo.Rol;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author enriq
 */

@AllArgsConstructor
public class NewUser {
    
    @Setter
    @Getter
    
    @NotBlank
    private String username;
    
    @Setter
    @Getter

    @NotBlank
    private String password;
    
    @Setter
    @Getter
    private Boolean estado;
    
    @Setter
    @Getter
    private Persona persona;

    @Setter
    @Getter
    private List<Rol> roles;

    public NewUser(String username, String password, Boolean estado, Persona persona) {
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.persona = persona;
    }

    public NewUser() {
    }
    
    
    
}
