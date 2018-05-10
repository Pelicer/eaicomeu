package controller;

import java.awt.EventQueue;

import javax.swing.JDialog;

import dao.DaoRestaurante;
import dao.DaoUsuario;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.ViewReenvio;
import view.usuario.ViewCarrinho;
import view.usuario.ViewIndex;
import view.usuario.ViewPedido;
import view.usuario.ViewPerfil;
import view.usuario.cadastro.ViewCadastroSwitch;
import view.usuario.cadastro.ViewCadastroUsuario;
import view.usuario.pedido.ViewRestaurante;

public class ControllerUsuario {

	DaoUsuario dao = new DaoUsuario();
	ModelUsuario u = new ModelUsuario();

	// Métodos de carregamento.
	public void carregarIndex(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// Passa o usuário como parâmetro para a página principal
					u = dao.selecionarUsuarioID(id);

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
			ViewCadastroSwitch dialog = new ViewCadastroSwitch();
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

	public void carregarPedidos(ModelUsuario u) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPedido frame = new ViewPedido(u);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarCarrinho(ModelUsuario u) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCarrinho frame = new ViewCarrinho(u);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void cadastrarUsuario(ModelUsuario u) {
		dao.cadastrarUsuario(u);
	}

	// Métodos de usuário.
	public ModelUsuario selecionarUsuarioCPF(String cpf) {
		u = dao.selecionarUsuarioCPF(cpf);
		return u;
	}

	public ModelUsuario selecionarUsuarioID(int id) {
		u = dao.selecionarUsuarioID(id);
		return u;
	}

	public void atualizarUsuario(ModelUsuario u) {
		dao.atualizarUsuario(u);
	}

	public boolean recuperarSenha(String email) {
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
