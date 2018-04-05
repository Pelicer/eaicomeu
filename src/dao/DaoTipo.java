package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelTipo;

public class DaoTipo {

	public void cadastrarTipo(ModelTipo t) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("INSERT INTO tbl_tipo (tipo_descricao) VALUES (?) ");
			stm.setString(1, t.getTipo_descricao());
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ModelTipo selecionarTipo(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelTipo t = new ModelTipo();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_tipo WHERE tipo_id = ?");
			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				t.setTipo_id(rs.getInt("tipo_id"));
				t.setTipo_descricao(rs.getString("tipo_descricao"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return t;
	}

	public ModelTipo atualizarTipo(ModelTipo t) {

		Connection con = ConnectionFactory.getConnection();
		ModelTipo nt = new ModelTipo();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("UPDATE tbl_tipo SET tipo_descricao = ? WHERE tipo_id = ?");
			stm.setString(1, t.getTipo_descricao());
			stm.setInt(2, t.getTipo_id());
			stm.executeUpdate();
			
			nt = selecionarTipo(t.getTipo_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nt;
	}

}
