package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelPagamento;

public class DaoPagamento {

	public ModelPagamento selecionarPagamento(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelPagamento pag = new ModelPagamento();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_formapagamento WHERE formaPagamento_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				pag.setPagamento_bandeira(rs.getString("formaPagamento_bandeira"));
				pag.setPagamento_descricao(rs.getString("formaPagamento_descricao"));
				pag.setPagamento_id(rs.getInt("formaPagamento_id"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pag;

	}

}
