package model;

public class ModelEntregador extends ModelUsuario {

	int entregador_id;
	String entregador_cnh;

	public ModelEntregador() {
		super();
	}

	public ModelEntregador(String usuario_nome, String usuario_email, String usuario_uf, String usuario_cidade,
			String usuario_bairro, String usuario_endereco, String usuario_logradouro, String usuario_complemento,
			String usuario_thumbnail, String usuario_cpf, String usuario_celular, String usuario_cep, int usuario_id) {
		super(usuario_nome, usuario_email, usuario_uf, usuario_cidade, usuario_bairro, usuario_endereco,
				usuario_logradouro, usuario_complemento, usuario_cpf, usuario_celular, usuario_cep, usuario_id);
	}

	public ModelEntregador(String usuario_nome, String usuario_email, String usuario_uf, String usuario_cidade,
			String usuario_bairro, String usuario_endereco, String usuario_logradouro, String usuario_complemento,
			String usuario_thumbnail, String usuario_cpf, String usuario_celular, String usuario_cep,
			String entregador_cnh, int usuario_id, int entregador_id) {
		super(usuario_nome, usuario_email, usuario_uf, usuario_cidade, usuario_bairro, usuario_endereco,
				usuario_logradouro, usuario_complemento, usuario_cpf, usuario_celular, usuario_cep, usuario_id);
		this.entregador_id = entregador_id;
		this.entregador_cnh = entregador_cnh;
	}

	public String getEntregador_cnh() {
		return entregador_cnh;
	}

	public void setEntregador_cnh(String entregador_cnh) {
		this.entregador_cnh = entregador_cnh;
	}

	public int getEntregador_id() {
		return entregador_id;
	}

	public void setEntregador_id(int entregador_id) {
		this.entregador_id = entregador_id;
	}

}
