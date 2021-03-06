package controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import dao.DaoPedido;
import model.ModelPedido;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.ViewCarrinho;
import view.usuario.pedido.ViewAdicionais;
import view.usuario.pedido.ViewHistorico;
import view.usuario.pedido.ViewPagamento;

public class ControllerPedido {

	ModelPedido p = new ModelPedido();
	DaoPedido DAO = new DaoPedido();

	public void cadastrarPedido(ModelPedido pedido) {
		DAO.cadastrarPedido(pedido);
	}

	public void excluirPedidosAbertos() {
		DAO.excluirPedidosAbertos();
	}

	public ModelPedido atualizarPedido(ModelPedido pedido) {
		p = DAO.atualizarPedido(pedido);
		return p;
	}

	public ModelPedido selecionarPedido(int id) {
		p = DAO.selecionarPedido(id);
		return p;
	}

	public ModelPedido selecionarPedidoAberto(int usuario, int restaurante) {
		p = DAO.selecionarPedidoAberto(usuario, restaurante);
		return p;
	}

	public ModelPedido selecionarPedidosAbertos(int usuario) {
		p = DAO.selecionarPedidosAbertos(usuario);
		return p;
	}

	public ModelPedido selecionarUltimaEntrada() {
		p = DAO.selecionarUltimaEntrada();
		return p;
	}

	public void deletarPedido(int id) {
		DAO.deletarPedido(id);
	}

	public List<ModelPedido> carregarCarrinho(int id) {
		List<ModelPedido> lstped = new ArrayList<ModelPedido>();
		lstped = DAO.carregarCarrinho(id);
		return lstped;
	}

	public List<ModelPedido> carregarTodosPedidos(int id) {
		List<ModelPedido> lstped = new ArrayList<ModelPedido>();
		lstped = DAO.carregarTodosPedidos(id);
		return lstped;
	}

	public boolean verificarPedidoAberto(int usuario, int restaurante) {
		boolean i = DAO.verificarPedidoAberto(usuario, restaurante);
		return i;
	}

	public boolean verificarOutrosPedidos(int usuario, int restaurante) {
		boolean i = DAO.verificarOutrosPedidos(usuario, restaurante);
		return i;
	}

	public void atualizarPreco(int pedido_id) {
		DAO.atualizarPreco(pedido_id);
	}

	public List<Integer> pagamentosRestaurante(ModelPedido p) {
		List<Integer> pagamentos = new ArrayList<Integer>();
		pagamentos = DAO.pagamentosRestaurante(p);
		return pagamentos;
	}

	public int selecionarRestaurante(ModelPedido p) {
		int i = DAO.selecionarRestaurante(p);
		return i;
	}

	public String selecionarFormaEntrega(ModelPedido p) {
		String formaEntrega = DAO.selecionarFormaEntrega(p);
		return formaEntrega;
	}

	public void carregarViewAdicionais(ModelUsuario u, ModelPedido pe, ModelProduto pr, ModelRestaurante r,
			String[] observacao) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdicionais frame = new ViewAdicionais(u, pe, pr, r);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarViewPagamento(ModelUsuario u, ModelPedido p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPagamento frame = new ViewPagamento(u, p);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarViewCarrinho(ModelUsuario u, ModelPedido p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCarrinho frame = new ViewCarrinho(u, p);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarViewHistorico(ModelUsuario u, ModelPedido p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHistorico frame = new ViewHistorico(u, p);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
