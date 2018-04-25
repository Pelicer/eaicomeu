package controller;

import dao.DaoEntregador;
import model.ModelEntregador;

public class ControllerEntregador {
	
	public void cadastrarEntregador(ModelEntregador e) {
		DaoEntregador dao = new DaoEntregador();
		dao.cadastrarEntregador(e);
	}

}
