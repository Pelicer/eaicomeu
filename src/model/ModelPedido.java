package model;

import java.util.Date;

public class ModelPedido {

	int usuario_id;
	int pedido_id;
	int status_id;
	int entrega_id;
	int pagamento_id;
	float valorTotal;
	Date pedido_data;
	String enderecoEntrega;

	public ModelPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelPedido(int usuario_id, int pedido_id, int status_id, int entrega_id, int pagamento_id, float valorTotal,
			Date pedido_data, String enderecoEntrega) {
		super();
		this.usuario_id = usuario_id;
		this.pedido_id = pedido_id;
		this.status_id = status_id;
		this.entrega_id = entrega_id;
		this.pagamento_id = pagamento_id;
		this.valorTotal = valorTotal;
		this.pedido_data = pedido_data;
		this.enderecoEntrega = enderecoEntrega;
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

	public int getEntrega_id() {
		return entrega_id;
	}

	public void setEntrega_id(int entrega_id) {
		this.entrega_id = entrega_id;
	}

	public int getPagamento_id() {
		return pagamento_id;
	}

	public void setPagamento_id(int pagamento_id) {
		this.pagamento_id = pagamento_id;
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

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

}
