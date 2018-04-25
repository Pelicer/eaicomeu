package view.usuario.cadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControllerLogin;
import controller.ControllerUsuario;

@SuppressWarnings("serial")
public class ViewCadastroSwitch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String tipo = "";

	public ViewCadastroSwitch() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ViewCadastroSwitch.class.getResource("/img/logo/logo (64x64).png")));
		setTitle("Antes de prosseguir...");
		setResizable(false);
		setBounds(100, 100, 420, 750);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTextArea txtApresentacao = new JTextArea();
		txtApresentacao.setEditable(false);
		txtApresentacao.setWrapStyleWord(true);
		txtApresentacao.setRows(3);
		txtApresentacao.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtApresentacao.setBackground(new Color(51, 51, 51));
		txtApresentacao.setForeground(Color.WHITE);
		txtApresentacao.setText(
				"Muitos restaurantes querem fazer parte da nossa rede de entregas e ser parceiro da E a\u00ED, comeu? Por isso precisamos saber quem voc\u00EA \u00E9!");
		txtApresentacao.setLineWrap(true);
		txtApresentacao.setBounds(20, 307, 369, 49);
		contentPanel.add(txtApresentacao);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewCadastroSwitch.class.getResource("/img/logo/logo-medium.png")));
		label.setBounds(20, 33, 369, 75);
		contentPanel.add(label);

		JTextArea txtTitulo = new JTextArea();
		txtTitulo.setForeground(Color.WHITE);
		txtTitulo.setBackground(new Color(51, 51, 51));
		txtTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtTitulo.setLineWrap(true);
		txtTitulo.setText("A gente sabe que voc\u00EA est\u00E1 com fome, mas antes de come\u00E7ar a pedir...");
		txtTitulo.setBounds(20, 180, 369, 57);
		contentPanel.add(txtTitulo);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = "usuario";
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarCadastroUsuario(tipo);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(ViewCadastroSwitch.class.getResource("/img/icon/profile (64x64).png")));
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(55, 483, 64, 64);
		contentPanel.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = "entregador";
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarCadastroUsuario(tipo);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(ViewCadastroSwitch.class.getResource("/img/icon/delivery (64x64).png")));
		button_1.setOpaque(true);
		button_1.setForeground(Color.WHITE);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(293, 483, 64, 64);
		contentPanel.add(button_1);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = "restaurante";
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarCadastroUsuario(tipo);
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(ViewCadastroSwitch.class.getResource("/img/icon/restaurant (64x64).png")));
		button_2.setOpaque(true);
		button_2.setForeground(Color.WHITE);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(174, 483, 64, 64);
		contentPanel.add(button_2);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsurio.setBounds(55, 558, 64, 14);
		contentPanel.add(lblUsurio);

		JLabel lblRestaurante = new JLabel("Restaurante");
		lblRestaurante.setForeground(Color.WHITE);
		lblRestaurante.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurante.setBounds(174, 558, 70, 14);
		contentPanel.add(lblRestaurante);

		JLabel lblEntregador = new JLabel("Entregador");
		lblEntregador.setForeground(Color.WHITE);
		lblEntregador.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntregador.setBounds(293, 558, 64, 14);
		contentPanel.add(lblEntregador);
		{
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(new Color(51, 51, 51));
			btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnPanel, BorderLayout.SOUTH);

			{
				JButton cancelButton = new JButton("Voltar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ControllerLogin cl = new ControllerLogin();
						cl.carregarLogin();
						dispose();
					}
				});
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setOpaque(true);
				cancelButton.setContentAreaFilled(false);
				cancelButton.setBorderPainted(true);
				btnPanel.add(cancelButton);
				cancelButton.setActionCommand("Cancel");
				btnPanel.add(cancelButton);
			}
		}
	}
}
