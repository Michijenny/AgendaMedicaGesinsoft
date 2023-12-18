package com.gesinsoft.AgendaMedica.security.dtos;



import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginUser {

   /* @NotBlank
    private String username;
    @NotBlank
    private String password;*/

    
    @NotBlank
    private String nombre;
    @NotBlank
    private String clavesecreta;
}
