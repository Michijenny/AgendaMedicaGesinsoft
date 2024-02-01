package com.gesinsoft.AgendaMedica.controller;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import com.gesinsoft.AgendaMedica.modelo.Usuario;
import com.gesinsoft.AgendaMedica.security.dtos.JwtDto;
import com.gesinsoft.AgendaMedica.security.model.Message;
import com.gesinsoft.AgendaMedica.servicios.RolService;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gesinsoft.AgendaMedica.security.dtos.NewUser;
import com.gesinsoft.AgendaMedica.servicios.UsuarioService;
import com.gesinsoft.AgendaMedica.servicios.DoctorService;
import com.gesinsoft.AgendaMedica.modelo.Doctor;

import java.util.List;

/**
 *
 * @author enriq
 */

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/auth")
public class AuthsController {
	
	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	// private final UsuarioService userService;
	// private final RolService roleService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private UsuarioService usuarioService;
	/*
	 * @Autowired public AuthsController(AuthenticationManagerBuilder
	 * authenticationManagerBuilder, PasswordEncoder passwordEncoder, JwtProvider
	 * jwtProvider, DoctorService doctorService) { this.authenticationManagerBuilder
	 * = authenticationManagerBuilder; //this.passwordEncoder = passwordEncoder;
	 * this.jwtProvider = jwtProvider; this.doctorService = doctorService; }
	 */

	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult) {

		System.out.println(loginUser);
		if (bidBindingResult.hasErrors()) {
			return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
		}
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					loginUser.getNombre(), loginUser.getClavesecreta());
			System.out.println(authenticationToken.getName() + " Here's the UPAT");
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtProvider.generateToken(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Usuario user = usuarioService.findByUserName(userDetails.getUsername());
			System.out.println(user);
			// Doctor doc = doctorService.findByNombre(userDetails.getUsername());
			JwtDto jwtDto = new JwtDto(jwt, user);

			return new ResponseEntity<>(jwtDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new Message("Revise sus credenciales " + e), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/listarr/{id}")
	public ResponseEntity<?> getDoctorById(@PathVariable("id") Integer id) {
		try {
			Doctor nc = doctorService.findById(id);
			if (nc != null) {
				return new ResponseEntity<>(nc, HttpStatus.OK);
			}
			return new ResponseEntity<>("DOCTOR NO ENCONTRADO ", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Doctor>> listarDoctor() {
		return new ResponseEntity<>(doctorService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Usuario> register(@RequestBody Usuario c) {
		try {
			c.setEstado(true);
			c.setClave(passwordEncoder.encode(c.getClave()));
			return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * @PostMapping("/register") public ResponseEntity<Usuario> crear(@RequestBody
	 * Usuario c) { try { c.setEstado(true);
	 * c.setPassword(passwordEncoder.encode(c.getPassword())); return new
	 * ResponseEntity<>(userService.save(c), HttpStatus.CREATED); } catch (Exception
	 * e) { return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

	/*
	 * @PostMapping("/registers") public ResponseEntity<Object>
	 * resgister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
	 * if (bindingResult.hasErrors()) { return new ResponseEntity<>(new
	 * Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST); }
	 * Usuario user = new Usuario(newUser.getUsername(),
	 * passwordEncoder.encode(newUser.getPassword()), newUser.getEstado()
	 * ,newUser.getPersona()); List<Rol> roles = new ArrayList<>(); for (Rol rol :
	 * newUser.getRoles()) {
	 * roles.add(roleService.findByRolNombre(rol.getRolNombre())); }
	 * user.setRoles(roles); userService.save(user); return new ResponseEntity<>(new
	 * Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED); }
	 */

	/*
	 * @PostMapping("/registers") public ResponseEntity<Object>
	 * resgister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
	 * if (bindingResult.hasErrors()) { return new ResponseEntity<>(new
	 * Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST); }
	 * Doctor doc = new Doctor(newUser.getNombre(),
	 * passwordEncoder.encode(newUser.getClavesecreta()), newUser.getComentarios()
	 * ,newUser.getDireccion() , newUser.getEspecialidad(), newUser.getTelefono(),
	 * newUser.getClave(), newUser.getNotaAuto(), newUser.getNota(),
	 * newUser.getComparte() , newUser.getCfg(), newUser.getCfgsec(),
	 * newUser.getEmail(), newUser.getMatricula()); doctorService.save(doc); return
	 * new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"),
	 * HttpStatus.CREATED); }
	 */

}
