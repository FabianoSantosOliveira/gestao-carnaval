package dao;

import model.Torcedor;

public class TorcedorDao extends ConnectionFactory{

	public void salvar(Torcedor torcedor) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO Torcedor(nome,sobrenome,email,sexo,idUsuario,idEscola) VALUES(?,?,?,?,?,?)");

			stmt.setString(1, torcedor.getNome());
			stmt.setString(2, torcedor.getSobrenome());
			stmt.setString(3, torcedor.getEmail());
			stmt.setString(4, torcedor.getSexo());
			stmt.setInt(5, torcedor.getIdUsuario());
			stmt.setInt(6, torcedor.getEscolaPreferida().getId());
			stmt.execute();
			close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
