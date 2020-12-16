package com.generation.redeSocial.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.generation.redeSocial.Model.Usuario;
import com.generation.redeSocial.Repository.UsuarioRepository;

@Repository
public class UserDetailsImpService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByNome(nome);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
		
		return usuario.map(UserDetailsImp::new).get();
	}

}
