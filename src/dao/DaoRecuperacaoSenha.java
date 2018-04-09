package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.ModelLogin;
import model.ModelRestaurante;
import model.ModelUsuario;

public class DaoRecuperacaoSenha {

	@SuppressWarnings("resource")
	public boolean Recuperar(String email) {

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
							"Este e-mail n�o est� associado a nenhuma conta de usu�rio. Por favor, verifique.",
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

					String msg = "Ol�, " + u.getUsuario_nome()
							+ "!  \n\nN�s da E a�, comeu? pedimos desculpas pelo inconveninente. Seguem abaixo nome de usu�rio e senha. \n\n\nUSU�RIO: "
							+ l.getLogin_nome() + "\nSENHA: " + l.getLogin_senha()
							+ "\n\n\n E-Mail gerado automatcamente. Favor n�o responder. \n\n\nE a�, Comeu? � 2018";

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

					r = daor.selecionarRestaurante(id);

					l.setLogin_nome(rs.getString("login_nome"));
					l.setLogin_senha(rs.getString("login_senha"));

					String msg = "Ol�, " + r.getRestaurante_razaosocial()
							+ "!  \n\nN�s da E a�, comeu? pedimos desculpas pelo inconveninente. Seguem abaixo nome de usu�rio e senha. \n\n\nUSU�RIO: "
							+ l.getLogin_nome() + "\nSENHA: " + l.getLogin_senha()
							+ "\n\n A nossa equipe recomenda que o restaurante possua algum software que guarde estas credenciais, visto que suas vendas n�o podem parar caso este servi�o n�o esteja funcionando (o que n�s resolver�amos rapidinho, mas mesmo assim :) ) \n\n\n E-Mail gerado automatcamente. Favor n�o responder. \n\n\nE a�, Comeu? � 2018";
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
