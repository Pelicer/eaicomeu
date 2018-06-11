package controller;

import dao.DaoPagamento;
import model.ModelPagamento;

public class ControllerPagamento {

	ModelPagamento pag = new ModelPagamento();
	DaoPagamento DAO = new DaoPagamento();

	public ModelPagamento selecionarPagamento(int id) {
		pag = DAO.selecionarPagamento(id);
		return pag;
	}

}
