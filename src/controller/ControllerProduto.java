package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DaoProduto;
import model.ModelProduto;

public class ControllerProduto {

	DaoProduto dao = new DaoProduto();
	ModelProduto p = new ModelProduto();

	public List<ModelProduto> carregarProdutos(int id) {
		List<ModelProduto> lista = new ArrayList<ModelProduto>();
		lista = dao.carregarProdutos(id);
		return lista;
	}

	public ModelProduto selecionarProduto(int id) {
		p = dao.selecionarProduto(id);
		return p;
	}

}
