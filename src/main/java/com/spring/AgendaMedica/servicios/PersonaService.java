package com.spring.AgendaMedica.servicios;


import com.spring.AgendaMedica.modelo.Persona;
import com.spring.AgendaMedica.service.GenericService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PersonaService extends GenericService<Persona, Long>{
//    @Query(value = "SELECT * FROM persona p JOIN usuarios u ON p.id_persona = u.persona_id_persona WHERE u.username = :username", nativeQuery = true)
//    public Persona obtenerPersona(String username);
//    
//    public Persona obtenerPersonaPorIdUsuario(Long id);
//    public Persona findByCedula(String cedula);
//
//    public Persona findByCorreo(String correo);
//
//    public Map<String, Object> contarRegistrosEnTablas();
//
//    Map<String, Object> contarRegistrosEnTablasE(Long vendedorId);
}
