package com.gesinsoft.AgendaMedica.security.service;


import com.gesinsoft.AgendaMedica.modelo.Usuario;
import com.gesinsoft.AgendaMedica.repository.DoctorRepository;
import com.gesinsoft.AgendaMedica.repository.UsuarioRepository;
import com.gesinsoft.AgendaMedica.security.model.MainUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gesinsoft.AgendaMedica.modelo.Doctor;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    //private UsuarioRepository userRepository;
    private DoctorRepository doctorRepository;

    @Autowired    
      public UserDetailsServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    
    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario user =  userRepository.findByUsername(username);
        return MainUser.build(user);
    }*/

    @Override

    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException{
        //Usuario user =  userRepository.findByNombre(nombre);
        Doctor doc =  doctorRepository.findByNombre(nombre);
        return MainUser.build(doc);
    }
}
