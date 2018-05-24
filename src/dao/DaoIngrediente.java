package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelIngrediente;

public class DaoIngrediente {
	public void cadastrarIngrediente(ModelIngrediente i) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_ingrediente (ingrediente_descricao, ingrediente_valor) VALUES (?, ?) ");
			stm.setString(1, i.getIngrediente_descricao());
			stm.setFloat(2, i.getIngrediente_valor());
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ModelIngrediente selecionarIngrediente(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelIngrediente i = new ModelIngrediente();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_ingrediente WHERE ingrediente_id = ?");
			stm.setInt(1, id);
			rs = stm.executeQuery();

			while (rs.next()) {
				i.setIngrediente_id(rs.getInt("ingrediente_id"));
				i.setIngrediente_descricao(rs.getString("ingrediente_descricao"));
				i.setIngrediente_valor(rs.getFloat("ingrediente_valor"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public ModelIngrediente atualizarIngrediente(ModelIngrediente i) {

		Connection con = ConnectionFactory.getConnection();
		ModelIngrediente ni = new ModelIngrediente();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"UPDATE tbl_ingrediente SET ingrediente_descricao = ?, ingrediente_valor = ? WHERE ingrediente_id = ?");
			stm.setString(1, ni.getIngrediente_descricao());
			stm.setFloat(2, ni.getIngrediente_valor());
			stm.setInt(3, ni.getIngrediente_id());
			stm.executeUpdate();

			ni = selecionarIngrediente(i.getIngrediente_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ni;
	}

	public ModelIngrediente deletarIngrediente(ModelIngrediente i) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE from tbl_ingrediente WHERE ingrediente_id = ?");
			stm.setInt(1, i.getIngrediente_id());
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<ModelIngrediente> carregarIngredientes(int produto_id) {

		Connection con = ConnectionFactory.getConnection();
		List<ModelIngrediente> lista = new ArrayList<ModelIngrediente>();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"SELECT * FROM tbl_produtoingrediente LEFT JOIN tbl_ingrediente ON tbl_produtoingrediente.ingrediente_id = tbl_ingrediente.ingrediente_id WHERE produto_id = "
							+ produto_id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelIngrediente i = new ModelIngrediente();
				i.setIngrediente_id(rs.getInt("ingrediente_id"));
				i.setIngrediente_quantidade(rs.getInt("quantidade"));
				i.setIngrediente_descricao(rs.getString("ingrediente_descricao"));
				i.setIngrediente_valor(rs.getFloat("ingrediente_valor"));
				lista.add(i);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<ModelIngrediente> carregarAdicionais(int restaurante_id) {

		Connection con = ConnectionFactory.getConnection();
		List<ModelIngrediente> lista = new ArrayList<ModelIngrediente>();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"select tbl_ingrediente.ingrediente_id, ingrediente_descricao, ingrediente_valor from tbl_ingrediente inner join tbl_produtoingrediente on tbl_ingrediente.ingrediente_id=tbl_produtoingrediente.ingrediente_id inner join tbl_produto on tbl_produtoingrediente.produto_id = tbl_produto.produto_id inner join tbl_tipo on tbl_produto.tipo_id = tbl_tipo.tipo_id where tbl_produto.restaurante_id = "
							+ restaurante_id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelIngrediente i = new ModelIngrediente();
				i.setIngrediente_id(rs.getInt("ingrediente_id"));
				i.setIngrediente_descricao(rs.getString("ingrediente_descricao"));
				i.setIngrediente_valor(rs.getFloat("ingrediente_valor"));
				lista.add(i);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
