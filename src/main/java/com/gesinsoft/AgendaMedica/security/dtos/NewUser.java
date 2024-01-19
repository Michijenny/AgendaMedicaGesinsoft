/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.security.dtos;

//import com.gesinsoft.AgendaMedica.modelo.Persona;
//import com.gesinsoft.AgendaMedica.modelo.Rol;
//import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author enriq
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
//@AllArgsConstructor
public class NewUser {

    /*  @Setter
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
    }*/
    @Setter
    @Getter
    @NotBlank
    private String nombre;

    /*
    @Setter
    @Getter
    private String clavesecreta;

    @Setter
    @Getter
    private String comentarios;

    @Setter
    @Getter
    private String direccion;

    @Setter
    @Getter
    private String especialidad;

    @Setter
    @Getter
    private String telefono;

    @Setter
    @Getter*/
    private String clave;
/*
    @Setter
    @Getter
    private String notaAuto;

    @Setter
    @Getter
    private String nota;

    @Setter
    @Getter
    private String comparte;

    @Setter
    @Getter
    private String cfg;

    @Setter
    @Getter
    private String cfgsec;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String matricula;

    public NewUser(String nombre, String clavesecreta, String comentarios, String direccion, String especialidad, String telefono, String clave, String notaAuto, String nota, String comparte, String cfg, String cfgsec, String email, String matricula) {
        this.nombre = nombre;
        this.clavesecreta = clavesecreta;
        this.comentarios = comentarios;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.clave = clave;
        this.notaAuto = notaAuto;
        this.nota = nota;
        this.comparte = comparte;
        this.cfg = cfg;
        this.cfgsec = cfgsec;
        this.email = email;
        this.matricula = matricula;
    }

    public NewUser() {
    }
*/
}
