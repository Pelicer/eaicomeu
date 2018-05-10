package controller;

import dao.DaoEntregador;
import model.ModelEntregador;

public class ControllerEntregador {

	DaoEntregador dao = new DaoEntregador();
	
	public void cadastrarEntregador(ModelEntregador e) {
		dao.cadastrarEntregador(e);
	}

}
