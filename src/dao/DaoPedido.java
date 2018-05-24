package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import model.ModelPedido;

public class DaoPedido {

	public void cadastrarPedido(ModelPedido p) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_pedido (pedido_data, pedido_valorTotal, usuario_id, status_id) VALUES (?, ?, ?, ?);");
			stm.setObject(1, p.getPedido_data().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate());
			stm.setFloat(2, p.getValorTotal());
			stm.setInt(3, p.getUsuario_id());
			stm.setInt(4, 1);

			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ModelPedido atualizarPedido(ModelPedido p) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ModelPedido np = new ModelPedido();

		try {
			stm = con.prepareStatement(
					"UPDATE tbl_pedido SET pedido_data = ?, pedido_valorTotal = ?, status_id = ? WHERE pedido_id = ?");

			stm.setObject(1, p.getPedido_data().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate());
			stm.setFloat(2, p.getValorTotal());
			stm.setInt(3, p.getStatus_id());

			stm.executeUpdate();

			np = selecionarPedido(p.getUsuario_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return np;
	}

	public ModelPedido selecionarPedido(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelPedido p = new ModelPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_pedido WHERE usuario_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				p.setPedido_data(rs.getDate("pedido_data"));
				p.setValorTotal(rs.getInt("pedido_valorTotal"));
				p.setStatus_id(rs.getInt("status_id"));
				p.setPedido_id(rs.getInt("pedido_id"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public ModelPedido selecionarPedidoAberto(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelPedido p = new ModelPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {

			stm = con.prepareStatement("SELECT * FROM tbl_pedido WHERE usuario_id = " + id + " AND status_id = 1;");
			rs = stm.executeQuery();

			while (rs.next()) {
				p.setValorTotal(rs.getInt("pedido_valorTotal"));
				p.setStatus_id(rs.getInt("status_id"));
				p.setPedido_id(rs.getInt("pedido_id"));
				p.setUsuario_id(rs.getInt("usuario_id"));
				p.setPedido_data(rs.getDate("pedido_data"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public List<ModelPedido> carregarLista(int id) {

		List<ModelPedido> lstped = new ArrayList<ModelPedido>();

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_pedido WHERE usuario_id = " + id + " AND status_id = 1;");
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelPedido p = new ModelPedido();
				p.setPedido_data(rs.getDate("pedido_data"));
				p.setValorTotal(rs.getInt("pedido_valorTotal"));
				p.setStatus_id(rs.getInt("status_id"));
				p.setPedido_id(rs.getInt("pedido_id"));
				lstped.add(p);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lstped;
	}

	public void deletarPedido(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE from tbl_pedido WHERE pedido_id = ?");
			stm.setInt(1, id);
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
