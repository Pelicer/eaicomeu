package view.usuario.cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import controller.ControllerLogin;
import controller.ControllerUsuario;
import model.ModelLogin;
import model.ModelUsuario;

public class ViewCadastroLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswSenha;

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

	public ViewCadastroLogin(ModelUsuario u) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ViewCadastroLogin.class.getResource("/img/logo/logo (16x16).png")));
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
		txtUsuario.setBounds(110, 223, 238, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.setDocument(new JTextFieldLimit(30));

		pswSenha = new JPasswordField();
		pswSenha.setForeground(Color.DARK_GRAY);
		pswSenha.setBounds(110, 262, 238, 30);
		contentPane.add(pswSenha);
		pswSenha.setDocument(new JTextFieldLimit(12));

		JLabel lblEUmaFoto = new JLabel("E uma foto para lembrarmos de voc\u00EA");
		lblEUmaFoto.setForeground(Color.WHITE);
		lblEUmaFoto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblEUmaFoto.setBounds(39, 303, 365, 30);
		contentPane.add(lblEUmaFoto);

		JLabel lblPerfil = new JLabel("");
		lblPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Importar imagem");
				FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				fileChooser.addChoosableFileFilter(imageFilter);

				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				if (fileChooser.showOpenDialog(lblPerfil) == JFileChooser.APPROVE_OPTION) {

					ImageIcon img = new ImageIcon(fileChooser.getSelectedFile().getPath());

					img.setImage(img.getImage().getScaledInstance(lblPerfil.getWidth(), lblPerfil.getHeight(), 100));

					String diretorio = fileChooser.getSelectedFile().getPath();

					StringBuilder sb = new StringBuilder(diretorio);

					int contador = diretorio.length();

					for (int i = 0; i < contador; i++) {
						if (diretorio.substring(i, i + 1).equals("\\")) {
							int posicao = i + 1;
							sb.setCharAt((posicao - 1), '/');
						}
					}

					diretorio = sb.toString();
					lblPerfil.setIcon(img);

				}

			}
		});
		lblPerfil.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("/img/user/user (128px).png")));
		lblPerfil.setBounds(139, 368, 128, 128);
		contentPane.add(lblPerfil);

		JButton btnCadastrar = new JButton("TUDO PRONTO!");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setOpaque(true);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(true);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModelLogin l = new ModelLogin();
				ModelUsuario nu = new ModelUsuario();

				ControllerLogin cl = new ControllerLogin();
				ControllerUsuario cu = new ControllerUsuario();

				nu = cu.selecionarUsuarioCPF(u.getUsuario_cpf());

				String senha = new String(pswSenha.getPassword());
				l.setLogin_nome(txtUsuario.getText());
				l.setLogin_senha(senha);
				l.setLogin_email(nu.getUsuario_email());

				if (!cl.verificarCredenciais(l.getLogin_nome(), l.getLogin_email()).equals("")) {
					l.setUsuario_id(nu.getUsuario_id());

					cl.cadastrarLoginUsuario(l);

					JOptionPane.showMessageDialog(null, "Tudo pronto! Seus pedidos já podem começar a serem feitos.",
							"Cadastro realizado!", JOptionPane.OK_OPTION);

					cl.carregarLogin();
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, cl.verificarCredenciais(l.getLogin_nome(), l.getLogin_email()),
							"Nome de usuário ou email em uso", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnCadastrar.setBounds(139, 526, 128, 23);
		contentPane.add(btnCadastrar);
	}
}
