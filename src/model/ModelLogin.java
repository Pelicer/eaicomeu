package model;

public class ModelLogin {

	String login_nome;
	String login_senha;
	String login_email;
	int usuario_id;
	int restaurante_id;

	public ModelLogin(String login_nome, String login_senha, String login_email, int usuario_id, int restaurante_id) {
		super();
		this.login_nome = login_nome;
		this.login_senha = login_senha;
		this.login_email = login_email;
		this.usuario_id = usuario_id;
		this.restaurante_id = restaurante_id;
	}

	public ModelLogin() {
		super();
	}

	public String getLogin_nome() {
		return login_nome;
	}

	public void setLogin_nome(String login_nome) {
		this.login_nome = login_nome;
	}

	public String getLogin_senha() {
		return login_senha;
	}

	public void setLogin_senha(String login_senha) {
		this.login_senha = login_senha;
	}

	public String getLogin_email() {
		return login_email;
	}

	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getRestaurante_id() {
		return restaurante_id;
	}

	public void setRestaurante_id(int restaurante_id) {
		this.restaurante_id = restaurante_id;
	}

}
