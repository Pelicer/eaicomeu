package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelUsuario;

public class DaoUsuario {

	public void cadastrarUsuario(ModelUsuario u) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_usuario (usuario_cpf, usuario_nome, usuario_email, usuario_celular, usuario_uf, usuario_cidade, usuario_cep, usuario_bairro, usuario_endereco, usuario_logradouro, usuario_complemento, usuario_thumbnail) VALUES ( ?,  ?,  ?,  ?, ?,  ?,  ?,  ?, ?,  ?,  ?,  ?)");
			stm.setString(1, u.getUsuario_cpf());
			stm.setString(2, u.getUsuario_nome());
			stm.setString(3, u.getUsuario_email());
			stm.setString(4, u.getUsuario_celular());
			stm.setString(5, u.getUsuario_uf());
			stm.setString(6, u.getUsuario_cidade());
			stm.setString(7, u.getUsuario_cep());
			stm.setString(8, u.getUsuario_bairro());
			stm.setString(9, u.getUsuario_endereco());
			stm.setString(10, u.getUsuario_logradouro());
			stm.setString(11, u.getUsuario_complemento());
			stm.setString(12, u.getUsuario_thumbnail());

			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ModelUsuario selecionarUsuarioID(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelUsuario u = new ModelUsuario();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_usuario WHERE usuario_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				u.setUsuario_id(rs.getInt("usuario_id"));
				u.setUsuario_cpf(rs.getString("usuario_cpf"));
				u.setUsuario_nome(rs.getString("usuario_nome"));
				u.setUsuario_email(rs.getString("usuario_email"));
				u.setUsuario_celular(rs.getString("usuario_celular"));
				u.setUsuario_uf(rs.getString("usuario_uf"));
				u.setUsuario_cidade(rs.getString("usuario_cidade"));
				u.setUsuario_cep(rs.getString("usuario_cep"));
				u.setUsuario_bairro(rs.getString("usuario_bairro"));
				u.setUsuario_endereco(rs.getString("usuario_endereco"));
				u.setUsuario_logradouro(rs.getString("usuario_logradouro"));
				u.setUsuario_complemento(rs.getString("usuario_complemento"));
				u.setUsuario_thumbnail(rs.getString("usuario_thumbnail"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	public ModelUsuario selecionarUsuarioCPF(String cpf) {

		Connection con = ConnectionFactory.getConnection();
		ModelUsuario u = new ModelUsuario();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_usuario WHERE usuario_cpf = '" + cpf + "';");
			rs = stm.executeQuery();

			while (rs.next()) {
				u.setUsuario_id(rs.getInt("usuario_id"));
				u.setUsuario_cpf(rs.getString("usuario_cpf"));
				u.setUsuario_nome(rs.getString("usuario_nome"));
				u.setUsuario_email(rs.getString("usuario_email"));
				u.setUsuario_celular(rs.getString("usuario_celular"));
				u.setUsuario_uf(rs.getString("usuario_uf"));
				u.setUsuario_cidade(rs.getString("usuario_cidade"));
				u.setUsuario_cep(rs.getString("usuario_cep"));
				u.setUsuario_bairro(rs.getString("usuario_bairro"));
				u.setUsuario_endereco(rs.getString("usuario_endereco"));
				u.setUsuario_logradouro(rs.getString("usuario_logradouro"));
				u.setUsuario_complemento(rs.getString("usuario_complemento"));
				u.setUsuario_thumbnail(rs.getString("usuario_thumbnail"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	public ModelUsuario atualizarUsuario(ModelUsuario u) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ModelUsuario nu = new ModelUsuario();

		try {
			stm = con.prepareStatement(
					"UPDATE tbl_usuario SET usuario_cpf = ?, usuario_nome = ?, usuario_email = ?, usuario_celular = ?, usuario_uf = ?, usuario_cidade = ?, usuario_cep = ?, usuario_bairro = ?, usuario_endereco = ?, usuario_logradouro = ?, usuario_complemento = ?, usuario_thumbnail = ? WHERE usuario_id = ?");

			stm.setString(1, u.getUsuario_cpf());
			stm.setString(2, u.getUsuario_nome());
			stm.setString(3, u.getUsuario_email());
			stm.setString(4, u.getUsuario_celular());
			stm.setString(5, u.getUsuario_uf());
			stm.setString(6, u.getUsuario_cidade());
			stm.setString(7, u.getUsuario_cep());
			stm.setString(8, u.getUsuario_bairro());
			stm.setString(9, u.getUsuario_endereco());
			stm.setString(10, u.getUsuario_logradouro());
			stm.setString(11, u.getUsuario_complemento());
			stm.setString(12, u.getUsuario_thumbnail());
			stm.setInt(13, u.getUsuario_id());

			stm.executeUpdate();

			nu = selecionarUsuarioID(u.getUsuario_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nu;
	}

}
