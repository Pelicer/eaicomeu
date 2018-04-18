package view.usuario.pedido;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import controller.ControllerUsuario;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.cadastro.ViewCadastroLogin;

@SuppressWarnings("serial")
public class ViewRestaurante extends JFrame {

	private JPanel contentPane;
	ModelRestaurante restaurante = new ModelRestaurante();
	ModelUsuario usuario = new ModelUsuario();

	public ViewRestaurante(ModelRestaurante r, ModelUsuario u) {
		restaurante = r;
		usuario = u;

		setTitle("Restaurante");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ViewRestaurante.class.getResource("/img/logo/logo (16x16).png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		panel.add(btnHome);

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
		panel.add(btnPerfil);

		JButton btnPedidos = new JButton("");
		btnPedidos.setIcon(new ImageIcon(ViewRestaurante.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setOpaque(true);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setBounds(221, 18, 64, 64);
		panel.add(btnPedidos);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.setIcon(new ImageIcon(ViewRestaurante.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setOpaque(true);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBounds(316, 18, 64, 64);
		panel.add(btnCarrinho);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(restaurante.getRestaurante_thumbnail())));
		label.setBounds(21, 127, 128, 128);
		contentPane.add(label);

		JLabel lblRestaunte = new JLabel(restaurante.getRestaurante_razaosocial());
		lblRestaunte.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblRestaunte.setBounds(159, 145, 232, 25);
		contentPane.add(lblRestaunte);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBackground(new Color(51, 51, 51));
		separator.setBounds(159, 181, 232, 2);
		contentPane.add(separator);

		JLabel lblEndereco = new JLabel(
				r.getRestaurante_bairro() + " - " + r.getRestaurante_endereco() + ", " + r.getRestaurante_logradouro());
		lblEndereco.setBounds(159, 194, 232, 14);
		contentPane.add(lblEndereco);
	}
}
