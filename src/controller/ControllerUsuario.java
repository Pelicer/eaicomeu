package controller;

import java.awt.EventQueue;

import dao.DaoUsuario;
import model.ModelUsuario;
import view.usuario.ViewIndex;
import view.usuario.ViewPerfil;
import view.usuario.cadastro.ViewCadastroUsuario;

public class ControllerUsuario {

	public void carregarIndex(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// Passa o usu�rio como par�metro para a p�gina principal
					ModelUsuario u = new ModelUsuario();
					DaoUsuario userDAO = new DaoUsuario();
					u = userDAO.selecionarUsuarioID(id);

					ViewIndex frame = new ViewIndex(u);
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarCadastroUsuario() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroUsuario frame = new ViewCadastroUsuario();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarRecuperacaoSenha() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroUsuario frame = new ViewCadastroUsuario();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarPerfil(ModelUsuario u) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPerfil frame = new ViewPerfil(u);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}