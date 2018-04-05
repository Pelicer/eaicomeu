package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class ModelRecuperacaoSenha {

	Email email;

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
			Logger.getLogger(ModelRecuperacaoSenha.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}