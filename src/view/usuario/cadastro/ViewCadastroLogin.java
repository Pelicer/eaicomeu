package view.usuario.cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import controller.ControllerLogin;
import controller.ControllerRestaurante;
import controller.ControllerUsuario;
import model.ModelLogin;
import model.ModelRestaurante;
import model.ModelUsuario;

public class ViewCadastroLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswSenha;
	private JPasswordField pswConfirmar;

	class JTextFieldLimit extends PlainDocument {

		private static final long serialVersionUID = 1L;

		private int limit;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
	}

	public void cadastrarLogin(String tipo, int id) {

		String senha = new String(pswSenha.getPassword());
		String confirmar = new String(pswConfirmar.getPassword());

		if (!senha.toString().equals(confirmar)) {
			JOptionPane.showMessageDialog(null, "As senhas não conferem!", "Campo inválido",
					JOptionPane.WARNING_MESSAGE);
			pswConfirmar.grabFocus();

		} else {
			switch (tipo) {
			case "usuario":
				ModelLogin lu = new ModelLogin();
				ModelUsuario nu = new ModelUsuario();

				ControllerLogin clu = new ControllerLogin();
				ControllerUsuario cu = new ControllerUsuario();

				nu = cu.selecionarUsuarioID(id);

				String senhau = new String(pswSenha.getPassword());
				lu.setLogin_nome(txtUsuario.getText());
				lu.setLogin_senha(senhau);
				lu.setLogin_email(nu.getUsuario_email());

				if (clu.verificarCredenciais(lu.getLogin_nome(), lu.getLogin_email()).equals("")) {
					lu.setUsuario_id(nu.getUsuario_id());

					clu.cadastrarLoginUsuario(lu);

					JOptionPane.showMessageDialog(null, "Tudo pronto! Seus pedidos já podem começar a serem feitos.",
							"Cadastro realizado!", JOptionPane.OK_OPTION);

					clu.carregarLogin();
					dispose();

				} else {
					JOptionPane.showMessageDialog(null,
							clu.verificarCredenciais(lu.getLogin_nome(), lu.getLogin_email()),
							"Nome de usuário ou email em uso", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "restaurante":
				ModelLogin lr = new ModelLogin();
				ModelRestaurante nr = new ModelRestaurante();

				ControllerLogin clr = new ControllerLogin();
				ControllerRestaurante cr = new ControllerRestaurante();


				nr = cr.selecionarRestauranteID(id);

				String senhar = new String(pswSenha.getPassword());
				lr.setLogin_nome(txtUsuario.getText());
				lr.setLogin_senha(senhar);
				lr.setLogin_email(nr.getRestaurante_email());

				if (clr.verificarCredenciais(lr.getLogin_nome(), lr.getLogin_email()).equals("")) {
					lr.setRestaurante_id(nr.getRestaurante_id());

					clr.cadastrarLoginRestaurante(lr);

					JOptionPane.showMessageDialog(null,
							"Tudo pronto! O cadastro do seu restaurante está pronto para ser usado.",
							"Cadastro realizado!", JOptionPane.OK_OPTION);

					clr.carregarLogin();
					dispose();

				} else {
					JOptionPane.showMessageDialog(null,
							clr.verificarCredenciais(lr.getLogin_nome(), lr.getLogin_email()),
							"Nome de usuário ou email em uso", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "entregador":
				ModelLogin lue = new ModelLogin();
				ModelUsuario nue = new ModelUsuario();

				ControllerLogin clue = new ControllerLogin();
				ControllerUsuario cue = new ControllerUsuario();

				nue = cue.selecionarUsuarioID(id);

				String senhaue = new String(pswSenha.getPassword());
				lue.setLogin_nome(txtUsuario.getText());
				lue.setLogin_senha(senhaue);
				lue.setLogin_email(nue.getUsuario_email());

				if (clue.verificarCredenciais(lue.getLogin_nome(), lue.getLogin_email()).equals("")) {
					lue.setUsuario_id(nue.getUsuario_id());

					clue.cadastrarLoginUsuario(lue);

					JOptionPane.showMessageDialog(null, "Tudo pronto! Seus pedidos já podem começar a serem feitos.",
							"Cadastro realizado!", JOptionPane.OK_OPTION);

					clue.carregarLogin();
					dispose();

				} else {
					JOptionPane.showMessageDialog(null,
							clue.verificarCredenciais(lue.getLogin_nome(), lue.getLogin_email()),
							"Nome de usuário ou email em uso", JOptionPane.WARNING_MESSAGE);
				}
				break;
			}
		}

	}

	public ViewCadastroLogin(String tipo, int id) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ViewCadastroLogin.class.getResource("/img/logo/logo (64x64).png")));
		setTitle("Cadastro de Usu\u00E1rio");
		setBounds(100, 100, 420, 750);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("/img/logo/logo-medium.png")));
		lblLogo.setBounds(15, 65, 379, 75);
		contentPane.add(lblLogo);

		JLabel lblQuase = new JLabel("Quase l\u00E1! Agora s\u00F3 falta escolher suas credenciais...");
		lblQuase.setForeground(Color.WHITE);
		lblQuase.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblQuase.setBounds(39, 180, 365, 30);
		contentPane.add(lblQuase);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblUsurio.setBounds(39, 221, 88, 30);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSenha.setBounds(39, 262, 88, 30);
		contentPane.add(lblSenha);

		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setBounds(122, 221, 238, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.setDocument(new JTextFieldLimit(30));

		pswSenha = new JPasswordField();
		pswSenha.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					cadastrarLogin(tipo, id);
				}
			}
		});
		pswSenha.setForeground(Color.DARK_GRAY);
		pswSenha.setBounds(122, 260, 238, 30);
		contentPane.add(pswSenha);
		pswSenha.setDocument(new JTextFieldLimit(12));

		JButton btnCadastrar = new JButton("TUDO PRONTO!");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setOpaque(true);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(true);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarLogin(tipo, id);
			}
		});
		btnCadastrar.setBounds(139, 577, 128, 23);
		contentPane.add(btnCadastrar);

		pswConfirmar = new JPasswordField();
		pswConfirmar.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					cadastrarLogin(tipo, id);
				}
			}
		});
		pswConfirmar.setForeground(Color.DARK_GRAY);
		pswConfirmar.setBounds(122, 301, 238, 30);
		contentPane.add(pswConfirmar);

		JLabel lblConfirmar = new JLabel("Confirmar:");
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblConfirmar.setBounds(39, 303, 88, 30);
		contentPane.add(lblConfirmar);
	}
}
