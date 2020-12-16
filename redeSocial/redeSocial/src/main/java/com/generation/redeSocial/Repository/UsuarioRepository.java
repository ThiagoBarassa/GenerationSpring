package com.generation.redeSocial.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.redeSocial.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//public List<Usuario> findAllByUserContainingIgnoreCase(String nome);
	
	public Optional<Usuario> findByNome(String nome);
	public Optional<Usuario> findByUsuario(String usuario);
}
