package model;

public class ModelIngrediente {

	int ingrediente_id;
	int ingrediente_quantidade;
	float ingrediente_valor;
	String ingrediente_descricao;

	public ModelIngrediente(int ingrediente_id, int ingrediente_quantidade, float ingrediente_valor,
			String ingrediente_descricao) {
		super();
		this.ingrediente_id = ingrediente_id;
		this.ingrediente_valor = ingrediente_valor;
		this.ingrediente_descricao = ingrediente_descricao;
		this.ingrediente_quantidade = ingrediente_quantidade;
	}

	public int getIngrediente_id() {
		return ingrediente_id;
	}

	public void setIngrediente_id(int ingrediente_id) {
		this.ingrediente_id = ingrediente_id;
	}

	public int getIngrediente_quantidade() {
		return ingrediente_quantidade;
	}

	public void setIngrediente_quantidade(int ingrediente_quantidade) {
		this.ingrediente_quantidade = ingrediente_quantidade;
	}

	public ModelIngrediente() {
		super();
	}

	public float getIngrediente_valor() {
		return ingrediente_valor;
	}

	public void setIngrediente_valor(float ingrediente_valor) {
		this.ingrediente_valor = ingrediente_valor;
	}

	public String getIngrediente_descricao() {
		return ingrediente_descricao;
	}

	public void setIngrediente_descricao(String ingrediente_descricao) {
		this.ingrediente_descricao = ingrediente_descricao;
	}

}
