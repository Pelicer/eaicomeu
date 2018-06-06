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
		lstped = DAO.carregarLista(id);
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

	public void carregarViewAdicionais(ModelUsuario u, ModelPedido pe, ModelProduto pr, ModelRestaurante r,
			String[] observacao) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdicionais frame = new ViewAdicionais(u, pe, pr, r, observacao);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void carregarViewPagamento(ModelPedido p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPagamento frame = new ViewPagamento(p);
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

}
