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

					// Passa o usuário como parâmetro para a página principal
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

	public void cadastrarUsuario(ModelUsuario u) {
		DaoUsuario dao = new DaoUsuario();
		dao.cadastrarUsuario(u);
	}

	public ModelUsuario selecionarUsuarioCPF(String cpf) {
		DaoUsuario dao = new DaoUsuario();
		ModelUsuario u = new ModelUsuario();
		u = dao.selecionarUsuarioCPF(cpf);
		return u;
	}

	public void atualizarUsuario(ModelUsuario u) {
		DaoUsuario dao = new DaoUsuario();
		dao.atualizarUsuario(u);
	}

	public boolean recuperarSenha(String email) {
		DaoUsuario dao = new DaoUsuario();
		return dao.recuperarSenha(email);
	}
}
