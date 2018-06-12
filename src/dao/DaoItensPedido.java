package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ControllerPedido;
import model.ModelItensPedido;
import model.ModelPedido;
import model.ModelProduto;

public class DaoItensPedido {

	public void cadastrarItensPedido(ModelPedido pe, ModelProduto pr, String[] adicionais,String observacao) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		int i;
		
		String add = "";
		for (i = 0; i < adicionais.length; i++) {
			if(!adicionais[i].equals("") && !adicionais[i].equals(null)) {
				add += adicionais[i] + "/";
			}
		}

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_itensPedido (pedido_id, produto_id, itensPedido_adicionais, itensPedido_observacao) VALUES ( ?,  ?,  ?, ?);");
			stm.setInt(1, pe.getPedido_id());
			stm.setInt(2, pr.getProduto_id());
			stm.setString(3, add);
			stm.setString(4, observacao);

			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void cadastrarItensPedidoNull(ModelProduto pr, String[] observacao) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		String obs = "";
		for (int i = 0; i < observacao.length; i++) {
			if(!observacao[i].equals("") && !observacao[i].equals(null)){
				obs += observacao[i] + "/";
			}
		}

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_itensPedido (pedido_id, produto_id, itensPedido_adicionais, itensPedido_observacao) VALUES ( null,  ?,  '', ?);");
			stm.setInt(1, pr.getProduto_id());
			stm.setString(2, obs);

			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public List<ModelItensPedido> carregarCarrinho(int id) {

		List<ModelItensPedido> itens = new ArrayList<ModelItensPedido>();

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_itensPedido WHERE pedido_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelItensPedido i = new ModelItensPedido();
				i.setPedido_id(rs.getInt("pedido_id"));
				i.setProduto_id(rs.getInt("produto_id"));
				i.setItensPedido_adicionais(rs.getString("itensPedido_adicionais"));
				i.setItensPedido_observacao(rs.getString("itensPedido_observacao"));
				i.setItensPedido_id(rs.getInt("itensPedido_id"));
				itens.add(i);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itens;
	}

	public void limparCarrinho(int pedido_id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE FROM tbl_itensPedido;");
			stm.executeUpdate();

			ControllerPedido cp = new ControllerPedido();
			cp.deletarPedido(pedido_id);

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ModelItensPedido selecionarItensPedido(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelItensPedido ip = new ModelItensPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_itensPedido WHERE itensPedido_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				ip.setItensPedido_adicionais(rs.getString("itensPedido_adicionais"));
				ip.setItensPedido_observacao(rs.getString("itensPedido_observacao"));
				ip.setItensPedido_id(rs.getInt("itensPedido_id"));
				ip.setPedido_id(rs.getInt("pedido_id"));
				ip.setProduto_id(rs.getInt("produto_id"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ip;

	}

	public ModelItensPedido selecionarUltimaEntrada() {

		Connection con = ConnectionFactory.getConnection();
		ModelItensPedido ip = new ModelItensPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_itensPedido ORDER BY itensPedido_id DESC LIMIT 0, 1;");
			rs = stm.executeQuery();

			while (rs.next()) {
				ip.setItensPedido_id(rs.getInt("itensPedido_id"));
				ip.setItensPedido_adicionais(rs.getString("itensPedido_adicionais"));
				ip.setItensPedido_observacao(rs.getString("itensPedido_observacao"));
				ip.setPedido_id(rs.getInt("pedido_id"));
				ip.setProduto_id(rs.getInt("produto_id"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ip;

	}

	public void atualizarItensPedido(int pedidoID, String[] adicionais, int ID) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		String add = "";
		for (int i = 0; i < adicionais.length; i++) {
			if(!adicionais[i].equals("") && !adicionais[i].equals(null)) {
				add += adicionais[i] + "/";
			}
		}

		try {
			stm = con.prepareStatement(
					"UPDATE tbl_itensPedido SET itensPedido_adicionais = ?, pedido_id = ? WHERE itensPedido_id = " + ID
							+ ";");
			stm.setString(1, add);
			stm.setInt(2, pedidoID);
			stm.executeUpdate();

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirItem(ModelItensPedido ip) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("DELETE FROM tbl_itensPedido WHERE itensPedido_id = ?;");
			stm.setInt(1, ip.getItensPedido_id());
			stm.executeUpdate();

			ControllerPedido cp = new ControllerPedido();
			cp.atualizarPreco(ip.getPedido_id());

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ModelItensPedido> selecionarItemPorPedido(int id) {

		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement stm = null;

		List<ModelItensPedido> itens = new ArrayList<ModelItensPedido>();

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_itensPedido WHERE pedido_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelItensPedido ip = new ModelItensPedido();
				ip.setItensPedido_adicionais(rs.getString("itensPedido_adicionais"));
				ip.setItensPedido_observacao(rs.getString("itensPedido_observacao"));
				ip.setItensPedido_id(rs.getInt("itensPedido_id"));
				ip.setPedido_id(rs.getInt("pedido_id"));
				ip.setProduto_id(rs.getInt("produto_id"));
				itens.add(ip);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itens;

	}
}
