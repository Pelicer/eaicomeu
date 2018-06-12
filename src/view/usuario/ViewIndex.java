package view.usuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControllerPedido;
import controller.ControllerRestaurante;
import controller.ControllerUsuario;
import model.ModelPedido;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.cadastro.ViewCadastroLogin;

public class ViewIndex extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ModelUsuario usuario = new ModelUsuario();

	ControllerRestaurante cr = new ControllerRestaurante();
	List<ModelRestaurante> r = cr.carregarRestaurantesAbertos();

	public ViewIndex(ModelUsuario u) {

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewIndex.class.getResource("/img/logo/logo (64x64).png")));
		setTitle("E a\u00ED, Comeu?");
		usuario = u;

		setBounds(100, 100, 420, 750);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("RESTAURANTES ABERTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 21));
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setBounds(37, 133, 340, 30);
		contentPane.add(lblTitulo);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(51, 51, 51));
		separator.setForeground(Color.BLACK);
		separator.setBounds(37, 174, 340, 2);
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 429, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnHome = new JButton("");
		btnHome.setBounds(31, 18, 64, 64);
		panel.add(btnHome);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setForeground(Color.WHITE);
		btnHome.setOpaque(true);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);

		JButton btnPerfil = new JButton("");
		btnPerfil.setBounds(126, 18, 64, 64);
		panel.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPerfil(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setOpaque(true);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);

		JButton btnPedidos = new JButton("");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPedidos(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPedidos.setBounds(221, 18, 64, 64);
		panel.add(btnPedidos);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setOpaque(true);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);

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
		btnCarrinho.setBounds(316, 18, 64, 64);
		panel.add(btnCarrinho);
		btnCarrinho.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setOpaque(true);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);

		int yproduto = 10;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 217, 414, 505);
		scrollPane.setPreferredSize(new Dimension(414, 414));

		JPanel viewport = new JPanel();
		viewport.setLayout(null);
		viewport.setBounds(0, 0, 414, 505);

		if (r.size() == 0) {

			JPanel painelNotificacao = new JPanel();
			painelNotificacao.setBackground(Color.WHITE);
			painelNotificacao.setBounds(37, 169, 340, 100);
			contentPane.add(painelNotificacao);
			painelNotificacao.setLayout(null);

			JLabel semRestaurantes = new JLabel("Não foram encontrados restaurantes...");
			semRestaurantes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			semRestaurantes.setHorizontalAlignment(SwingConstants.CENTER);
			semRestaurantes.setBackground(Color.BLACK);
			semRestaurantes.setBounds(10, 11, 320, 78);
			painelNotificacao.add(semRestaurantes);
		}

		for (int i = 0; i < r.size(); i++) {

			ModelRestaurante restaurante = r.get(i);

			JPanel painelRestaurante = new JPanel();
			painelRestaurante.setName("restaurante_" + i);
			painelRestaurante.setBounds(10, yproduto, 375, 120);
			painelRestaurante.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					ControllerUsuario cu = new ControllerUsuario();
					cu.carregarRestaurante(restaurante.getRestaurante_razaosocial(), usuario.getUsuario_id());
					dispose();
				}
			});
			painelRestaurante.setLayout(null);

			JLabel lblThumbnail = new JLabel("");
			lblThumbnail.setName("thumbnail_" + i);
			lblThumbnail.setIcon(
					new ImageIcon(ViewCadastroLogin.class.getResource(restaurante.getRestaurante_thumbnail())));
			lblThumbnail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblThumbnail.setHorizontalAlignment(SwingConstants.CENTER);
			lblThumbnail.setBackground(Color.BLACK);
			lblThumbnail.setBounds(10, 11, 78, 78);
			painelRestaurante.add(lblThumbnail);

			JLabel lblRazaoSocial = new JLabel(restaurante.getRestaurante_razaosocial());
			lblRazaoSocial.setName("restaurante_" + i);
			lblRazaoSocial.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
			lblRazaoSocial.setBounds(98, 11, 375, 39);
			painelRestaurante.add(lblRazaoSocial);

			JSeparator separador = new JSeparator();
			separador.setName("separador_" + i);
			separador.setForeground(Color.ORANGE);
			separador.setBackground(new Color(51, 51, 51));
			separador.setBounds(98, 50, 375, 2);
			painelRestaurante.add(separador);

			JLabel lblEndereco = new JLabel(restaurante.getRestaurante_endereco() + " - "
					+ restaurante.getRestaurante_logradouro() + ", " + restaurante.getRestaurante_cidade());
			lblEndereco.setName("restaurante_" + i);
			lblEndereco.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblEndereco.setBounds(98, 61, 232, 28);
			painelRestaurante.add(lblEndereco);
			viewport.add(painelRestaurante);

			yproduto += 100;

		}

		viewport.setPreferredSize(new Dimension(414, yproduto));
		scrollPane.setViewportView(viewport);
		contentPane.add(scrollPane);
	}
}
