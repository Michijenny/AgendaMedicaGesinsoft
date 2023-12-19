
package com.gesinsoft.AgendaMedica.security.dtos;


import com.gesinsoft.AgendaMedica.modelo.Usuario;
import lombok.Getter;
import lombok.Setter;
import com.gesinsoft.AgendaMedica.modelo.Doctor;

@Setter
@Getter
public class JwtDto {
    private String token;
    private Doctor userResponse;

    public JwtDto(String token) {
        this.token = token;
    }

    public JwtDto(String token,Doctor userResponse) {
        this.token = token;
        this.userResponse = userResponse;
    }

    

}
