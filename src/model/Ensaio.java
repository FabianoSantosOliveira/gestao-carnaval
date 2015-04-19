package model;

import java.util.Date;



public class Ensaio {

	private Date data;
	private String horario;
	private EscolaSamba escola;
	private String endereco;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public EscolaSamba getEscola() {
		return escola;
	}

	public void setEscola(EscolaSamba escola) {
		this.escola = escola;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
