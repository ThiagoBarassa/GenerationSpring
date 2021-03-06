package com.generation.eletro.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.generation.eletro.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	
	//Metodos com Query nativa SQL
	@Query(value = "select * from produto where preco > :valori and preco < :valorf", nativeQuery = true)
	public List<Produto> GetAllByPreco (@Param("valori") float valori, @Param("valorf") float valorf);
	@Query(value = "select * from produto where tipo_eletro_id = :tipoid and preco <= :valor", nativeQuery = true)
	public List<Produto> GetByIdAndPreco (@Param("tipoid") long tipoid, @Param("valor") float valor);
	
	//Metodos com Endpoints JPA
	public List<Produto> findByPrecoBetween(@Param("valori") float valori,@Param("valorf") float valorf);
	public List<Produto> findByIdAndPrecoLessThanEqual(@Param("tipoid") long tipoid, @Param("valor") float valor);
	
	
}
