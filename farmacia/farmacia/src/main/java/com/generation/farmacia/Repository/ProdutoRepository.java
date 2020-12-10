package com.generation.farmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
