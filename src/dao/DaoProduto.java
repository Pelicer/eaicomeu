package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelProduto;

public class DaoProduto {

	public ModelProduto selecionarProduto(int id) {
		Connection con = ConnectionFactory.getConnection();
		ModelProduto p = new ModelProduto();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_produto WHERE produto_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				p.setProduto_id(rs.getInt("produto_id"));
				p.setProduto_descricao(rs.getString("produto_descricao"));
				p.setProduto_nome(rs.getString("produto_nome"));
				p.setProduto_thumbnail(rs.getString("produto_thumbnail"));
				p.setProduto_valor(rs.getFloat("produto_valor"));
				System.out.println(rs.getInt("restaurante_id"));
				p.setRestaurante_id(rs.getInt("restaurante_id"));
				p.setTipo_id(rs.getInt("tipo_id"));
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public List<ModelProduto> carregarProdutos(int id) {

		Connection con = ConnectionFactory.getConnection();
		List<ModelProduto> lista = new ArrayList<ModelProduto>();
		ResultSet rs = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement("SELECT * FROM tbl_produto WHERE restaurante_id = " + id + ";");
			rs = stm.executeQuery();

			while (rs.next()) {
				ModelProduto p = new ModelProduto();
				p.setProduto_id(rs.getInt("produto_id"));
				p.setProduto_descricao(rs.getString("produto_descricao"));
				p.setProduto_nome(rs.getString("produto_nome"));
				p.setProduto_thumbnail(rs.getString("produto_thumbnail"));
				p.setProduto_valor(rs.getFloat("produto_valor"));
				p.setRestaurante_id(rs.getInt("restaurante_id"));
				p.setTipo_id(rs.getInt("tipo_id"));
				lista.add(p);
			}

			ConnectionFactory.closeConnection(con, stm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
