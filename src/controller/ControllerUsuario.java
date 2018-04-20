package controller;

import java.awt.EventQueue;

import javax.swing.JDialog;

import dao.DaoRestaurante;
import dao.DaoUsuario;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.ViewReenvio;
import view.usuario.ViewIndex;
import view.usuario.ViewPerfil;
import view.usuario.cadastro.Switch;
import view.usuario.cadastro.ViewCadastroUsuario;
import view.usuario.pedido.ViewRestaurante;

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

	public void carregarRestaurante(String razaoSocial, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Passa o restaurante como parâmetro para a página do restaurante
					ModelRestaurante r = new ModelRestaurante();
					DaoRestaurante resDao = new DaoRestaurante();
					r = resDao.selecionarRestauranteRazaoSocial(razaoSocial);

					// Passa o usuário como parâmetro para a página do restaurante
					ModelUsuario u = new ModelUsuario();
					DaoUsuario userDAO = new DaoUsuario();
					u = userDAO.selecionarUsuarioID(id);

					ViewRestaurante frame = new ViewRestaurante(r, u);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarSwitch() {
		try {
			Switch dialog = new Switch();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregarCadastroUsuario(String tipoUsuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroUsuario frame = new ViewCadastroUsuario(tipoUsuario);
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
					ViewReenvio frame = new ViewReenvio();
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

	public ModelUsuario selecionarUsuarioID(int id) {
		DaoUsuario dao = new DaoUsuario();
		ModelUsuario u = new ModelUsuario();
		u = dao.selecionarUsuarioID(id);
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

	public String verificarObrigatorios(ModelUsuario u) {
		String resultado = "";
		if (u.getUsuario_bairro().equals("") || u.getUsuario_cep().equals("") || u.getUsuario_cidade().equals("")
				|| u.getUsuario_endereco().equals("") || u.getUsuario_uf().equals("")
				|| u.getUsuario_logradouro().equals("")) {
			resultado = "Campos de endereço não podem estar vazios.";
		}
		if (u.getUsuario_celular().equals("")) {
			resultado = "O campo celular não pode ser inválido.";
		}
		if (u.getUsuario_email().equals("")) {
			resultado = "O campo e-mail é obrigatório.";
		}
		if (u.getUsuario_nome().equals("")) {
			resultado = "Por favor, identifique-se com um nome.";
		}
		if (u.getUsuario_cpf().equals("")) {
			resultado = "Por favor, digite seu CPF.";
		}
		return resultado;
	}
}
