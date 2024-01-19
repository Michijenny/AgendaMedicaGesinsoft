package com.gesinsoft.AgendaMedica.security.dtos;



import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
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
