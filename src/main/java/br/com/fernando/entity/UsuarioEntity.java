package br.com.fernando.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "usuarios")
public class UsuarioEntity implements Serializable{
	private static final long serialVersionUID = -9180446678663894742L;
	@Id
	@GeneratedValue
	private long id;
	private String usuarioId;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 50)
	private String sobrenome;
	@Column(nullable = true, length = 120, unique = true)
	private String email;
	private String senhaCriptografada;
	private String emailToken;
	private String emailStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}
	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}
	public String getEmailToken() {
		return emailToken;
	}
	public void setEmailToken(String emailToken) {
		this.emailToken = emailToken;
	}
	public String getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}
}
