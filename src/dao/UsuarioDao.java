package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import enumerator.TiposUsuariosEnum;

public class UsuarioDao extends ConnectionFactory{

	
	public void salvar(Usuario usuario) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO Usuario(login,senha,tipoUsuario) VALUES(?,?,?)");

			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setInt(3, usuario.getTipoUsuario().getIdTipoUsuario());
			stmt.execute();
			close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public Usuario obterUsuario(String login,String senha){
		List<Usuario> lista = new ArrayList<>();
		try {
			open();
			stmt = con.prepareStatement("Select * from usuario where login=? and senha=?");

			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setTipoUsuario(TiposUsuariosEnum.setTipoUsuario(rs.getInt("tipoUsuario")));
				lista.add(usuario);
			}
			stmt.close();
			close();
			return !lista.isEmpty() ? lista.get(0) : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
