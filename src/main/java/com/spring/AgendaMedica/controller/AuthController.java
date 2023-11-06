/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.controller;

import com.proyecto.faan.security.model.Message;
import com.spring.AgendaMedica.repository.UsuarioRepository;
import com.spring.AgendaMedica.security.dtos.LoginUser;
import com.spring.AgendaMedica.security.jwt.JwtProvider;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.spring.AgendaMedica.modelo.Usuario;
import com.spring.AgendaMedica.security.dtos.JwtDto;
import com.spring.AgendaMedica.security.dtos.UserResponseDto;
import com.spring.AgendaMedica.modelo.Rol;
import com.spring.AgendaMedica.modelo.RolNombres;
import com.spring.AgendaMedica.servicios.RolService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author enriq
 */

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    private UsuarioRepository userService;

    private JwtProvider jwtProvider;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, UsuarioRepository userService, JwtProvider jwtProvider){
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/signIn")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult) {
        if (bidBindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        }
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Usuario user = userService.findByNombreUsuario(userDetails.getUsername());
            UserResponseDto responseDto = new UserResponseDto(user.getIdUsuario(), user.getNombreUsuario(), user.getRoles());
            JwtDto jwtDto = new JwtDto(jwt, responseDto);
            return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Revise sus credenciales " + e), HttpStatus.BAD_REQUEST);
        }
    }
    
    //registro
    
    @PostMapping("/register")
    public ResponseEntity<Object> resgister(@RequestBody Usuario user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
        }
        user.setContraseña(passwordEncoder.encode(user.getContraseña()));
        List<Rol> addRol = new ArrayList<>();
        if(user.getRoles().isEmpty()){
           addRol.add(rolService.findByRolNombre(RolNombres.ROL_PACIENTE).get());
           user.setRoles(addRol);
        }
        userService.save(user);
        return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
    }
    
    
    
    
}