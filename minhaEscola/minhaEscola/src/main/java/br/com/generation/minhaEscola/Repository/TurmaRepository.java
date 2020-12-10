package br.com.generation.minhaEscola.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaEscola.Model.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long> {
	
}


