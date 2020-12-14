package com.generation.eletro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.eletro.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	
	@Query(value = "select * from produto where preco > :valori and preco < :valorf", nativeQuery = true)
	public List<Produto> GetAllByPreco (@Param("valori") float valori, @Param("valorf") float valorf);
}
