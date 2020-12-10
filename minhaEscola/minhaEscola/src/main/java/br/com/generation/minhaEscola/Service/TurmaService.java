package br.com.generation.minhaEscola.Service;

import java.util.List;

import br.com.generation.minhaEscola.Model.Turma;

public interface TurmaService {
	
	List<Turma> GetAll();
	
	Turma GetTurma(long id);
	
	Turma CreateOrUpdate(Turma turma);
	
	void Delete(long id);
}
