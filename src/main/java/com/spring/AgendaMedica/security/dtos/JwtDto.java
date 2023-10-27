
package com.spring.AgendaMedica.security.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtDto {
    private String token;
    private UserResponseDto userResponse;

    public JwtDto(String token) {
        this.token = token;
    }

    public JwtDto(String token, UserResponseDto userResponse) {
        this.token = token;
        this.userResponse = userResponse;
    }

}
