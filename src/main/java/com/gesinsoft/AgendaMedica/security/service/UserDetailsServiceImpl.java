package com.gesinsoft.AgendaMedica.security.service;

import com.gesinsoft.AgendaMedica.modelo.Usuario;
import com.gesinsoft.AgendaMedica.repository.DoctorRepository;
import com.gesinsoft.AgendaMedica.repository.UsuarioRepository;
import com.gesinsoft.AgendaMedica.security.model.MainUser;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gesinsoft.AgendaMedica.modelo.Doctor;
import com.gesinsoft.AgendaMedica.modelo.Rol;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository userRepository;
	// private DoctorRepository doctorRepository;
	/*
	 * @Autowired public UserDetailsServiceImpl(DoctorRepository doctorRepository) {
	 * this.doctorRepository = doctorRepository; }
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUserName(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		return new User(user.getUserName(), user.getClave(), mapRoles(user.getRol()));
	}

	private Collection<? extends GrantedAuthority> mapRoles(Rol rol) {
		return Collections.singleton(new SimpleGrantedAuthority(rol.getRolNombre()));
	}
	/*
	 * @Override public UserDetails loadUserByUsername(String nombre) throws
	 * UsernameNotFoundException{ //Usuario user =
	 * userRepository.findByNombre(nombre); Doctor doc =
	 * doctorRepository.findByNombre(nombre); return MainUser.build(doc); }
	 */
}
