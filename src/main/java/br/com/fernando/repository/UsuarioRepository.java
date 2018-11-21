package br.com.fernando.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fernando.entity.UsuarioEntity;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
	public UsuarioEntity findByEmail(String email);
}
