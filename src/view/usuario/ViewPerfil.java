package view.usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import controller.ControllerLogin;
import controller.ControllerUsuario;
import model.ModelUsuario;

public class ViewPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtCelular;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JLabel lblEndereoDeEntrega;
	private JTextField txtBairro;
	private JTextField txtEndereco;
	private JTextField txtLogradouro;
	private JTextField txtComplemento;
	private JTextField txtUf;
	private JButton btnAtualizar;
	private JButton btnVoltarAoMenu;
	private JLabel lblLogradouro;
	private JLabel lblUf;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblEndereco;
	private JLabel lblCep;
	private JLabel lblCidade;
	private JSeparator separator;
	private JLabel lblCpf;
	private JSeparator separator_1;
	private JLabel lblCelular;
	private JLabel lblEmail;
	private JLabel lblNome;

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

	public ViewPerfil(ModelUsuario u) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewPerfil.class.getResource("/img/logo/logo (64x64).png")));
		setTitle("Perfil");

		// Máscara de Campo.
		MaskFormatter campoCelular = null;
		MaskFormatter campoCpf = null;
		MaskFormatter campoCep = null;
		try {
			campoCelular = new MaskFormatter("(##)#####-####");
			campoCpf = new MaskFormatter("###.###.###-##");
			campoCep = new MaskFormatter("##.###-###");
		} catch (Exception e) {
		}

		setBounds(100, 100, 420, 750);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInformacoesPessoais = new JLabel("INFORMA\u00C7\u00D5ES PESSOAIS");
		lblInformacoesPessoais.setForeground(Color.WHITE);
		lblInformacoesPessoais.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblInformacoesPessoais.setBounds(42, 22, 191, 14);
		contentPane.add(lblInformacoesPessoais);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.ORANGE);
		separator_1.setBackground(new Color(51, 51, 51));
		separator_1.setBounds(42, 54, 330, 2);
		contentPane.add(separator_1);

		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(42, 82, 330, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setBounds(42, 118, 330, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setDocument(new JTextFieldLimit(30));
		txtNome.setText(u.getUsuario_nome());

		lblEmail = new JLabel("E-Mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(42, 181, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(42, 206, 330, 30);
		contentPane.add(txtEmail);
		txtEmail.setDocument(new JTextFieldLimit(30));
		txtEmail.setText(u.getUsuario_email());

		lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(42, 258, 160, 14);
		contentPane.add(lblCpf);

		txtCpf = new JFormattedTextField(campoCpf);
		txtCpf.setForeground(Color.DARK_GRAY);
		txtCpf.setColumns(10);
		txtCpf.setBounds(42, 294, 160, 30);
		contentPane.add(txtCpf);
		txtCpf.setText(u.getUsuario_cpf());

		lblCelular = new JLabel("Celular:");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setBounds(212, 258, 160, 14);
		contentPane.add(lblCelular);

		txtCelular = new JFormattedTextField(campoCelular);
		txtCelular.setForeground(Color.DARK_GRAY);
		txtCelular.setColumns(10);
		txtCelular.setBounds(212, 294, 160, 30);
		contentPane.add(txtCelular);
		txtCelular.setText(u.getUsuario_celular());

		txtCep = new JFormattedTextField(campoCep);
		txtCep.setForeground(Color.DARK_GRAY);
		txtCep.setColumns(10);
		txtCep.setBounds(42, 442, 160, 30);
		contentPane.add(txtCep);
		txtCep.setText(u.getUsuario_cep());

		txtCidade = new JTextField();
		txtCidade.setForeground(Color.DARK_GRAY);
		txtCidade.setColumns(10);
		txtCidade.setBounds(212, 442, 160, 30);
		contentPane.add(txtCidade);
		txtCidade.setDocument(new JTextFieldLimit(60));
		txtCidade.setText(u.getUsuario_cidade());

		lblEndereoDeEntrega = new JLabel("ENDERE\u00C7O DE ENTREGA");
		lblEndereoDeEntrega.setForeground(Color.WHITE);
		lblEndereoDeEntrega.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblEndereoDeEntrega.setBounds(42, 357, 191, 14);
		contentPane.add(lblEndereoDeEntrega);

		separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBackground(new Color(51, 51, 51));
		separator.setBounds(42, 382, 330, 2);
		contentPane.add(separator);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setBounds(42, 494, 160, 14);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setForeground(Color.DARK_GRAY);
		txtBairro.setColumns(10);
		txtBairro.setBounds(42, 530, 160, 30);
		contentPane.add(txtBairro);
		txtBairro.setDocument(new JTextFieldLimit(60));
		txtBairro.setText(u.getUsuario_bairro());

		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setBounds(212, 494, 160, 14);
		contentPane.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setForeground(Color.DARK_GRAY);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(212, 530, 160, 30);
		contentPane.add(txtEndereco);
		txtEndereco.setDocument(new JTextFieldLimit(60));
		txtEndereco.setText(u.getUsuario_endereco());

		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setForeground(Color.WHITE);
		lblLogradouro.setBounds(42, 582, 75, 14);
		contentPane.add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setForeground(Color.DARK_GRAY);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(42, 618, 75, 30);
		contentPane.add(txtLogradouro);
		txtLogradouro.setDocument(new JTextFieldLimit(10));
		txtLogradouro.setText(u.getUsuario_logradouro());

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setBounds(206, 582, 160, 14);
		contentPane.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setForeground(Color.DARK_GRAY);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(212, 618, 160, 30);
		contentPane.add(txtComplemento);
		txtComplemento.setDocument(new JTextFieldLimit(60));
		txtComplemento.setText(u.getUsuario_complemento());

		lblUf = new JLabel("UF:");
		lblUf.setForeground(Color.WHITE);
		lblUf.setBounds(127, 582, 46, 14);
		contentPane.add(lblUf);

		txtUf = new JTextField();
		txtUf.setForeground(Color.DARK_GRAY);
		txtUf.setColumns(10);
		txtUf.setBounds(127, 618, 75, 30);
		contentPane.add(txtUf);
		txtUf.setDocument(new JTextFieldLimit(2));
		txtUf.setText(u.getUsuario_uf());

		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ModelUsuario attU = new ModelUsuario();
				ControllerUsuario cu = new ControllerUsuario();

				attU.setUsuario_id(u.getUsuario_id());
				attU.setUsuario_bairro(txtBairro.getText());
				attU.setUsuario_celular(txtCelular.getText());
				attU.setUsuario_cep(txtCep.getText());
				attU.setUsuario_cidade(txtCidade.getText());
				attU.setUsuario_complemento(txtComplemento.getText());
				attU.setUsuario_cpf(txtCpf.getText());
				attU.setUsuario_email(txtEmail.getText());
				attU.setUsuario_endereco(txtEndereco.getText());
				attU.setUsuario_logradouro(txtLogradouro.getText());
				attU.setUsuario_nome(txtNome.getText());
				attU.setUsuario_uf(txtUf.getText());

				if (cu.verificarObrigatorios(attU).equals("")) {
					cu.atualizarUsuario(attU);

					JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.", "Atualizado!",
							JOptionPane.INFORMATION_MESSAGE);
					cu.carregarIndex(u.getUsuario_id());
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, cu.verificarObrigatorios(attU), "Campos vazios",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setOpaque(true);
		btnAtualizar.setContentAreaFilled(false);
		btnAtualizar.setBorderPainted(true);
		btnAtualizar.setBounds(36, 670, 160, 23);
		contentPane.add(btnAtualizar);

		btnVoltarAoMenu = new JButton("VOLTAR AO MENU");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(u.getUsuario_id());
				dispose();
			}
		});

		btnVoltarAoMenu.setForeground(Color.WHITE);
		btnVoltarAoMenu.setOpaque(true);
		btnVoltarAoMenu.setContentAreaFilled(false);
		btnVoltarAoMenu.setBorderPainted(true);
		btnVoltarAoMenu.setBounds(206, 670, 160, 23);
		contentPane.add(btnVoltarAoMenu);

		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(ViewPerfil.class.getResource("/img/icon/exit (32x32).png")));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerLogin cl = new ControllerLogin();
				cl.carregarLogin();
				dispose();
			}
		});
		btnLogout.setOpaque(true);
		btnLogout.setForeground(Color.RED);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setBounds(340, 11, 32, 32);
		contentPane.add(btnLogout);

		lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.WHITE);
		lblCep.setBounds(42, 406, 46, 14);
		contentPane.add(lblCep);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBounds(212, 406, 46, 14);
		contentPane.add(lblCidade);
	}
}
