package com.spring.AgendaMedica.security.service;


import com.spring.AgendaMedica.modelo.Usuario;
import com.spring.AgendaMedica.repository.UsuarioRepository;
import com.spring.AgendaMedica.security.model.MainUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private UsuarioRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UsuarioRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario user =  userRepository.findByNombreUsuario(username);
        return MainUser.build(user);
    }

}
