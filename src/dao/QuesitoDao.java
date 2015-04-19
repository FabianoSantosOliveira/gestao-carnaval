package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Quesitos;

public class QuesitoDao extends ConnectionFactory {

	public void salvar(String nome) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO Quesitos(nome) VALUES(?)");

			stmt.setString(1, nome);
			stmt.execute();
			close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public List<Quesitos> findAll() {
		List<Quesitos> lista = new ArrayList<>();
		try {
			open();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Quesitos");
			while (rs.next()) {
				Quesitos quesito = new Quesitos();
				quesito.setId(rs.getInt("idQuesito"));
				quesito.setNome(rs.getString("nome"));
				lista.add(quesito);
			}
			stm.close();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
