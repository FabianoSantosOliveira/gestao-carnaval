package model;

import java.sql.Date;

public class Ensaio {

	private Date data;
	private Date horario;
	private EscolaSamba escola;
	private String endereco;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
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
