package br.com.fernando.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.dto.UsuarioDto;
import br.com.fernando.entity.UsuarioEntity;
import br.com.fernando.repository.UsuarioRepository;
import br.com.fernando.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioDto criaUsuario(UsuarioDto usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		BeanUtils.copyProperties(usuario, usuarioEntity);
		
		UsuarioDto usuarioDto = new UsuarioDto();
		BeanUtils.copyProperties(usuarioEntity, usuarioDto);
		
		return usuarioDto;
	}

}
