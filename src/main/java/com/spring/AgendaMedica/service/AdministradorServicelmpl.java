/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.AgendaMedica.service;
import com.spring.AgendaMedica.modelo.Administrador;
import com.spring.AgendaMedica.repository.AdministradorRepository;
import com.spring.AgendaMedica.servicios.AdministradorService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author enriq
 */
@Service
@Transactional
public class AdministradorServicelmpl extends GenericServiceImpl<Administrador, Integer> implements AdministradorService{
    
    @Autowired
    AdministradorRepository administradorRepositoy;

    @Override
    public CrudRepository<Administrador, Integer> getDao() {
        return administradorRepositoy;
    }
    
    //METODOS PARA VERIFICAR QUE NOMBRE DEL USUARIO SEA UNICO
    
//    public Optional <Administrador> getByNombreAdministrador (String nombread){
//        return administradorRepositoy.NombreAdministrador(nombread);
//    }
//    
//    public boolean existeUsuario (String nombreUsuario){
//        return administradorRepositoy.existeAdmin(nombreUsuario);
//    }
    
    //METODO PARA GUARDAR EL USUARIO DEL ADMIN
    
    public void guardar (Administrador administrador){
        administradorRepositoy.save(administrador);
    }
    
    
    
    

}
