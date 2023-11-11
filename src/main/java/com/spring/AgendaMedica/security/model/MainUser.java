package com.spring.AgendaMedica.security.model;



import com.spring.AgendaMedica.modelo.Usuario;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@AllArgsConstructor
public class MainUser implements UserDetails {
    private Integer idUsuario;
    private String username;
    private String password;
    private Boolean estado;
    private Collection<? extends GrantedAuthority> authorities;

    /*public static MainUser build(Usuario user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRolnombre())).collect(Collectors.toList());
        return new MainUser(user.getNombreUsuario(), user.getContraseña(), authorities);
    }*/
    
  /* public static MainUser build(Usuario user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRolNombre().name())).collect(Collectors.toList());
        return new MainUser(user.getUsername(), user.getPassword(), authorities);
    }*/
    
    /*public static MainUser build(Usuario user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRolNombre())).collect(Collectors.toList());
        return new MainUser(
                user.getIdUsuario(),
                user.getUsername(),
                user.getPassword(),
                user.getEstado(),
                authorities);
    }*/
    public static MainUser build(Usuario user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRolNombre())).collect(Collectors.toList());
        return new MainUser(
                user.getIdUsuario(),
                user.getUsername(),
                user.getPassword(),
                user.getEstado(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
