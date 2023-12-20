package com.gesinsoft.AgendaMedica.security.model;

import com.gesinsoft.AgendaMedica.modelo.Doctor;
import com.gesinsoft.AgendaMedica.modelo.Usuario;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@AllArgsConstructor
public class MainUser implements UserDetails {

    private Integer id;
    private String nombre;
    private String direccion;
    private String especialidad;
    private String telefono;
    private String clave;
    private String cfg;
    private String email;
    private String matricula;
    private Collection<? extends GrantedAuthority> authorities;

    //////////////////////////////////////////////////////////////////////////////
    //ATRIBUTOS DE LA CLASE USUARIO QUE NO SE UTILIZARON
    //  private String username;
    // private String password;
    // private Boolean estado;
    

    /*public static MainUser build(Usuario user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRolNombre())).collect(Collectors.toList());
        return new MainUser(
                user.getIdUsuario(),
                user.getUsername(),
                user.getPassword(),
                user.getEstado(),
                authorities);
    }*/
    public static MainUser build(Doctor doc) {

        return new MainUser(
                doc.getId(),
                doc.getNombre(),
                doc.getDireccion(),
                doc.getEspecialidad(),
                doc.getTelefono(),
                doc.getClave(),
                doc.getCfg(),
                doc.getEmail(),
                doc.getMatricula(),
                Collections.emptyList()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    //DESCOMENTAR SE UTILIZA PARA LOS ATRIBUTOS DE USUARIO
    /* @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }*/
    
    //SE UTILIZA CON LOS ATRIBUTOS DOCTOR
    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
