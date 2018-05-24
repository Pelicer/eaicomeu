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

	public List<ModelItensPedido> carregarCarrinho(int id) {
		List<ModelItensPedido> itens = new ArrayList<ModelItensPedido>();
		itens = DAO.carregarCarrinho(id);
		return itens;
	}

	public ModelItensPedido selecionarItensPedido(int id) {
		ModelItensPedido ip = new ModelItensPedido();
		ip = DAO.selecionarItensPedido(id);
		return ip;
	}

}