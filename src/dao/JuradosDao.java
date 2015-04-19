package dao;

import model.Jurados;

public class JuradosDao extends ConnectionFactory{

	public void salvar(Jurados jurado) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO Jurados(nome,idQuesito) VALUES(?,?)");

			stmt.setString(1, jurado.getNome());
			stmt.setInt(2, jurado.getQuesitos().getId());
			stmt.execute();
			close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
