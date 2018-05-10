package controller;

import java.awt.EventQueue;
import java.util.List;

import dao.DaoRestaurante;
import model.ModelRestaurante;
import view.restaurante.ViewIndexRes;

public class ControllerRestaurante {

	DaoRestaurante dao = new DaoRestaurante();
	ModelRestaurante r = new ModelRestaurante();

	public void carregarIndex(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// Passa o restaurante como parâmetro para a página principal

					r = dao.selecionarRestauranteID(id);

					ViewIndexRes frame = new ViewIndexRes(r);
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void cadastrarRestaurante(ModelRestaurante r) {
		dao.cadastrarRestaurante(r);
	}

	public ModelRestaurante selecionarRestauranteID(int id) {
		r = dao.selecionarRestauranteID(id);
		return r;
	}

	public ModelRestaurante selecionarRestauranteCNPJ(String cnpj) {
		r = dao.selecionarRestauranteCNPJ(cnpj);
		return r;
	}

	public ModelRestaurante selecionarRestauranteRazaoSocial(String razaoSocial) {
		r = dao.selecionarRestauranteRazaoSocial(razaoSocial);
		return r;
	}

	public List<ModelRestaurante> carregarRestaurantes() {
		List<ModelRestaurante> r = dao.carregarRestaurantes();
		return r;
	}

	public String verificarObrigatorios(ModelRestaurante r) {
		String resultado = "";
		if (r.getRestaurante_bairro().equals("") || r.getRestaurante_cep().equals("")
				|| r.getRestaurante_cidade().equals("") || r.getRestaurante_endereco().equals("")
				|| r.getRestaurante_uf().equals("") || r.getRestaurante_logradouro().equals("")) {
			resultado = "Campos de endereço não podem estar vazios.";
		}
		if (r.getRestaurante_celular().equals("")) {
			resultado = "O campo celular não pode ser inválido.";
		}
		if (r.getRestaurante_email().equals("")) {
			resultado = "O campo e-mail é obrigatório.";
		}
		if (r.getRestaurante_razaosocial().equals("")) {
			resultado = "Por favor, identifique-se com um nome.";
		}
		if (r.getRestaurante_cnpj().equals("")) {
			resultado = "Por favor, digite seu CPF.";
		}
		return resultado;
	}

}
