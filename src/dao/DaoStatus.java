package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.ModelPedido;
import model.ModelStatus;

public class DaoStatus {

	public void atualizarStatusHistorico(ModelPedido p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String dataFormatada = formato.format(p.getPedido_data());

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_status_update (status_id, pedido_id, status_update_datetime) VALUES( ?, ?, ?);");
			stm.setInt(1, p.getStatus_id());
			stm.setInt(2, p.getPedido_id());
			stm.setString(3, dataFormatada);
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String statusDescricao(int id) {

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;

		String descricao = "";

		try {

			stm = con.prepareStatement("SELECT status_descricao FROM tbl_status WHERE status_id = ?;");
			stm.setInt(1, id);
			rs = stm.executeQuery();

			while (rs.next()) {
				descricao = rs.getString("status_descricao");
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return descricao;
	}

	public List<ModelStatus> carregarStatusHistorico(ModelPedido p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<ModelStatus> historico = new ArrayList<ModelStatus>();

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_status_update WHERE pedido_id = ?;");
			stm.setInt(1, p.getPedido_id());
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelStatus status = new ModelStatus();
				status.setPedido_id(rs.getInt("pedido_id"));
				status.setStatus_id(rs.getInt("status_id"));
				status.setStatus_update_datetime(rs.getDate("status_update_datetime"));

				SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
				String dataFormatada = formato.format(rs.getTimestamp("status_update_datetime"));

				status.setStatus_data_formatada(dataFormatada);

				historico.add(status);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return historico;
	}

}
