package model;

public class Torcedor extends Usuario {

	private String nome;
	private String email;
	private String sexo;
	private EscolaSamba escolaPreferida;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public EscolaSamba getEscolaPreferida() {
		return escolaPreferida;
	}

	public void setEscolaPreferida(EscolaSamba escolaPreferida) {
		this.escolaPreferida = escolaPreferida;
	}

}
