package model;

public class ModelProduto {

	int produto_id;
	int tipo_id;
	int restaurante_id;
	float produto_valor;
	String produto_nome;
	String produto_descricao;
	String produto_thumbnail;

	public ModelProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelProduto(int produto_id, int tipo_id, int restaurante_id, float produto_valor, String produto_nome,
			String produto_descricao, String produto_thumbnail) {
		super();
		this.produto_id = produto_id;
		this.tipo_id = tipo_id;
		this.restaurante_id = restaurante_id;
		this.produto_valor = produto_valor;
		this.produto_nome = produto_nome;
		this.produto_descricao = produto_descricao;
		this.produto_thumbnail = produto_thumbnail;
	}

	public int getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}

	public int getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}

	public int getRestaurante_id() {
		return restaurante_id;
	}

	public void setRestaurante_id(int restaurante_id) {
		this.restaurante_id = restaurante_id;
	}

	public float getProduto_valor() {
		return produto_valor;
	}

	public void setProduto_valor(float produto_valor) {
		this.produto_valor = produto_valor;
	}

	public String getProduto_nome() {
		return produto_nome;
	}

	public void setProduto_nome(String produto_nome) {
		this.produto_nome = produto_nome;
	}

	public String getProduto_descricao() {
		return produto_descricao;
	}

	public void setProduto_descricao(String produto_descricao) {
		this.produto_descricao = produto_descricao;
	}

	public String getProduto_thumbnail() {
		return produto_thumbnail;
	}

	public void setProduto_thumbnail(String produto_thumbnail) {
		this.produto_thumbnail = produto_thumbnail;
	}

}
