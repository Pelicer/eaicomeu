package view.usuario.pedido;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerPedido;
import controller.ControllerUsuario;
import model.ModelPedido;
import model.ModelUsuario;
import view.usuario.ViewIndex;

public class ViewEntrega extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	ModelUsuario usuario = new ModelUsuario();
	ModelPedido pedido = new ModelPedido();

	public ViewEntrega(ModelUsuario u, ModelPedido p) {
		usuario = u;
		pedido = p;

		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ViewEntrega.class.getResource("/img/icon/delivery (64x64).png")));
		setTitle("Entrega");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Menu = new JPanel();
		Menu.setLayout(null);
		Menu.setBackground(new Color(51, 51, 51));
		Menu.setBounds(0, 0, 414, 100);
		contentPane.add(Menu);

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setOpaque(true);
		btnHome.setForeground(Color.WHITE);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(31, 18, 64, 64);
		Menu.add(btnHome);

		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPerfil(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(126, 18, 64, 64);
		Menu.add(btnPerfil);

		JButton btnPedidos = new JButton("");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPedidos(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPedidos.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setOpaque(true);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setBounds(221, 18, 64, 64);
		Menu.add(btnPedidos);

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
		btnCarrinho.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setOpaque(true);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBounds(316, 18, 64, 64);
		Menu.add(btnCarrinho);

		JPanel viewport = new JPanel();
		viewport.setBackground(Color.WHITE);
		viewport.setBounds(0, 302, 414, 420);
		contentPane.add(viewport);
		viewport.setLayout(null);

		JPanel formasEntrega = new JPanel();
		formasEntrega.setBackground(Color.WHITE);
		formasEntrega.setBounds(0, 99, 414, 204);
		contentPane.add(formasEntrega);
		formasEntrega.setLayout(null);

		JLabel lblGostariaDeAdquirir = new JLabel();
		lblGostariaDeAdquirir.setText("Gostaria de adquirir seu pedido via...");
		lblGostariaDeAdquirir.setName("ingredientes");
		lblGostariaDeAdquirir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGostariaDeAdquirir.setBounds(56, 25, 301, 22);
		formasEntrega.add(lblGostariaDeAdquirir);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator.setBounds(56, 50, 301, 2);
		formasEntrega.add(separator);

		JButton btnRetirada = new JButton("");
		btnRetirada.setIcon(new ImageIcon(ViewEntrega.class.getResource("/img/delivery/withdrawal (64x64).png")));
		btnRetirada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				viewport.removeAll();
				viewport.repaint();

				JLabel lblRetiradaAviso = new JLabel("");
				lblRetiradaAviso
						.setIcon(new ImageIcon(ViewEntrega.class.getResource("/img/delivery/time (64x64).png")));
				lblRetiradaAviso.setBounds(41, 42, 64, 64);
				viewport.add(lblRetiradaAviso);

				JTextArea txtAviso = new JTextArea();
				txtAviso.setEditable(false);
				txtAviso.setLineWrap(true);
				txtAviso.setWrapStyleWord(true);
				txtAviso.setFont(new Font("Monospaced", Font.PLAIN, 12));
				txtAviso.setText(
						"Para o servi\u00E7o de retirada, n\u00E3o esque\u00E7a de aguardar pelo menos 30min antes de ir buscar seu pedido!");
				txtAviso.setBounds(115, 42, 263, 64);
				viewport.add(txtAviso);
			}
		});
		btnRetirada.setOpaque(true);
		btnRetirada.setForeground(Color.WHITE);
		btnRetirada.setContentAreaFilled(false);
		btnRetirada.setBorderPainted(false);
		btnRetirada.setBackground(Color.LIGHT_GRAY);
		btnRetirada.setBounds(55, 71, 64, 64);
		formasEntrega.add(btnRetirada);

		JLabel lblRetirada = new JLabel("Retirada");
		lblRetirada.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetirada.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblRetirada.setBounds(55, 146, 64, 14);
		formasEntrega.add(lblRetirada);

		JButton btnEntrega = new JButton("");
		btnEntrega.setIcon(new ImageIcon(ViewEntrega.class.getResource("/img/delivery/delivery (64x64).png")));
		btnEntrega.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				viewport.removeAll();
				viewport.repaint();

						+ usuario.getUsuario_cidade() + " - " + usuario.getUsuario_uf());

						.setIcon(new ImageIcon(ViewEntrega.class.getResource("/img/delivery/edit (32x32).png")));

				JLabel lblEsteEndereco = new JLabel();
				lblEsteEndereco.setHorizontalAlignment(SwingConstants.CENTER);
				lblEsteEndereco.setText("Este \u00E9 o endere\u00E7o de entrega?");
				lblEsteEndereco.setName("ingredientes");
				lblEsteEndereco.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblEsteEndereco.setBounds(43, 25, 327, 22);
				viewport.add(lblEsteEndereco);
			}
		});
		btnEntrega.setOpaque(true);
		btnEntrega.setForeground(Color.WHITE);
		btnEntrega.setContentAreaFilled(false);
		btnEntrega.setBorderPainted(false);
		btnEntrega.setBackground(Color.LIGHT_GRAY);
		btnEntrega.setBounds(174, 71, 64, 64);
		formasEntrega.add(btnEntrega);

		JLabel lblEntrega = new JLabel("Entrega");
		lblEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrega.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblEntrega.setBounds(174, 146, 64, 14);
		formasEntrega.add(lblEntrega);

		JButton btnMotoboy = new JButton("");
		btnMotoboy.setIcon(new ImageIcon(ViewEntrega.class.getResource("/img/delivery/motoboy (64x64).png")));
		btnMotoboy.setEnabled(false);
		btnMotoboy.setOpaque(true);
		btnMotoboy.setForeground(Color.WHITE);
		btnMotoboy.setContentAreaFilled(false);
		btnMotoboy.setBorderPainted(false);
		btnMotoboy.setBackground(Color.LIGHT_GRAY);
		btnMotoboy.setBounds(293, 71, 64, 64);
		formasEntrega.add(btnMotoboy);

		JLabel lblMotoboy = new JLabel("Motoboy");
		lblMotoboy.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotoboy.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblMotoboy.setBounds(293, 146, 64, 14);
		formasEntrega.add(lblMotoboy);

	}
}
