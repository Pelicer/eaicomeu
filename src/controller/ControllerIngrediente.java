package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DaoIngrediente;
import model.ModelIngrediente;

public class ControllerIngrediente {

	ModelIngrediente i = new ModelIngrediente();
	DaoIngrediente daoi = new DaoIngrediente();

	public List<ModelIngrediente> carregarIngredientes(int produto_id) {
		List<ModelIngrediente> lista = new ArrayList<ModelIngrediente>();
		lista = daoi.carregarIngredientes(produto_id);
		return lista;
	}
	
	public List<ModelIngrediente> carregarAdicionais(int restaurante_id) {
		List<ModelIngrediente> lista = new ArrayList<ModelIngrediente>();
		lista = daoi.carregarAdicionais(restaurante_id);
		return lista;
	}
}
