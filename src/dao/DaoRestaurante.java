package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import model.ModelRestaurante;

public class DaoRestaurante {

	public void cadastrarRestaurante(ModelRestaurante r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_restaurante (restaurante_cnpj, restaurante_razaoSocial, restaurante_email, restaurante_telefone, restaurante_celular, restaurante_uf, restaurante_cidade, restaurante_cep, restaurante_bairro, restaurante_endereco, restaurante_logradouro, restaurante_complemento, restaurante_thumbnail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stm.setString(1, r.getRestaurante_cnpj());
			stm.setString(2, r.getRestaurante_razaosocial());
			stm.setString(3, r.getRestaurante_email());
			stm.setString(4, r.getRestaurante_telefone());
			stm.setString(5, r.getRestaurante_celular());
			stm.setString(6, r.getRestaurante_uf());
			stm.setString(7, r.getRestaurante_cidade());
			stm.setString(8, r.getRestaurante_cep());
			stm.setString(9, r.getRestaurante_bairro());
			stm.setString(10, r.getRestaurante_endereco());
			stm.setString(11, r.getRestaurante_logradouro());
			stm.setString(12, r.getRestaurante_complemento());
			stm.setString(13, r.getRestaurante_thumbnail());
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ModelRestaurante selecionarRestaurante(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelRestaurante r = new ModelRestaurante();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_restaurante WHERE restaurante_id = " + id);
			rs = stm.executeQuery();

			while (rs.next()) {
				r.setRestaurante_id(rs.getInt("restaurante_id"));
				r.setRestaurante_cnpj(rs.getString("restaurante_cnpj"));
				r.setRestaurante_razaosocial(rs.getString("restaurante_razaoSocial"));
				r.setRestaurante_email(rs.getString("restaurante_email"));
				r.setRestaurante_telefone(rs.getString("restaurante_telefone"));
				r.setRestaurante_celular(rs.getString("restaurante_celular"));
				r.setRestaurante_uf(rs.getString("restaurante_uf"));
				r.setRestaurante_cidade(rs.getString("restaurante_cidade"));
				r.setRestaurante_cep(rs.getString("restaurante_cep"));
				r.setRestaurante_bairro(rs.getString("restaurante_bairro"));
				r.setRestaurante_endereco(rs.getString("restaurante_endereco"));
				r.setRestaurante_logradouro(rs.getString("restaurante_logradouro"));
				r.setRestaurante_complemento(rs.getString("restaurante_complemento"));
				r.setRestaurante_thumbnail(rs.getString("restaurante_thumbnail"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public ModelRestaurante atualizarRestaurante(ModelRestaurante r) {

		Connection con = ConnectionFactory.getConnection();
		ModelRestaurante nr = new ModelRestaurante();
		PreparedStatement stm = null;

		try {

			stm = con.prepareStatement(
					"UPDATE tbl_restaurante SET restaurante_cnpj = ?, restaurante_razaoSocial = ?, restaurante_email = ?, restaurante_celular = ?, restaurante_uf = ?, restaurante_cidade = ?, restaurante_cep = ?, restaurante_bairro = ?, restaurante_endereco = ?, restaurante_logradouro = ?, restaurante_complemento = ?, restaurante_thumbnail = ? WHERE restaurante_id = ?");
			stm.setString(1, r.getRestaurante_cnpj());
			stm.setString(2, r.getRestaurante_razaosocial());
			stm.setString(3, r.getRestaurante_email());
			stm.setString(4, r.getRestaurante_celular());
			stm.setString(5, r.getRestaurante_uf());
			stm.setString(6, r.getRestaurante_cidade());
			stm.setString(7, r.getRestaurante_cep());
			stm.setString(8, r.getRestaurante_bairro());
			stm.setString(9, r.getRestaurante_endereco());
			stm.setString(10, r.getRestaurante_logradouro());
			stm.setString(11, r.getRestaurante_complemento());
			stm.setString(12, r.getRestaurante_thumbnail());
			stm.setInt(13, r.getRestaurante_id());
			stm.executeUpdate();

			nr = selecionarRestaurante(r.getRestaurante_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nr;
	}

	public List<ModelRestaurante> carregarRestaurantes() {
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;

		List<ModelRestaurante> restaurantes = new ArrayList<ModelRestaurante>();

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_restaurante");
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelRestaurante r = new ModelRestaurante();
				r.setRestaurante_bairro(rs.getString("restaurante_bairro"));
				r.setRestaurante_celular(rs.getString("restaurante_celular"));
				r.setRestaurante_cep(rs.getString("restaurante_cep"));
				r.setRestaurante_cidade(rs.getString("restaurante_cidade"));
				r.setRestaurante_cnpj(rs.getString("restaurante_cnpj"));
				r.setRestaurante_complemento(rs.getString("restaurante_complemento"));
				r.setRestaurante_email(rs.getString("restaurante_email"));
				r.setRestaurante_endereco(rs.getString("restaurante_endereco"));
				r.setRestaurante_id(rs.getInt("restaurante_id"));
				r.setRestaurante_logradouro(rs.getString("restaurante_logradouro"));
				r.setRestaurante_razaosocial(rs.getString("restaurante_razaoSocial"));
				r.setRestaurante_telefone(rs.getString("restaurante_telefone"));
				r.setRestaurante_thumbnail(rs.getString("restaurante_thumbnail"));
				r.setRestaurante_uf(rs.getString("restaurante_uf"));
				restaurantes.add(r);

			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurantes;

	}
}
