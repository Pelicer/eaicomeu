package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
