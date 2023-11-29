/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

import com.gesinsoft.AgendaMedica.repository.UsuarioRepository;
import com.gesinsoft.AgendaMedica.security.dtos.LoginUser;
import com.gesinsoft.AgendaMedica.security.jwt.JwtProvider;
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
import com.gesinsoft.AgendaMedica.modelo.Usuario;
import com.gesinsoft.AgendaMedica.security.dtos.JwtDto;
import com.gesinsoft.AgendaMedica.modelo.Rol;
import com.gesinsoft.AgendaMedica.security.model.Message;
import com.gesinsoft.AgendaMedica.servicios.RolService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gesinsoft.AgendaMedica.security.dtos.NewUser;
import com.gesinsoft.AgendaMedica.servicios.UsuarioService;

/**
 *
 * @author enriq
 */

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/auths")
public class AuthsController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioService userService;
    private final RolService roleService;
    private final JwtProvider jwtProvider;

     @Autowired
    public AuthsController(AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncoder,
                          UsuarioService userService, RolService roleService, JwtProvider jwtProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/sign")
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
            Usuario user = userService.findByUsername(userDetails.getUsername());
            JwtDto jwtDto = new JwtDto(jwt, user);
            return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Revise sus credenciales " + e), HttpStatus.BAD_REQUEST);
        }
    }

    //registro
    //ESTE METODO ES PARA CUANDO EL ROL VIENE DE UNA CLASE EMUN
    /* @PostMapping("/register")
    public ResponseEntity<Object> resgister(@RequestBody Usuario user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Rol> addRol = new ArrayList<>();
        if(user.getRoles().isEmpty()){
           addRol.add(rolService.findByRolNombre(RolNombres.ROL_PACIENTE).get());
           user.setRoles(addRol);
        }
        userService.save(user);
        return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
    }*/
    
   /* @PostMapping("/register")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario c) {
        try {
            c.setEstado(true);
            c.setPassword(passwordEncoder.encode(c.getPassword()));
            return new ResponseEntity<>(userService.save(c), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
    @PostMapping("/registers")
    public ResponseEntity<Object> resgister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
        }
        Usuario user = new Usuario(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()), newUser.getEstado() ,newUser.getPersona());
        List<Rol> roles = new ArrayList<>();
        for (Rol rol : newUser.getRoles()) {
            roles.add(roleService.findByRolNombre(rol.getRolNombre()));
        }
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
    }

}
