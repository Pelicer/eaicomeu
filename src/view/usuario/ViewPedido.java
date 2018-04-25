package view.usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerUsuario;
import model.ModelUsuario;

public class ViewPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	ModelUsuario usuario = new ModelUsuario();

	public ViewPedido(ModelUsuario u) {
		usuario = u;

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

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		button.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/home (64x64).png")));
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(31, 18, 64, 64);
		panel.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/profile (64x64).png")));
		button_1.setOpaque(true);
		button_1.setForeground(Color.WHITE);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(126, 18, 64, 64);
		panel.add(button_1);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPedidos(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		button_2.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/list (64x64).png")));
		button_2.setOpaque(true);
		button_2.setForeground(Color.WHITE);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(221, 18, 64, 64);
		panel.add(button_2);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarCarrinho(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		button_3.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/cart (64x64).png")));
		button_3.setOpaque(true);
		button_3.setForeground(Color.WHITE);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(316, 18, 64, 64);
		panel.add(button_3);
	}

}
