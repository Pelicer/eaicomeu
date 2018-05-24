package view.usuario.pedido;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import controller.ControllerPedido;
import controller.ControllerProduto;
import controller.ControllerTipo;
import controller.ControllerUsuario;
import model.ModelPedido;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelTipo;
import model.ModelUsuario;

@SuppressWarnings("serial")
public class ViewRestaurante extends JFrame {

	private JPanel contentPane;
	ModelRestaurante restaurante = new ModelRestaurante();
	ModelUsuario usuario = new ModelUsuario();

	ControllerProduto cp = new ControllerProduto();
	ControllerTipo ct = new ControllerTipo();
	List<ModelProduto> produtos = new ArrayList<ModelProduto>();

	public ViewRestaurante(ModelRestaurante r, ModelUsuario u) {
		setResizable(false);
		restaurante = r;
		usuario = u;

		setTitle(restaurante.getRestaurante_razaosocial());
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ViewRestaurante.class.getResource("/img/logo/logo (64x64).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel menu = new JPanel();
		menu.setLayout(null);
		menu.setBackground(new Color(51, 51, 51));
		menu.setBounds(0, 0, 414, 100);
		contentPane.add(menu);

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewRestaurante.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setOpaque(true);
		btnHome.setForeground(Color.WHITE);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(31, 18, 64, 64);
		menu.add(btnHome);

		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPerfil(usuario);
				dispose();
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewRestaurante.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(126, 18, 64, 64);
		menu.add(btnPerfil);

		JButton btnPedidos = new JButton("");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPedidos(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPedidos.setIcon(new ImageIcon(ViewRestaurante.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setOpaque(true);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setBounds(221, 18, 64, 64);
		menu.add(btnPedidos);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				ControllerPedido cp = new ControllerPedido();
				ModelPedido p = new ModelPedido();
				p = cp.selecionarPedidoAberto(usuario.getUsuario_id());
				cu.carregarCarrinho(usuario, p);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnCarrinho.setIcon(new ImageIcon(ViewRestaurante.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setOpaque(true);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBounds(316, 18, 64, 64);
		menu.add(btnCarrinho);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 99, 414, 118);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("");
		label.setBackground(Color.DARK_GRAY);
		label.setBounds(21, 20, 78, 78);
		panel_1.add(label);
		label.setIcon(new ImageIcon(ViewRestaurante.class.getResource(restaurante.getRestaurante_thumbnail())));

		JLabel lblRestaunte = new JLabel(restaurante.getRestaurante_razaosocial());
		lblRestaunte.setForeground(Color.BLACK);
		lblRestaunte.setBounds(124, 11, 232, 25);
		panel_1.add(lblRestaunte);
		lblRestaunte.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		JSeparator separator = new JSeparator();
		separator.setBounds(124, 33, 232, 2);
		panel_1.add(separator);
		separator.setForeground(Color.ORANGE);
		separator.setBackground(new Color(51, 51, 51));

		JTextArea txtEndereco = new JTextArea();
		txtEndereco.setEditable(false);
		txtEndereco.setBackground(new Color(255, 255, 255));
		txtEndereco.setBounds(124, 47, 232, 54);
		panel_1.add(txtEndereco);
		txtEndereco.setLineWrap(true);
		txtEndereco.setRows(2);
		txtEndereco.setWrapStyleWord(true);
		txtEndereco.setText(
				r.getRestaurante_bairro() + " - " + r.getRestaurante_endereco() + ", " + r.getRestaurante_logradouro());

		produtos = cp.carregarProdutos(r.getRestaurante_id());
		int yproduto = 40;
		int ytipo = 11;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 217, 414, 505);
		scrollPane.setPreferredSize(new Dimension(414, 414));

		JPanel viewport = new JPanel();
		viewport.setLayout(null);
		viewport.setBounds(0, 0, 414, 505);

		ModelTipo t = new ModelTipo();

		if (!produtos.isEmpty()) {

			List<ModelTipo> tipos = new ArrayList<ModelTipo>();
			tipos = ct.carregarTipos(r.getRestaurante_id());

			for (int i = 0; i < tipos.size(); i++) {
				t = tipos.get(i);
				JLabel tipo = new JLabel();
				tipo.setName("tipo" + i);
				tipo.setText(t.getTipo_descricao());
				tipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
				tipo.setBounds(10, ytipo, 375, 22);
				viewport.add(tipo);

				JSeparator separadortipo = new JSeparator();
				separadortipo.setForeground(Color.BLACK);
				separadortipo.setBounds(10, ytipo + 22, 375, 2);
				separadortipo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
				viewport.add(separadortipo);

				for (int x = 0; x < produtos.size(); x++) {
					ModelProduto p = produtos.get(x);
					if (p.getTipo_id() == t.getTipo_id()) {

						JPanel produto = new JPanel();
						produto.setName("produto_" + i);
						produto.setBounds(10, yproduto, 375, 93);
						produto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.BLACK));
						produto.setBackground(Color.WHITE);
						produto.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseReleased(MouseEvent e) {
								ControllerProduto cp = new ControllerProduto();
								cp.carregarProduto(p, restaurante, usuario);
								dispose();
							}
						});
						produto.setLayout(null);

						JLabel thumbnail = new JLabel();
						thumbnail.setName("produto" + i + "_thumbnail");
						thumbnail.setIcon(new ImageIcon(ViewRestaurante.class.getResource(p.getProduto_thumbnail())));
						thumbnail.setBounds(10, 11, 78, 71);
						produto.add(thumbnail);

						JLabel titulo = new JLabel();
						titulo.setName("produto" + i + "_nome");
						titulo.setText(p.getProduto_nome());
						titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
						titulo.setBounds(98, 11, 250, 20);
						produto.add(titulo);

						JTextArea descricao = new JTextArea();
						descricao.setName("produto" + i + "_descricao");
						descricao.setText(p.getProduto_descricao());
						descricao.setLineWrap(true);
						descricao.setEditable(false);
						descricao.setRows(2);
						descricao.setBounds(98, 30, 250, 30);
						produto.add(descricao);

						String valor = String.format("%.2f", p.getProduto_valor());

						JLabel preco = new JLabel();
						preco.setName("produto" + i + "_valor");
						preco.setText("R$" + valor);
						preco.setBounds(98, 57, 250, 30);
						produto.add(preco);

						viewport.add(produto);
						yproduto += 111;
						ytipo += 111;
					}
				}
				yproduto += 20;
				ytipo += 20;

			}

		} else {
			JLabel vazio = new JLabel();
			vazio.setName("vazio");
			vazio.setBounds(42, 10, 375, 100);
			vazio.setText("Este restaurante ainda não possui produtos cadastrados.");
			viewport.add(vazio);
		}

		viewport.setPreferredSize(new Dimension(414, yproduto));
		scrollPane.setViewportView(viewport);
		contentPane.add(scrollPane);

	}

}
