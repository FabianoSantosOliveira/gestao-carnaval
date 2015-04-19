package model;

import enumerator.TiposUsuariosEnum;

public class Usuario {

	private Integer idUsuario;
	private String login;
	private String senha;
	private TiposUsuariosEnum tipoUsuario;
	
		
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TiposUsuariosEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TiposUsuariosEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	
}
