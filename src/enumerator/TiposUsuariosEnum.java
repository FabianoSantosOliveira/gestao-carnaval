package enumerator;

public enum TiposUsuariosEnum {

	ADMINISTRADOR(1),ESCOLA_SAMBA(2),TORCEDOR(3), INTEGRANTE(4);
	
	private int idTipoUsuario;
	
	TiposUsuariosEnum(int idTipoUsuario){
		this.idTipoUsuario=idTipoUsuario;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
	
}
