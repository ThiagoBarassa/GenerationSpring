package br.com.generation.minhaEscola.Service;

import java.util.List;

import br.com.generation.minhaEscola.Model.Aluno;

public interface AlunoService {
	
	List<Aluno> GetAll ();

	Aluno GetAluno(long id);
	
	Aluno CreateOrUpdate(Aluno aluno);
	
	void Delete(long id);
	
}
