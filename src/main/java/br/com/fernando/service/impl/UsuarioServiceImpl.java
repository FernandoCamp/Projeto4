package br.com.fernando.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.dto.UsuarioDto;
import br.com.fernando.entity.UsuarioEntity;
import br.com.fernando.repository.UsuarioRepository;
import br.com.fernando.service.UsuarioService;
import br.com.fernando.utilidade.Utils;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private Utils geradorRandom;
	
	public UsuarioDto criaUsuario(UsuarioDto usuario) {
		if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
			throw new RuntimeException("Email existente.");
		}
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		BeanUtils.copyProperties(usuario, usuarioEntity);
		
		usuarioEntity.setUsuarioId(geradorRandom.generateUserId(30));
		usuarioRepository.save(usuarioEntity);
		
		UsuarioDto usuarioDto = new UsuarioDto();
		BeanUtils.copyProperties(usuarioEntity, usuarioDto);
		
		return usuarioDto;
	}

	public UsuarioDto buscaPeloEmail(String email) {
		UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email);
		UsuarioDto usuarioDto = new UsuarioDto();
		BeanUtils.copyProperties(usuarioEntity, usuarioDto);
		return usuarioDto;
	}

}
