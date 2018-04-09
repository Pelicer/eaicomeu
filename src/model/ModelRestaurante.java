package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class ModelRestaurante {

	Email email;

	int restaurante_id;
	String restaurante_cnpj;
	String restaurante_cep;
	String restaurante_razaosocial;
	String restaurante_email;
	String restaurante_telefone;
	String restaurante_celular;
	String restaurante_uf;
	String restaurante_cidade;
	String restaurante_bairro;
	String restaurante_endereco;
	String restaurante_logradouro;
	String restaurante_complemento;
	String restaurante_thumbnail;

	public ModelRestaurante(int restaurante_id, String restaurante_cnpj, String restaurante_cep,
			String restaurante_razaosocial, String restaurante_email, String restaurante_telefone,
			String restaurante_celular, String restaurante_uf, String restaurante_cidade, String restaurante_bairro,
			String restaurante_endereco, String restaurante_logradouro, String restaurante_complemento,
			String restaurante_thumbnail) {
		super();
		this.restaurante_id = restaurante_id;
		this.restaurante_cnpj = restaurante_cnpj;
		this.restaurante_cep = restaurante_cep;
		this.restaurante_razaosocial = restaurante_razaosocial;
		this.restaurante_email = restaurante_email;
		this.restaurante_telefone = restaurante_telefone;
		this.restaurante_celular = restaurante_celular;
		this.restaurante_uf = restaurante_uf;
		this.restaurante_cidade = restaurante_cidade;
		this.restaurante_bairro = restaurante_bairro;
		this.restaurante_endereco = restaurante_endereco;
		this.restaurante_logradouro = restaurante_logradouro;
		this.restaurante_complemento = restaurante_complemento;
		this.restaurante_thumbnail = restaurante_thumbnail;
	}

	public ModelRestaurante() {
		super();
	}

	public int getRestaurante_id() {
		return restaurante_id;
	}

	public void setRestaurante_id(int restaurante_id) {
		this.restaurante_id = restaurante_id;
	}

	public String getRestaurante_cnpj() {
		return restaurante_cnpj;
	}

	public void setRestaurante_cnpj(String restaurante_cnpj) {
		this.restaurante_cnpj = restaurante_cnpj;
	}

	public String getRestaurante_cep() {
		return restaurante_cep;
	}

	public void setRestaurante_cep(String restaurante_cep) {
		this.restaurante_cep = restaurante_cep;
	}

	public String getRestaurante_razaosocial() {
		return restaurante_razaosocial;
	}

	public void setRestaurante_razaosocial(String restaurante_razaosocial) {
		this.restaurante_razaosocial = restaurante_razaosocial;
	}

	public String getRestaurante_email() {
		return restaurante_email;
	}

	public void setRestaurante_email(String restaurante_email) {
		this.restaurante_email = restaurante_email;
	}

	public String getRestaurante_telefone() {
		return restaurante_telefone;
	}

	public void setRestaurante_telefone(String restaurante_telefone) {
		this.restaurante_telefone = restaurante_telefone;
	}

	public String getRestaurante_celular() {
		return restaurante_celular;
	}

	public void setRestaurante_celular(String restaurante_celular) {
		this.restaurante_celular = restaurante_celular;
	}

	public String getRestaurante_uf() {
		return restaurante_uf;
	}

	public void setRestaurante_uf(String restaurante_uf) {
		this.restaurante_uf = restaurante_uf;
	}

	public String getRestaurante_cidade() {
		return restaurante_cidade;
	}

	public void setRestaurante_cidade(String restaurante_cidade) {
		this.restaurante_cidade = restaurante_cidade;
	}

	public String getRestaurante_bairro() {
		return restaurante_bairro;
	}

	public void setRestaurante_bairro(String restaurante_bairro) {
		this.restaurante_bairro = restaurante_bairro;
	}

	public String getRestaurante_endereco() {
		return restaurante_endereco;
	}

	public void setRestaurante_endereco(String restaurante_endereco) {
		this.restaurante_endereco = restaurante_endereco;
	}

	public String getRestaurante_logradouro() {
		return restaurante_logradouro;
	}

	public void setRestaurante_logradouro(String restaurante_logradouro) {
		this.restaurante_logradouro = restaurante_logradouro;
	}

	public String getRestaurante_complemento() {
		return restaurante_complemento;
	}

	public void setRestaurante_complemento(String restaurante_complemento) {
		this.restaurante_complemento = restaurante_complemento;
	}

	public String getRestaurante_thumbnail() {
		return restaurante_thumbnail;
	}

	public void setRestaurante_thumbnail(String restaurante_thumbnail) {
		this.restaurante_thumbnail = restaurante_thumbnail;
	}

	// Recuperação de senha.

	public void enviarEmail(String msg, String para) {
		try {
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication("eaicomeuapp@gmail.com", "m3lk0rt#");
			email.setSSLOnConnect(true);
			email.setFrom("eaicomeuapp@gmail.com");
			email.setSubject("Recuperação de senha");
			email.setMsg(msg);
			email.addTo(para);
			email.send();
		} catch (EmailException e) {
			Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
