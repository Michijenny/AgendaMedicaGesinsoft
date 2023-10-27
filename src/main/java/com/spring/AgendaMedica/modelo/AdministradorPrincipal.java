/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.modelo;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.stream.Collectors;

/**
 *
 * @author enriq
 */
public class AdministradorPrincipal implements UserDetails {

    //ESTA CLASE NO SIRVE POR EL MOMENTO 
    //DEJAR AHI
    private String usuario;
    private String password1;
    private Collection<? extends GrantedAuthority> authorities;

    //Contructor
    public AdministradorPrincipal(String usuario, String password1, Collection<? extends GrantedAuthority> authorities) {
        this.usuario = usuario;
        this.password1 = password1;
        this.authorities = authorities;
    }

    //Privilegios de Usuarios
    public static AdministradorPrincipal build(Administrador admin) {
        List<GrantedAuthority> authorities
                = admin.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());

        return new AdministradorPrincipal(admin.getUsuario(), admin.getPassword(), authorities);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password1;
    }

    @Override
    public String getUsername() {
        return usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

}
