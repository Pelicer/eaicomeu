package model;

import java.util.Date;

public class ModelStatus {

	int status_id;
	int pedido_id;
	Date status_update_datetime;
	String status_data_formatada;

	public ModelStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelStatus(int status_id, int pedido_id, Date status_update_datetime, String status_data_formatada) {
		super();
		this.status_id = status_id;
		this.pedido_id = pedido_id;
		this.status_update_datetime = status_update_datetime;
		this.status_data_formatada = status_data_formatada;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public Date getStatus_update_datetime() {
		return status_update_datetime;
	}

	public void setStatus_update_datetime(Date status_update_datetime) {
		this.status_update_datetime = status_update_datetime;
	}

	public String getStatus_data_formatada() {
		return status_data_formatada;
	}

	public void setStatus_data_formatada(String status_data_formatada) {
		this.status_data_formatada = status_data_formatada;
	}

}
