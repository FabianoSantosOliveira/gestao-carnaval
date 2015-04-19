package enumerator;

public enum TiposUsuariosEnum {

	ADMINISTRADOR(1),ESCOLA_SAMBA(2),TORCEDOR(3), INTEGRANTE(4);
	
	private int idTipoUsuario;
	
	TiposUsuariosEnum(int idTipoUsuario){
		this.idTipoUsuario=idTipoUsuario;
	}

	public static TiposUsuariosEnum setTipoUsuario(Integer id){
		if(id == ADMINISTRADOR.getIdTipoUsuario()){
			return ADMINISTRADOR;
		}else if(id == ESCOLA_SAMBA.getIdTipoUsuario()){
			return ESCOLA_SAMBA;
		}else if(id == TORCEDOR.getIdTipoUsuario()){
			return TORCEDOR;
		}else{
			return INTEGRANTE;
		}
		
	}
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
	
}
