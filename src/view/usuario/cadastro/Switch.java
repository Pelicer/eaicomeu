package view.usuario.cadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.ControllerLogin;
import controller.ControllerUsuario;

@SuppressWarnings("serial")
public class Switch extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public Switch() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Switch.class.getResource("/img/logo/logo (16x16).png")));
		setTitle("Antes de prosseguir...");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("A gente sabe que voc\u00EA est\u00E1 com fome, mas antes de pedir...");
			lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(10, 11, 424, 31);
			contentPanel.add(lblNewLabel);
		}

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.ORANGE);
		separator_1.setBackground(new Color(51, 51, 51));
		separator_1.setBounds(10, 67, 424, 2);
		contentPanel.add(separator_1);

		JTextArea txtApresentacao = new JTextArea();
		txtApresentacao.setRows(2);
		txtApresentacao.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtApresentacao.setBackground(new Color(51, 51, 51));
		txtApresentacao.setForeground(Color.WHITE);
		txtApresentacao.setText(
				"Muitos restaurantes querem fazer parte da nossa rede de entregas e ser parceiro da E a\u00ED, comeu? Por isso precisamos saber quem voc\u00EA \u00E9!");
		txtApresentacao.setLineWrap(true);
		txtApresentacao.setBounds(10, 80, 424, 41);
		contentPanel.add(txtApresentacao);

		JRadioButton rdbtnUsuario = new JRadioButton("Um cliente!");
		rdbtnUsuario.setSelected(true);
		rdbtnUsuario.setForeground(Color.WHITE);
		rdbtnUsuario.setBackground(new Color(51, 51, 51));
		rdbtnUsuario.setBounds(10, 176, 90, 23);
		contentPanel.add(rdbtnUsuario);

		JRadioButton rdbtnRestaurante = new JRadioButton("Um restaurante!");
		rdbtnRestaurante.setForeground(Color.WHITE);
		rdbtnRestaurante.setBackground(new Color(51, 51, 51));
		rdbtnRestaurante.setBounds(102, 176, 120, 23);
		contentPanel.add(rdbtnRestaurante);

		JRadioButton rdbtnEntregador = new JRadioButton("Quero ser entregador aut\u00F4nomo!");
		rdbtnEntregador.setForeground(Color.WHITE);
		rdbtnEntregador.setBackground(new Color(51, 51, 51));
		rdbtnEntregador.setBounds(224, 176, 220, 23);
		contentPanel.add(rdbtnEntregador);

		ButtonGroup tipoUsuario = new ButtonGroup();
		tipoUsuario.add(rdbtnUsuario);
		tipoUsuario.add(rdbtnRestaurante);
		tipoUsuario.add(rdbtnEntregador);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBackground(new Color(51, 51, 51));
		separator.setBounds(10, 140, 424, 2);
		contentPanel.add(separator);
		{
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(new Color(51, 51, 51));
			btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnPanel, BorderLayout.SOUTH);
			{

				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String tipo = "";
						if (rdbtnEntregador.isSelected()) {
							tipo = "entregador";
						}
						if (rdbtnRestaurante.isSelected()) {
							tipo = "restaurante";
						}
						if (rdbtnUsuario.isSelected()) {
							tipo = "usuario";
						}

						ControllerUsuario cu = new ControllerUsuario();
						cu.carregarCadastroUsuario(tipo);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				okButton.setForeground(Color.WHITE);
				okButton.setOpaque(true);
				okButton.setContentAreaFilled(false);
				okButton.setBorderPainted(true);
				btnPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
