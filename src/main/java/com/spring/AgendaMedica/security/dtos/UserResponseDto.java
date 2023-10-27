package com.spring.AgendaMedica.security.dtos;


import com.spring.AgendaMedica.modelo.Rol;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Integer idUsuario;
    private String username;
    private List<Rol> roles = new ArrayList<>();
}

