package controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import dao.DaoProduto;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.pedido.ViewProduto;

public class ControllerProduto {

	DaoProduto dao = new DaoProduto();
	ModelProduto p = new ModelProduto();

	public void carregarProduto(ModelProduto produto, ModelRestaurante restaurante, ModelUsuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduto frame = new ViewProduto(produto, restaurante, usuario);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
