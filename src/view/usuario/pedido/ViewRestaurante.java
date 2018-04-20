package view.usuario.pedido;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.ControllerUsuario;
import model.ModelRestaurante;
import model.ModelUsuario;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;

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
				Toolkit.getDefaultToolkit().getImage(ViewRestaurante.class.getResource("/img/logo/logo (64x64).png")));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 217, 414, 505);
		contentPane.add(scrollPane);
		BufferedImage img = null;
		try {
			img = ImageIO.read(ViewRestaurante.class.getResource("/img/pattern.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
