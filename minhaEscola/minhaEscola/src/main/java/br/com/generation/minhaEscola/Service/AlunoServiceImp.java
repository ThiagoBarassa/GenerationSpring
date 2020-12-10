package br.com.generation.minhaEscola.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.generation.minhaEscola.Model.Aluno;
import br.com.generation.minhaEscola.Repository.AlunoRepository;

@Component
public class AlunoServiceImp implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public AlunoServiceImp(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	@Override
	public List<Aluno> GetAll(){
		List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();
		return alunos;
	}
	
	@Override
	public Aluno GetAluno(long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		if(aluno != null) {
		return aluno.get();
		}
		return null;
	}
	@Override
	public Aluno CreateOrUpdate(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@Override
	public void Delete(long id) {
		alunoRepository.deleteById(id);
	}
	
}
