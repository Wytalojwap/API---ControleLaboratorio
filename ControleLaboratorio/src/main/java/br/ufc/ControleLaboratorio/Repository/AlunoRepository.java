package br.ufc.ControleLaboratorio.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufc.ControleLaboratorio.Model.Aluno;

@Repository
	public interface AlunoRepository extends CrudRepository<Aluno, Integer> {


	    }
