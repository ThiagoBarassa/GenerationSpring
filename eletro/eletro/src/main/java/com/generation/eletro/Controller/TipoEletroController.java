package com.generation.eletro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.eletro.Model.TipoEletro;
import com.generation.eletro.Repository.TipoEletroRepository;

@RestController
@RequestMapping("/tipoeletro")
public class TipoEletroController {
	@Autowired
	private TipoEletroRepository repository;
	
	@PostMapping
	public ResponseEntity<TipoEletro> Post(@RequestBody TipoEletro tipoEletro){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tipoEletro));
	}
	@PutMapping
	public ResponseEntity<TipoEletro> Put(@RequestBody TipoEletro tipoEletro){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(tipoEletro));
	}
	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable long id) {
		repository.deleteById(id);
	}
	@GetMapping
	public ResponseEntity<List<TipoEletro>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<TipoEletro> FindById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.badRequest().build());
	}
	
}
