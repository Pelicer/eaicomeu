package view.usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerItensPedido;
import controller.ControllerPedido;
import controller.ControllerProduto;
import controller.ControllerRestaurante;
import controller.ControllerUsuario;
import model.ModelPedido;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelUsuario;

public class ViewPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	ControllerPedido cped = new ControllerPedido();
	ControllerProduto cprod = new ControllerProduto();
	ControllerItensPedido cip = new ControllerItensPedido();
	ControllerUsuario cuser = new ControllerUsuario();
	ControllerRestaurante cr = new ControllerRestaurante();

	ModelPedido uniPedido = new ModelPedido();
	ModelUsuario usuario = new ModelUsuario();
	ModelProduto produto = new ModelProduto();
	ModelRestaurante restaurante = new ModelRestaurante();

	List<ModelPedido> itens_encapsulado = new ArrayList<ModelPedido>();

	public ViewPedido(ModelUsuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewPedido.class.getResource("/img/icon/list (64x64).png")));

		usuario = u;

		List<ModelPedido> itens = new ArrayList<ModelPedido>();
		itens = cped.carregarTodosPedidos(u.getUsuario_id());
		itens_encapsulado = itens;

		setTitle("Meus Pedidos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 414, 100);
		contentPane.add(panel);

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setOpaque(true);
		btnHome.setForeground(Color.WHITE);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(31, 18, 64, 64);
		panel.add(btnHome);

		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(126, 18, 64, 64);
		panel.add(btnPerfil);

		JButton btnPedidos = new JButton("");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPedidos(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPedidos.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setOpaque(true);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setBounds(221, 18, 64, 64);
		panel.add(btnPedidos);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				ControllerPedido cp = new ControllerPedido();
				ModelPedido p = new ModelPedido();
				p = cp.selecionarPedidosAbertos(usuario.getUsuario_id());
				cu.carregarCarrinho(usuario, p);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnCarrinho.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setOpaque(true);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBounds(316, 18, 64, 64);
		panel.add(btnCarrinho);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(414, 414));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 100, 414, 621);
		contentPane.add(scrollPane);

		JPanel viewport = new JPanel();
		viewport.setLayout(null);
		viewport.setPreferredSize(new Dimension(414, 52));
		scrollPane.setViewportView(viewport);

		if (itens.isEmpty()) {
			JLabel lblTitulo = new JLabel();
			lblTitulo.setText("Não há pedidos registrados");
			lblTitulo.setName("titulo");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTitulo.setBounds(10, 11, 375, 22);
			viewport.add(lblTitulo);
		} else {
			JLabel lblTitulo = new JLabel();
			lblTitulo.setText("Meus pedidos");
			lblTitulo.setName("titulo");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTitulo.setBounds(10, 11, 375, 22);
			viewport.add(lblTitulo);
		}

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator.setBounds(10, 37, 375, 2);
		viewport.add(separator);

		int yproduto = 60;

		for (int x = 0; x < itens.size(); x++) {

			ModelPedido i = itens.get(x);

			JPanel item = new JPanel();
			item.setName("pedido_" + i);
			item.setBounds(10, yproduto, 375, 93);
			item.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.BLACK));
			item.setBackground(Color.WHITE);
			item.setLayout(null);

			restaurante = cr.selecionarRestauranteID(cped.selecionarRestaurante(i));

			JLabel thumbnail = new JLabel();
			thumbnail.setName("pedido_" + i + "_thumbnail");
			thumbnail.setIcon(new ImageIcon(ViewCarrinho.class.getResource(restaurante.getRestaurante_thumbnail())));
			thumbnail.setBounds(10, 11, 78, 71);
			item.add(thumbnail);

			JLabel titulo = new JLabel();
			titulo.setName("pedido_" + i + "_nome");
			titulo.setText("Pedido em " + restaurante.getRestaurante_razaosocial());
			titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			titulo.setBounds(98, 11, 250, 20);
			item.add(titulo);

			String statusDescricao = cped.statusDescricao(i.getStatus_id());

			JTextArea descricao = new JTextArea();
			descricao.setName("pedido_" + i + "_descricao");
			descricao.setText(i.getPedido_data().toString() + " - " + statusDescricao);
			descricao.setLineWrap(true);
			descricao.setEditable(false);
			descricao.setRows(2);
			descricao.setBounds(98, 30, 250, 30);
			item.add(descricao);

			String valor = String.format("%.2f", i.getValorTotal());

			JLabel preco = new JLabel();
			preco.setName("pedido_" + i + "_valor");
			preco.setText("R$" + valor);
			preco.setBounds(98, 57, 250, 30);
			item.add(preco);

			viewport.add(item);
			yproduto += 111;

			viewport.setPreferredSize(new Dimension(414, yproduto));
			scrollPane.setViewportView(viewport);
			contentPane.add(scrollPane);
		}
	}

}
