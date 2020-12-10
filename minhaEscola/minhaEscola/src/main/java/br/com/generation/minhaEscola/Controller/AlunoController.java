package br.com.generation.minhaEscola.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.generation.minhaEscola.Model.Aluno;
import br.com.generation.minhaEscola.Service.AlunoService;


@RestController
@RequestMapping("/aluno")
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private final AlunoService alunoService;
	
	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@GetMapping
	private ResponseEntity <List<Aluno>> GetAll(){
		return ResponseEntity.ok(alunoService.GetAll());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity <Aluno> GetById(@PathVariable long id) {
		return ResponseEntity.ok(alunoService.GetAluno(id));
	}
	
	@PostMapping
	private ResponseEntity <Aluno> PostAluno(@RequestBody Aluno aluno){
		return ResponseEntity.ok(alunoService.CreateOrUpdate(aluno));
	}
	
	@PutMapping
	private ResponseEntity <Aluno> PutAluno(@RequestBody Aluno aluno){
		return ResponseEntity.ok(alunoService.CreateOrUpdate(aluno));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> Delete(@PathVariable long id) {
		alunoService.Delete(id);
		return ResponseEntity.ok("Aluno Deletado");
	}
}
