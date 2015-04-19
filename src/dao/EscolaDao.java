package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.EscolaSamba;
import model.Quesitos;

public class EscolaDao extends ConnectionFactory{

	public void salvar(EscolaSamba escola) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO Escola_Samba(nome,cnpj,idUsuario) VALUES(?,?,?)");

			stmt.setString(1, escola.getNomeEscola());
			stmt.setString(2, escola.getCnpj());
			stmt.setInt(3, escola.getIdUsuario());
			stmt.execute();
			close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public List<EscolaSamba> findAll() {
		List<EscolaSamba> lista = new ArrayList<>();
		try {
			open();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Escola_Samba");
			while (rs.next()) {
				EscolaSamba escola = new EscolaSamba();
				escola.setId(rs.getInt("idEscola"));
				escola.setNomeEscola(rs.getString("nome"));
				lista.add(escola);
			}
			stm.close();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
