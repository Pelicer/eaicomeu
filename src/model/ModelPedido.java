package model;

import java.util.Date;

public class ModelPedido {

	int usuario_id;
	int pedido_id;
	int status_id;
	float valorTotal;
	Date pedido_data;

	public ModelPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelPedido(int usuario_id, int pedido_id, int status_id, float valorTotal, Date pedido_data) {
		super();
		this.usuario_id = usuario_id;
		this.pedido_id = pedido_id;
		this.status_id = status_id;
		this.valorTotal = valorTotal;
		this.pedido_data = pedido_data;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getPedido_data() {
		return pedido_data;
	}

	public void setPedido_data(Date pedido_data) {
		this.pedido_data = pedido_data;
	}

}
