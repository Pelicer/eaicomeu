package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DaoStatus;
import model.ModelPedido;
import model.ModelStatus;

public class ControllerStatus {

	ModelStatus status = new ModelStatus();
	DaoStatus DAO = new DaoStatus();

	public void atualizarStatusHistorico(ModelPedido p) {
		DAO.atualizarStatusHistorico(p);
	}

	public String statusDescricao(int id) {
		String descricao = "";
		descricao = DAO.statusDescricao(id);
		return descricao;
	}

	public List<ModelStatus> carregarStatusHistorico(ModelPedido p) {
		List<ModelStatus> historico = new ArrayList<ModelStatus>();
		historico = DAO.carregarStatusHistorico(p);
		return historico;
	}

}
