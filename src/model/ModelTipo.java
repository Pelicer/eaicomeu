package model;

public class ModelTipo {

	int tipo_id;
	String tipo_descricao;

	public ModelTipo(String tipo_descricao, int tipo_id) {
		super();
		this.tipo_descricao = tipo_descricao;
		this.tipo_id = tipo_id;
	}

	public ModelTipo() {
		super();
	}

	public String getTipo_descricao() {
		return tipo_descricao;
	}

	public void setTipo_descricao(String tipo_descricao) {
		this.tipo_descricao = tipo_descricao;
	}
	
	public int getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}

}
