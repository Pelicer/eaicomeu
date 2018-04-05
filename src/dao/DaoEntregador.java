package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelEntregador;

public class DaoEntregador {

	public void cadastrarEntregador(ModelEntregador e) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("INSERT INTO tbl_entregador (entregador_cnh, usuario_id) VALUES(?, ?)");
			stm.setString(1, e.getEntregador_cnh());
			stm.setInt(2, e.getUsuario_id());
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ModelEntregador selecionarEntregador(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelEntregador e = new ModelEntregador();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_entregador WHERE entregador_id = " + id);
			rs = stm.executeQuery();

			while (rs.next()) {
				e.setEntregador_id(rs.getInt("entregador_id"));
				e.setEntregador_cnh(rs.getString("entregador_cnh"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public ModelEntregador atualizarEntregador(ModelEntregador e) {

		Connection con = ConnectionFactory.getConnection();
		ModelEntregador ne = new ModelEntregador();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("UPDATE tbl_entregador SET entregador_cnh = ? WHERE entregador_id = ?");
			stm.setString(1, e.getEntregador_cnh());
			stm.setInt(2, e.getEntregador_id());
			stm.executeUpdate();

			ne = selecionarEntregador(e.getEntregador_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ne;
	}

}
