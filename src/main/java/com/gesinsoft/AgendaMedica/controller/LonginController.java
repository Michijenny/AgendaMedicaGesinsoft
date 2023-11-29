/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gesinsoft.AgendaMedica.controller;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gesinsoft.AgendaMedica.modelo.Administrador;

/**
 *
 * @author enriq
 */
public class LonginController {

//    @PostMapping("user")
//	public Administrador login(@RequestParam("usuario") String username, @RequestParam("password") String pwd) {
//		
//		String token = getJW(username);
//		Administrador user = new User();
//		user.setUser(username);
//		user.setToken(token);		
//		return user;
//		
//	}
//    public String generarTokenJWT(String idUsuario) {
//        String claveSecreta = "clave-secreta"; // Reemplaza con tu propia clave secreta
//        long tiempoExpiracion = 86400000; // Tiempo de expiración en milisegundos (aquí, 24 horas)
//
//        Claims claims = Jwts.claims().setSubject(idUsuario);
//
//        Date fechaExpiracion = new Date(System.currentTimeMillis() + tiempoExpiracion);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(fechaExpiracion)
//                .signWith(SignatureAlgorithm.HS256, claveSecreta)
//                .compact();
//    }

    public String generateToken(String username) {
        String secretKey = "yourSecretKey"; // Clave secreta para firmar el token
        int expirationTimeInMinutes = 60; // Tiempo de expiración del token en minutos

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMinutes * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;
    }

}
