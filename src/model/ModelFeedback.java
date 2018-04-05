package model;

public class ModelFeedback {

	int feedback_notaProduto;
	int feedback_notaEmbalagem;
	int feedback_notaEntrega;
	int feedback_notaAtendimento;
	int feedback_notaPreco;
	int pedido_id;
	String feedback_descricao;

	public ModelFeedback(int feedback_notaProduto, int feedback_notaEmbalagem, int feedback_notaEntrega,
			int feedback_notaAtendimento, int feedback_notaPreco, String feedback_descricao, int pedido_id) {
		super();
		this.feedback_notaProduto = feedback_notaProduto;
		this.feedback_notaEmbalagem = feedback_notaEmbalagem;
		this.feedback_notaEntrega = feedback_notaEntrega;
		this.feedback_notaAtendimento = feedback_notaAtendimento;
		this.feedback_notaPreco = feedback_notaPreco;
		this.feedback_descricao = feedback_descricao;
		this.pedido_id = pedido_id;
	}

	public ModelFeedback() {
		super();
	}

	public int getFeedback_notaProduto() {
		return feedback_notaProduto;
	}

	public void setFeedback_notaProduto(int feedback_notaProduto) {
		this.feedback_notaProduto = feedback_notaProduto;
	}

	public int getFeedback_notaEmbalagem() {
		return feedback_notaEmbalagem;
	}

	public void setFeedback_notaEmbalagem(int feedback_notaEmbalagem) {
		this.feedback_notaEmbalagem = feedback_notaEmbalagem;
	}

	public int getFeedback_notaEntrega() {
		return feedback_notaEntrega;
	}

	public void setFeedback_notaEntrega(int feedback_notaEntrega) {
		this.feedback_notaEntrega = feedback_notaEntrega;
	}

	public int getFeedback_notaAtendimento() {
		return feedback_notaAtendimento;
	}

	public void setFeedback_notaAtendimento(int feedback_notaAtendimento) {
		this.feedback_notaAtendimento = feedback_notaAtendimento;
	}

	public int getFeedback_notaPreco() {
		return feedback_notaPreco;
	}

	public void setFeedback_notaPreco(int feedback_notaPreco) {
		this.feedback_notaPreco = feedback_notaPreco;
	}

	public String getFeedback_descricao() {
		return feedback_descricao;
	}

	public void setFeedback_descricao(String feedback_descricao) {
		this.feedback_descricao = feedback_descricao;
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

}
