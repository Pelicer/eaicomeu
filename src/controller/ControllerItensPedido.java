package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DaoItensPedido;
import model.ModelItensPedido;
import model.ModelPedido;
import model.ModelProduto;

public class ControllerItensPedido {

	DaoItensPedido DAO = new DaoItensPedido();

	public void cadastrarItensPedido(ModelPedido pe, ModelProduto pr, String[] adicionais, String[] observacao) {
		DAO.cadastrarItensPedido(pe, pr, adicionais, observacao);
	}

	public void cadastrarItensPedidoNull(ModelProduto pr, String[] observacao) {
		DAO.cadastrarItensPedidoNull(pr, observacao);
	}

	public List<ModelItensPedido> carregarCarrinho(int id) {
		List<ModelItensPedido> itens = new ArrayList<ModelItensPedido>();
		itens = DAO.carregarCarrinho(id);
		return itens;
	}

	public void limparCarrinho(int pedido_id) {
		DAO.limparCarrinho(pedido_id);
	}

	public ModelItensPedido selecionarItensPedido(int id) {
		ModelItensPedido ip = new ModelItensPedido();
		ip = DAO.selecionarItensPedido(id);
		return ip;
	}

	public ModelItensPedido selecionarUltimaEntrada() {
		ModelItensPedido ip = new ModelItensPedido();
		ip = DAO.selecionarUltimaEntrada();
		return ip;
	}

	public void atualizarItensPedido(int pedidoID, String[] adicionais, int ID) {
		DAO.atualizarItensPedido(pedidoID, adicionais, ID);
	}

	public void excluirItem(ModelItensPedido ip) {
		DAO.excluirItem(ip);
	}

	public List<ModelItensPedido> selecionarItemPorPedido(int id) {
		List<ModelItensPedido> itens = new ArrayList<ModelItensPedido>();
		itens = DAO.selecionarItemPorPedido(id);
		return itens;
	}

}
