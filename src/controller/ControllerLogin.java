package controller;

import java.awt.EventQueue;

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
}
