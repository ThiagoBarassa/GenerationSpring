package com.generation.redeSocial.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.redeSocial.Model.Usuario;
import com.generation.redeSocial.Model.UsuarioLogin;
import com.generation.redeSocial.Repository.UsuarioRepository;
import com.generation.redeSocial.Service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.CadastrarUsuario(usuario));
	}
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user){
		return service.Logar(user)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.build());
	}
	
	@PutMapping
	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(usuario));
	}
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound()
				.build());
	}
	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable long id) {
		repository.deleteById(id);
	}
	/*
	 * @GetMapping("/user/{nome}") public ResponseEntity<List<Usuario>>
	 * FindByUser(@PathVariable String nome){ return
	 * ResponseEntity.ok(repository.findAllByUserContainingIgnoreCase(nome)); }
	 */
	
}
