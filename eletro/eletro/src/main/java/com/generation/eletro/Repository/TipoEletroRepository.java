package com.generation.eletro.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.eletro.Model.TipoEletro;

@Repository
public interface TipoEletroRepository extends JpaRepository<TipoEletro,Long>{
	
}
