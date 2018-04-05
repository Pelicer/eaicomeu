package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ModelFeedback;

public class DaoFeedback {
	public void cadastrarFeedback(ModelFeedback f) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_feedback (feedback_notaProduto, feedback_notaEmbalagem, feedback_notaEntrega, feedback_notaAtendimento, feedback_notaPreco, feedback_descricao, pedido_id) VALUES (?, ?, ?, ?, ?, ?, ?) ");
			stm.setInt(1, f.getFeedback_notaProduto());
			stm.setInt(2, f.getFeedback_notaEmbalagem());
			stm.setInt(3, f.getFeedback_notaEntrega());
			stm.setInt(4, f.getFeedback_notaAtendimento());
			stm.setInt(5, f.getFeedback_notaPreco());
			stm.setString(6, f.getFeedback_descricao());
			stm.setInt(7, f.getPedido_id());
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
