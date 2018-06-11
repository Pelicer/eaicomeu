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

	public void excluirPedidosAbertos() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE FROM tbl_pedido WHERE status_id = 1;");
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

			stm.setInt(3, p.getEntrega_id());

			stm.executeUpdate();

			np = selecionarPedido(p.getUsuario_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return np;
	}

	public void atualizarPreco(int pedido_id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = con.prepareStatement(
					"SELECT SUM(produto_valor) FROM tbl_produto AS prod INNER JOIN tbl_itenspedido AS ip ON prod.produto_id = ip.produto_id INNER JOIN tbl_pedido ON ip.pedido_id = tbl_pedido.pedido_id WHERE tbl_pedido.pedido_id = ?;");

			stm.setInt(1, pedido_id);
			rs = stm.executeQuery();

			float novoTotal = 0;

			while (rs.next()) {
				novoTotal = rs.getFloat("SUM(produto_valor)");
			}

			stm = con.prepareStatement("UPDATE tbl_pedido SET pedido_valorTotal = ? WHERE pedido_id = ?;");
			stm.setFloat(1, novoTotal);
			stm.setInt(2, pedido_id);
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				p.setEntrega_id(rs.getInt("entrega_id"));
				p.setPedido_id(rs.getInt("pedido_id"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public ModelPedido selecionarPedidoAberto(int usuario, int restaurante) {

		Connection con = ConnectionFactory.getConnection();
		ModelPedido p = new ModelPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {

			stm = con.prepareStatement(
					"SELECT * FROM tbl_pedido AS p INNER JOIN tbl_itensPedido AS ip ON ip.pedido_id = p.pedido_id INNER JOIN tbl_produto AS prod ON prod.produto_id = ip.produto_id INNER JOIN tbl_restaurante AS r ON r.restaurante_id = prod.restaurante_id WHERE usuario_id ="
							+ usuario + " AND status_id = 1 AND r.restaurante_id = " + restaurante + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				p.setValorTotal(rs.getInt("pedido_valorTotal"));
				p.setStatus_id(rs.getInt("status_id"));
				p.setPedido_id(rs.getInt("pedido_id"));
				p.setEntrega_id(rs.getInt("entrega_id"));
				p.setUsuario_id(rs.getInt("usuario_id"));
				p.setPedido_data(rs.getDate("pedido_data"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public ModelPedido selecionarPedidosAbertos(int usuario) {

		Connection con = ConnectionFactory.getConnection();
		ModelPedido p = new ModelPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {

			stm = con
					.prepareStatement("SELECT * FROM tbl_pedido WHERE usuario_id = " + usuario + " AND status_id = 1;");
			rs = stm.executeQuery();

			while (rs.next()) {
				p.setValorTotal(rs.getInt("pedido_valorTotal"));
				p.setStatus_id(rs.getInt("status_id"));
				p.setPedido_id(rs.getInt("pedido_id"));
				p.setEntrega_id(rs.getInt("entrega_id"));
				p.setUsuario_id(rs.getInt("usuario_id"));
				p.setPedido_data(rs.getDate("pedido_data"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public ModelPedido selecionarUltimaEntrada() {

		Connection con = ConnectionFactory.getConnection();
		ModelPedido p = new ModelPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(
					"SELECT * FROM tbl_pedido WHERE status_id = 1 ORDER BY pedido_id DESC LIMIT 0, 1;");
			rs = stm.executeQuery();

			while (rs.next()) {
				p.setPedido_data(rs.getDate("pedido_data"));
				p.setPedido_id(rs.getInt("pedido_id"));
				p.setStatus_id(1);
				p.setEntrega_id(rs.getInt("entrega_id"));
				p.setUsuario_id(rs.getInt("usuario_id"));
				p.setValorTotal(rs.getInt("pedido_valorTotal"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;

	}

	public boolean verificarPedidoAberto(int usuario, int restaurante) {

		boolean aberto = false;

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {

			stm = con.prepareStatement(
					"SELECT * FROM tbl_pedido AS p INNER JOIN tbl_itensPedido AS ip ON ip.pedido_id = p.pedido_id INNER JOIN tbl_produto AS prod ON prod.produto_id = ip.produto_id INNER JOIN tbl_restaurante AS r ON r.restaurante_id = prod.restaurante_id WHERE usuario_id ="
							+ usuario + " AND status_id = 1 AND r.restaurante_id = " + restaurante + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				aberto = true;
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aberto;
	}

	public boolean verificarOutrosPedidos(int usuario, int restaurante) {
		boolean aberto = false;

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {

			stm = con.prepareStatement(
					"SELECT * FROM tbl_pedido AS p INNER JOIN tbl_itensPedido AS ip ON ip.pedido_id = p.pedido_id INNER JOIN tbl_produto AS prod ON prod.produto_id = ip.produto_id INNER JOIN tbl_restaurante AS r ON r.restaurante_id = prod.restaurante_id WHERE usuario_id ="
							+ usuario + " AND status_id = 1 AND r.restaurante_id != " + restaurante + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				aberto = true;
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aberto;
	}


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
				p.setEntrega_id(rs.getInt("entrega_id"));
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
