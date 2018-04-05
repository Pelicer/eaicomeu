package model;

import java.sql.Date;

public class ModelPedido {

	int usuario_id;
	Date pedido_data;

	public ModelPedido(int usuario_id, Date pedido_data) {
		super();
		this.usuario_id = usuario_id;
		this.pedido_data = pedido_data;
	}

	public ModelPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Date getPedido_data() {
		return pedido_data;
	}

	public void setPedido_data(Date pedido_data) {
		this.pedido_data = pedido_data;
	}

}
