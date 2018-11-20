package br.com.fernando.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.dto.UsuarioDto;
import br.com.fernando.req.UsuarioReq;
import br.com.fernando.resp.UsuarioResp;
import br.com.fernando.service.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public UsuarioResp criaUsuario(UsuarioReq usuario) {
		
		UsuarioDto usuarioDto = new UsuarioDto();
		
		BeanUtils.copyProperties(usuario, usuarioDto);
		usuarioService.criaUsuario(usuarioDto);
		
		UsuarioResp usuarioResp = new UsuarioResp();
		BeanUtils.copyProperties(usuarioDto, usuarioResp);
		
		return usuarioResp;
	}
	
}
