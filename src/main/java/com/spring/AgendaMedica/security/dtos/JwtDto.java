
package com.spring.AgendaMedica.security.dtos;


import com.spring.AgendaMedica.modelo.Usuario;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtDto {
    private String token;
    private Usuario userResponse;

    public JwtDto(String token) {
        this.token = token;
    }

    public JwtDto(String token, Usuario userResponse) {
        this.token = token;
        this.userResponse = userResponse;
    }

    

}
