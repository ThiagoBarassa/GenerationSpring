package br.com.generation.minhaEscola.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.generation.minhaEscola.Model.Turma;
import br.com.generation.minhaEscola.Repository.TurmaRepository;

@Component
public class TurmaServiceImp implements TurmaService{
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public TurmaServiceImp(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	@Override
	public List<Turma> GetAll(){
		List<Turma> turmas = (List<Turma>) turmaRepository.findAll();
		return turmas;
	}
	@Override
	public Turma GetTurma(long id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		if(turma != null) {
			return turma.get();
		}
		return null;
	}
	@Override
	public Turma CreateOrUpdate(Turma turma) {
		return turmaRepository.save(turma);
	}
	@Override
	public void Delete(long id) {
		turmaRepository.deleteById(id);
	}
}
