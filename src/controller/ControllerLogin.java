package controller;

import java.awt.EventQueue;

import dao.DaoLogin;
import model.ModelLogin;
import model.ModelUsuario;
import view.ViewLogin;
import view.usuario.cadastro.ViewCadastroLogin;

public class ControllerLogin {

	public void carregarLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(false);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarCadastroLogin(ModelUsuario u) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroLogin frame = new ViewCadastroLogin(u);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					// frame.setUndecorated(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void cadastrarLoginUsuario(ModelLogin l) {
		DaoLogin dao = new DaoLogin();
		dao.cadastrarLogin(l, true);
	}

	public void cadastrarLoginRestaurante(ModelLogin l) {
		DaoLogin dao = new DaoLogin();
		dao.cadastrarLogin(l, false);
	}

	public ModelLogin selecionarLoginCRED(ModelLogin l) {
		DaoLogin dao = new DaoLogin();
		dao.selecionarLoginCRED(l);
		ModelLogin login = new ModelLogin();
		login = dao.selecionarLoginCRED(l);
		return login;
	}

	public boolean logar(ModelLogin l) {
		DaoLogin dao = new DaoLogin();
		boolean connected = false;
		if (!dao.logarUsuario(l)) {
			connected = dao.logarEmail(l);
		} else {
			connected = dao.logarUsuario(l);
		}
		return connected;
	}

	public String verificarCredenciais(String usuario, String email) {
		String resultado = "";
		DaoLogin dao = new DaoLogin();
		if (dao.verificarUsuario(usuario)) {
			resultado = "Este nome de usuário já está em uso.";
		}
		if (dao.verificarEmail(email)) {
			resultado = "Este e-mail já está em uso.";
		}

		return resultado;
	}

}
