package model;

public class ModelPagamento {

	int pagamento_id;
	String pagamento_descricao;
	String pagamento_bandeira;

	public ModelPagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelPagamento(int pagamento_id, String pagamento_descricao, String pagamento_bandeira) {
		super();
		this.pagamento_id = pagamento_id;
		this.pagamento_descricao = pagamento_descricao;
		this.pagamento_bandeira = pagamento_bandeira;
	}

	public int getPagamento_id() {
		return pagamento_id;
	}

	public void setPagamento_id(int pagamento_id) {
		this.pagamento_id = pagamento_id;
	}

	public String getPagamento_descricao() {
		return pagamento_descricao;
	}

	public void setPagamento_descricao(String pagamento_descricao) {
		this.pagamento_descricao = pagamento_descricao;
	}

	public String getPagamento_bandeira() {
		return pagamento_bandeira;
	}

	public void setPagamento_bandeira(String pagamento_bandeira) {
		this.pagamento_bandeira = pagamento_bandeira;
	}

}
