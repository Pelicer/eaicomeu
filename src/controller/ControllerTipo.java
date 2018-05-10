package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DaoTipo;
import model.ModelTipo;

public class ControllerTipo {

	DaoTipo dao = new DaoTipo();
	ModelTipo t = new ModelTipo();

	public List<ModelTipo> carregarTipos() {
		List<ModelTipo> lista = new ArrayList<ModelTipo>();
		lista = dao.carregarTipos();
		return lista;
	}
}
