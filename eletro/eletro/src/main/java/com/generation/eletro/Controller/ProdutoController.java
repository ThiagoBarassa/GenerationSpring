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

import com.generation.eletro.Model.Produto;
import com.generation.eletro.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping
	public ResponseEntity<Produto> Post(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> Put(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(produto));
	}
	@GetMapping
	public ResponseEntity <List<Produto>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.badRequest()
				.build());
	}
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	@GetMapping("/preco/{valori}/{valorf}")
	public ResponseEntity<List<Produto>> GetAllByPreco(@PathVariable float valori,@PathVariable float valorf){
		return ResponseEntity.ok(repository.GetAllByPreco(valori,valorf));
	}
	@GetMapping("/tipo/{tipoid}/{valor}")
	public ResponseEntity<List<Produto>> GetByIdAndPreco(@PathVariable long tipoid, @PathVariable float valor){
		return  ResponseEntity.ok(repository.GetByIdAndPreco(tipoid, valor));

	}
}
