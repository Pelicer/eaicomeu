package controller;

import java.awt.EventQueue;
import java.util.List;

import dao.DaoRestaurante;
import model.ModelRestaurante;
import view.restaurante.ViewIndexRes;

public class ControllerRestaurante {

	public void carregarIndex(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// Passa o restaurante como parâmetro para a página principal
					ModelRestaurante r = new ModelRestaurante();
					DaoRestaurante resDAO = new DaoRestaurante();
					r = resDAO.selecionarRestaurante(id);

					ViewIndexRes frame = new ViewIndexRes(r);
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public List<ModelRestaurante> carregarRestaurantes() {
		DaoRestaurante dao = new DaoRestaurante();
		List<ModelRestaurante> r = dao.carregarRestaurantes();
		return r;
	}

}
