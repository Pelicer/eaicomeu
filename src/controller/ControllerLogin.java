package controller;

import java.awt.EventQueue;

import dao.DaoLogin;
import model.ModelLogin;
import model.ModelUsuario;
import view.ViewLogin;
import view.usuario.cadastro.ViewCadastroLogin;

public class ControllerLogin {

	DaoLogin dao = new DaoLogin();
	ModelLogin login = new ModelLogin();

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

	public void carregarCadastroLogin(String tipo, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroLogin frame = new ViewCadastroLogin(tipo, id);
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
		dao.cadastrarLogin(l, true);
	}

	public void cadastrarLoginRestaurante(ModelLogin l) {
		dao.cadastrarLogin(l, false);
	}

	public ModelLogin selecionarLoginCRED(ModelLogin l, boolean email) {
		login = dao.selecionarLoginCRED(l, email);
		return login;
	}

	public boolean logar(ModelLogin l) {
		boolean connected = false;
		connected = dao.logarUsuario(l);
		return connected;
	}

	public String verificarCredenciais(String usuario, String email) {
		String resultado = "";
		if (dao.verificarUsuario(usuario)) {
			resultado = "Este nome de usuário já está em uso.";
		}
		if (dao.verificarEmail(email)) {
			resultado = "Este e-mail já está em uso.";
		}

		return resultado;
	}
	
	public void deletarLogin(ModelUsuario u) {
		dao.deletarLogin(u);
	}

}
