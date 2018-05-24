package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelItensPedido;
import model.ModelPedido;
import model.ModelProduto;

public class DaoItensPedido {

	public void cadastrarItensPedido(ModelPedido pe, ModelProduto pr, String[] adicionais, String[] observacao) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;

		String add = "";
		for (int i = 0; i < adicionais.length; i++) {
			add += adicionais[i] + "/";
		}

		String obs = "";
		for (int i = 0; i < observacao.length; i++) {
			obs += observacao[i] + "/";
		}

		try {
			stm = con.prepareStatement(
					"INSERT INTO tbl_itensPedido (pedido_id, produto_id, itensPedido_adicionais, itensPedido_observacao) VALUES ( ?,  ?,  ?, ?);");
			stm.setInt(1, pe.getPedido_id());
			stm.setInt(2, pr.getProduto_id());
			stm.setString(3, add);
			stm.setString(4, obs);

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
				itens.add(i);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itens;
	}

	public ModelItensPedido selecionarItensPedido(int id) {

		Connection con = ConnectionFactory.getConnection();
		ModelItensPedido ip = new ModelItensPedido();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_itensPedido WHERE pedido_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
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
}
