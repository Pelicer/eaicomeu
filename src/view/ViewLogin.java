package view;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControllerLogin;
import controller.ControllerRestaurante;
import controller.ControllerUsuario;
import model.ModelLogin;

public class ViewLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswSenha;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblEsqueciMinhaSenha;
	private JLabel lblCadastrese;

	public ViewLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewLogin.class.getResource("/img/logo/logo (16x16).png")));
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel imgLogo = new JLabel("");
		imgLogo.setIcon(new ImageIcon(ViewLogin.class.getResource("/img/logo/logo-medium.png")));
		imgLogo.setBounds(10, 95, 379, 75);
		contentPane.add(imgLogo);

		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtUsuario.setBounds(65, 289, 280, 34);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		pswSenha = new JPasswordField();
		pswSenha.setForeground(Color.DARK_GRAY);
		pswSenha.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pswSenha.setBounds(65, 354, 280, 34);
		contentPane.add(pswSenha);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelLogin l = new ModelLogin();
				ControllerLogin cl = new ControllerLogin();

				String nome = txtUsuario.getText();
				String senha = new String(pswSenha.getPassword());

				l.setLogin_nome(nome);
				l.setLogin_senha(senha);

				if (l.getLogin_nome() != "" || l.getLogin_senha() != "") {

					boolean logged = cl.logar(l);

					// Login de usuário.
					if (logged) {

						ModelLogin ver = new ModelLogin();
						ver = cl.selecionarLoginCRED(l);

						int usuarioID = ver.getUsuario_id();
						int restauranteID = ver.getRestaurante_id();

						if (ver.getUsuario_id() != 0) {

							// Mainpage do usuário
							ControllerUsuario cu = new ControllerUsuario();
							cu.carregarIndex(usuarioID);
							dispose();

						} else {
							// Mainpage do restaurante
							ControllerRestaurante cr = new ControllerRestaurante();
							cr.carregarIndex(restauranteID);
							dispose();
						}
					}

					else {
						JOptionPane.showMessageDialog(null, "Credenciais incorretas. Por favor, verifique.",
								"Verificação", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Os campos de credenciais não podem ser vazios!", "Verificação",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setOpaque(true);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(true);
		btnLogin.setBounds(65, 408, 120, 23);
		contentPane.add(btnLogin);

		lblUsuario = new JLabel("USU\u00C1RIO");
		lblUsuario.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setLabelFor(txtUsuario);
		lblUsuario.setBounds(65, 264, 70, 14);
		contentPane.add(lblUsuario);

		lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setLabelFor(pswSenha);
		lblSenha.setBounds(65, 329, 46, 14);
		contentPane.add(lblSenha);

		lblEsqueciMinhaSenha = new JLabel("Esqueci minha senha");
		lblEsqueciMinhaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarRecuperacaoSenha();
				dispose();

			}
		});
		lblEsqueciMinhaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEsqueciMinhaSenha.setForeground(Color.WHITE);
		lblEsqueciMinhaSenha.setBounds(195, 412, 150, 14);
		contentPane.add(lblEsqueciMinhaSenha);

		lblCadastrese = new JLabel("Cadastre-se!");
		lblCadastrese.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarCadastroUsuario();
				dispose();
			}
		});
		lblCadastrese.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCadastrese.setForeground(Color.WHITE);
		lblCadastrese.setBounds(195, 437, 150, 14);
		contentPane.add(lblCadastrese);

	}
}
