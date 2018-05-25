package model;

public class ModelItensPedido {

	int pedido_id;
	int produto_id;
	int itensPedido_id;
	String itensPedido_adicionais;
	String itensPedido_observacao;

	public ModelItensPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelItensPedido(int pedido_id, int produto_id, int itensPedido_id, String itensPedido_adicionais,
			String itensPedido_observacao) {
		super();
		this.pedido_id = pedido_id;
		this.produto_id = produto_id;
		this.itensPedido_id = itensPedido_id;
		this.itensPedido_adicionais = itensPedido_adicionais;
		this.itensPedido_observacao = itensPedido_observacao;
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public int getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}

	public int getItensPedido_id() {
		return itensPedido_id;
	}

	public void setItensPedido_id(int itensPedido_id) {
		this.itensPedido_id = itensPedido_id;
	}

	public String getItensPedido_adicionais() {
		return itensPedido_adicionais;
	}

	public void setItensPedido_adicionais(String itensPedido_adicionais) {
		this.itensPedido_adicionais = itensPedido_adicionais;
	}

	public String getItensPedido_observacao() {
		return itensPedido_observacao;
	}

	public void setItensPedido_observacao(String itensPedido_observacao) {
		this.itensPedido_observacao = itensPedido_observacao;
	}

}
