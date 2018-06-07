package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelLogin;
import model.ModelUsuario;

public class DaoLogin {

	public boolean logarEmail(ModelLogin l) {
		Connection con = ConnectionFactory.getConnection();
		boolean connected = false;

		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_login WHERE login_email = ? AND login_senha = ?");
			stm.setString(1, l.getLogin_email());
			stm.setString(2, l.getLogin_senha());
			rs = stm.executeQuery();

			while (rs.next()) {
				connected = true;
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connected;
	}

	public boolean logarUsuario(ModelLogin l) {

		Connection con = ConnectionFactory.getConnection();
		boolean connected = false;

		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_login WHERE login_nome = ? AND login_senha = ?");
			stm.setString(1, l.getLogin_nome());
			stm.setString(2, l.getLogin_senha());
			rs = stm.executeQuery();

			while (rs.next()) {
				connected = true;
			}

			if (!connected) {
				connected = logarEmail(l);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connected;
	}

	public void cadastrarLogin(ModelLogin l, boolean usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			if (usuario) {
				stm = con.prepareStatement(
						"INSERT INTO tbl_login (login_nome, login_senha, login_email, usuario_id, restaurante_id) VALUES ( ?,  ?,  ?,  ?,  ?)");
				stm.setString(1, l.getLogin_nome());
				stm.setString(2, l.getLogin_senha());
				stm.setString(3, l.getLogin_email());
				stm.setInt(4, l.getUsuario_id());
				stm.setString(5, null);
				stm.executeUpdate();

			} else {
				stm = con.prepareStatement(
						"INSERT INTO tbl_login (login_nome, login_senha, login_email, usuario_id, restaurante_id) VALUES ( ?,  ?,  ?,  ?,  ?)");
				stm.setString(1, l.getLogin_nome());
				stm.setString(2, l.getLogin_senha());
				stm.setString(3, l.getLogin_email());
				stm.setString(4, null);
				stm.setInt(5, l.getRestaurante_id());
				stm.executeUpdate();
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ModelLogin selecionarLoginID(int id, boolean usuario) {

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;
		ModelLogin l = new ModelLogin();

		try {
			if (usuario) {
				stm = con.prepareStatement("SELECT * FROM tbl_login WHERE usuario_id = " + id + ";");
				rs = stm.executeQuery();
			} else {
				stm = con.prepareStatement("SELECT * FROM tbl_login WHERE restaurante_id = " + id + ";");
				rs = stm.executeQuery();
			}

			while (rs.next()) {
				l.setLogin_nome(rs.getString("login_nome"));
				l.setLogin_senha(rs.getString("login_senha"));
				l.setUsuario_id(rs.getInt("usuario_id"));
				l.setRestaurante_id(rs.getInt("restaurante_id"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

	public ModelLogin selecionarLoginCRED(ModelLogin l, boolean email) {

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;
		ModelLogin login = new ModelLogin();

		try {
			if (!email) {
				stm = con.prepareStatement(
						"SELECT usuario_id, restaurante_id FROM tbl_login WHERE login_nome = ? and login_senha = ?");
				stm.setString(1, l.getLogin_nome());
				stm.setString(2, l.getLogin_senha());
				rs = stm.executeQuery();

				while (rs.next()) {
					login.setUsuario_id(rs.getInt("usuario_id"));
					login.setRestaurante_id(rs.getInt("restaurante_id"));
				}

				ConnectionFactory.closeConnection(con, stm);
			} else {
				stm = con.prepareStatement(
						"SELECT usuario_id, restaurante_id FROM tbl_login WHERE login_email = ? and login_senha = ?");
				stm.setString(1, l.getLogin_email());
				stm.setString(2, l.getLogin_senha());
				rs = stm.executeQuery();

				while (rs.next()) {
					login.setUsuario_id(rs.getInt("usuario_id"));
					login.setRestaurante_id(rs.getInt("restaurante_id"));
				}

				ConnectionFactory.closeConnection(con, stm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return login;
	}

	public ModelLogin atualizarLogin(ModelLogin l, boolean usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ModelLogin nl = new ModelLogin();

		try {
			if (usuario) {
				stm = con.prepareStatement(
						"UPDATE tbl_login SET login_nome =  ?,login_senha =  ? WHERE usuario_id =  ?");
				stm.setString(1, l.getLogin_nome());
				stm.setString(2, l.getLogin_senha());
				stm.setInt(3, l.getUsuario_id());
				stm.executeUpdate();

				nl = selecionarLoginID(l.getUsuario_id(), true);
			} else {
				stm = con.prepareStatement(
						"UPDATE tbl_login SET login_nome =  ?,login_senha =  ? WHERE restaurante_id =  ?");
				stm.setString(1, l.getLogin_nome());
				stm.setString(2, l.getLogin_senha());
				stm.setInt(3, l.getRestaurante_id());
				stm.executeUpdate();

				nl = selecionarLoginID(l.getRestaurante_id(), false);
			}
			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nl;
	}

	public boolean verificarUsuario(String usuario) {

		Connection con = ConnectionFactory.getConnection();
		boolean existente = false;

		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_login WHERE login_nome = ?");
			stm.setString(1, usuario);
			rs = stm.executeQuery();

			while (rs.next()) {
				existente = true;
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existente;
	}

	public boolean verificarEmail(String email) {

		Connection con = ConnectionFactory.getConnection();
		boolean existente = false;

		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_login WHERE login_email = ?");
			stm.setString(1, email);
			rs = stm.executeQuery();

			while (rs.next()) {
				existente = true;
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existente;
	}

	public void deletarLogin(ModelUsuario u) {

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE FROM tbl_login WHERE usuario_id = ?");
			stm.setInt(1, u.getUsuario_id());
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
