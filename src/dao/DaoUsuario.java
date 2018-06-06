package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ModelLogin;
import model.ModelRestaurante;
import model.ModelUsuario;

public class DaoUsuario {

	public void cadastrarUsuario(ModelUsuario u) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_usuario (usuario_cpf, usuario_nome, usuario_email, usuario_celular, usuario_uf, usuario_cidade, usuario_cep, usuario_bairro, usuario_endereco, usuario_logradouro, usuario_complemento) VALUES ( ?,  ?,  ?,  ?, ?,  ?,  ?,  ?, ?,  ?,  ?)");
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
					"UPDATE tbl_usuario SET usuario_cpf = ?, usuario_nome = ?, usuario_email = ?, usuario_celular = ?, usuario_uf = ?, usuario_cidade = ?, usuario_cep = ?, usuario_bairro = ?, usuario_endereco = ?, usuario_logradouro = ?, usuario_complemento = ? WHERE usuario_id = ?");

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
			stm.setInt(13, u.getUsuario_id());

			stm.executeUpdate();

			nu = selecionarUsuarioID(u.getUsuario_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nu;
	}

	@SuppressWarnings("resource")
	public boolean recuperarSenha(String email) {

		Connection con = ConnectionFactory.getConnection();
		boolean sent = false;
		boolean usuario = false;

		ResultSet rs = null;
		PreparedStatement stm = null;
		int id = 0;

		try {

			stm = con.prepareStatement("SELECT usuario_id FROM tbl_usuario WHERE usuario_email = '" + email + "';");
			rs = stm.executeQuery();

			while (rs.next()) {
				id = rs.getInt("usuario_id");
			}

			if (id != 0) {
				usuario = true;
			} else {
				stm = con.prepareStatement(
						"SELECT restaurante_id FROM tbl_restaurante WHERE restaurante_email = '" + email + "';");
				rs = stm.executeQuery();

				while (rs.next()) {
					id = rs.getInt("restaurante_id");
				}

				if (id == 0) {
					JOptionPane.showMessageDialog(null,
							"Este e-mail não está associado a nenhuma conta de usuário. Por favor, verifique.",
							"E-Mail incorreto", JOptionPane.ERROR_MESSAGE);
				}
			}

			if (usuario) {
				stm = con.prepareStatement("SELECT login_nome, login_senha FROM tbl_login WHERE usuario_id = " + id);
				rs = stm.executeQuery();

				while (rs.next()) {

					ModelUsuario u = new ModelUsuario();
					ModelLogin l = new ModelLogin();
					DaoUsuario daou = new DaoUsuario();

					u = daou.selecionarUsuarioID(id);

					l.setLogin_nome(rs.getString("login_nome"));
					l.setLogin_senha(rs.getString("login_senha"));

					String msg = "Olá, " + u.getUsuario_nome()
							+ "!  \n\nNós da E aí, comeu? pedimos desculpas pelo inconveninente. Seguem abaixo nome de usuário e senha. \n\n\nUSUÁRIO: "
							+ l.getLogin_nome() + "\nSENHA: " + l.getLogin_senha()
							+ "\n\n\n E-Mail gerado automatcamente. Favor não responder. \n\n\nE aí, Comeu? © 2018";

					u.enviarEmail(msg, email);

				}

				ConnectionFactory.closeConnection(con, stm);

			} else {
				stm = con
						.prepareStatement("SELECT login_nome, login_senha FROM tbl_login WHERE restaurante_id = " + id);
				rs = stm.executeQuery();

				while (rs.next()) {

					ModelRestaurante r = new ModelRestaurante();
					ModelLogin l = new ModelLogin();
					DaoRestaurante daor = new DaoRestaurante();

					r = daor.selecionarRestauranteID(id);

					l.setLogin_nome(rs.getString("login_nome"));
					l.setLogin_senha(rs.getString("login_senha"));

					String msg = "Olá, " + r.getRestaurante_razaosocial()
							+ "!  \n\nNós da E aí, comeu? pedimos desculpas pelo inconveninente. Seguem abaixo nome de usuário e senha. \n\n\nUSUÁRIO: "
							+ l.getLogin_nome() + "\nSENHA: " + l.getLogin_senha()
							+ "\n\n A nossa equipe recomenda que o restaurante possua algum software que guarde estas credenciais, visto que suas vendas não podem parar caso este serviço não esteja funcionando (o que nós resolveríamos rapidinho, mas mesmo assim :) ) \n\n\n E-Mail gerado automatcamente. Favor não responder. \n\n\nE aí, Comeu? © 2018";
					r.enviarEmail(msg, email);

				}

				ConnectionFactory.closeConnection(con, stm);

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return sent;
	}

}
