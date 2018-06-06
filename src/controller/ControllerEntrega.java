package controller;

import java.awt.EventQueue;

import model.ModelPedido;
import model.ModelUsuario;
import view.usuario.pedido.ViewEntrega;

public class ControllerEntrega {

	public void carregarViewEntrega(ModelUsuario u, ModelPedido p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEntrega frame = new ViewEntrega(u, p);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
