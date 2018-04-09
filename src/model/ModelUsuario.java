package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class ModelUsuario {

	Email email;

	int usuario_id;
	String usuario_cpf;
	String usuario_celular;
	String usuario_cep;
	String usuario_nome;
	String usuario_email;
	String usuario_uf;
	String usuario_cidade;
	String usuario_bairro;
	String usuario_endereco;
	String usuario_logradouro;
	String usuario_complemento;
	String usuario_thumbnail;

	public ModelUsuario(String usuario_nome, String usuario_email, String usuario_uf, String usuario_cidade,
			String usuario_bairro, String usuario_endereco, String usuario_logradouro, String usuario_complemento,
			String usuario_thumbnail, String usuario_cpf, String usuario_celular, String usuario_cep, int usuario_id) {
		super();
		this.usuario_id = usuario_id;
		this.usuario_cpf = usuario_cpf;
		this.usuario_nome = usuario_nome;
		this.usuario_email = usuario_email;
		this.usuario_uf = usuario_uf;
		this.usuario_cidade = usuario_cidade;
		this.usuario_bairro = usuario_bairro;
		this.usuario_endereco = usuario_endereco;
		this.usuario_logradouro = usuario_logradouro;
		this.usuario_complemento = usuario_complemento;
		this.usuario_thumbnail = usuario_thumbnail;
		this.usuario_celular = usuario_celular;
		this.usuario_cep = usuario_cep;
	}

	public ModelUsuario() {
		super();
	}

	public String getUsuario_nome() {
		return usuario_nome;
	}

	public void setUsuario_nome(String usuario_nome) {
		this.usuario_nome = usuario_nome;
	}

	public String getUsuario_email() {
		return usuario_email;
	}

	public void setUsuario_email(String usuario_email) {
		this.usuario_email = usuario_email;
	}

	public String getUsuario_uf() {
		return usuario_uf;
	}

	public void setUsuario_uf(String usuario_uf) {
		this.usuario_uf = usuario_uf;
	}

	public String getUsuario_cidade() {
		return usuario_cidade;
	}

	public void setUsuario_cidade(String usuario_cidade) {
		this.usuario_cidade = usuario_cidade;
	}

	public String getUsuario_bairro() {
		return usuario_bairro;
	}

	public void setUsuario_bairro(String usuario_bairro) {
		this.usuario_bairro = usuario_bairro;
	}

	public String getUsuario_endereco() {
		return usuario_endereco;
	}

	public void setUsuario_endereco(String usuario_endereco) {
		this.usuario_endereco = usuario_endereco;
	}

	public String getUsuario_logradouro() {
		return usuario_logradouro;
	}

	public void setUsuario_logradouro(String usuario_logradouro) {
		this.usuario_logradouro = usuario_logradouro;
	}

	public String getUsuario_complemento() {
		return usuario_complemento;
	}

	public void setUsuario_complemento(String usuario_complemento) {
		this.usuario_complemento = usuario_complemento;
	}

	public String getUsuario_thumbnail() {
		return usuario_thumbnail;
	}

	public void setUsuario_thumbnail(String usuario_thumbnail) {
		this.usuario_thumbnail = usuario_thumbnail;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUsuario_cpf() {
		return usuario_cpf;
	}

	public void setUsuario_cpf(String usuario_cpf) {
		this.usuario_cpf = usuario_cpf;
	}

	public String getUsuario_celular() {
		return usuario_celular;
	}

	public void setUsuario_celular(String usuario_celular) {
		this.usuario_celular = usuario_celular;
	}

	public String getUsuario_cep() {
		return usuario_cep;
	}

	public void setUsuario_cep(String usuario_cep) {
		this.usuario_cep = usuario_cep;
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
