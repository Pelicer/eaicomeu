package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DaoTipo;
import model.ModelTipo;

public class ControllerTipo {

	DaoTipo dao = new DaoTipo();
	ModelTipo t = new ModelTipo();

	public List<ModelTipo> carregarTipos(int id) {
		List<ModelTipo> lista = new ArrayList<ModelTipo>();
		lista = dao.carregarTipos(id);
		return lista;
	}
}
