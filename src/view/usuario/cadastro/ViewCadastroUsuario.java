package view.usuario.cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControllerCEP;
import controller.ControllerLogin;
import controller.ControllerUsuario;
import model.ModelUsuario;

public class ViewCadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtCelular;
	private JTextField txtCEP;
	private JTextField txtUF;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEndereco;
	private JTextField txtLogradouro;
	private JTextField txtComplemento;

	public ViewCadastroUsuario() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ViewCadastroUsuario.class.getResource("/img/logo/logo (16x16).png")));
		setTitle("Cadastro de Usu\u00E1rio");

		// Máscara de Campo.
		MaskFormatter campoCelular = null;
		MaskFormatter campoCpf = null;
		MaskFormatter campoCep = null;
		try {
			campoCelular = new MaskFormatter("(##)#####-####");
			campoCelular.setPlaceholderCharacter('_');
			campoCpf = new MaskFormatter("###.###.###-##");
			campoCpf.setPlaceholderCharacter('_');
			campoCep = new MaskFormatter("##.###-###");
			campoCep.setPlaceholderCharacter('_');
		} catch (Exception e) {
		}

		setBounds(100, 100, 420, 750);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPessoais = new JLabel("PESSOAIS");
		lblPessoais.setBounds(32, 27, 100, 14);
		lblPessoais.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblPessoais.setForeground(Color.WHITE);
		contentPane.add(lblPessoais);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(32, 63, 340, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setBounds(32, 88, 340, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(32, 129, 340, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(32, 154, 340, 30);
		contentPane.add(txtEmail);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(32, 195, 340, 14);
		contentPane.add(lblCpf);

		txtCpf = new JFormattedTextField(campoCpf);
		txtCpf.setText("CPF (APENAS N\u00DAMEROS)");
		txtCpf.setForeground(Color.DARK_GRAY);
		txtCpf.setColumns(10);
		txtCpf.setBounds(32, 220, 340, 30);
		contentPane.add(txtCpf);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setBounds(32, 261, 340, 14);
		contentPane.add(lblCelular);

		txtCelular = new JFormattedTextField(campoCelular);
		txtCelular.setText("CELULAR");
		txtCelular.setForeground(Color.DARK_GRAY);
		txtCelular.setColumns(10);
		txtCelular.setBounds(32, 286, 340, 30);
		contentPane.add(txtCelular);

		JLabel lblEnderecoTitulo = new JLabel("ENDERE\u00C7O");
		lblEnderecoTitulo.setForeground(Color.WHITE);
		lblEnderecoTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblEnderecoTitulo.setBounds(32, 351, 100, 14);
		contentPane.add(lblEnderecoTitulo);

		txtCEP = new JFormattedTextField(campoCep);
		txtCEP.setText("CEP");
		txtCEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtCEP.getText().length() == 0) {
					txtCEP.setText("CEP");
				} else {

					ControllerCEP webServiceCep = ControllerCEP.searchCep(txtCEP.getText());
					if (webServiceCep.wasSuccessful()) {
						txtEndereco.setText(webServiceCep.getLogradouroFull());
						txtCidade.setText(webServiceCep.getCidade());
						txtBairro.setText(webServiceCep.getBairro());
						txtUF.setText(webServiceCep.getUf());
						System.out.println("Cep: " + webServiceCep.getCep());
						System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
						System.out.println("Bairro: " + webServiceCep.getBairro());
						System.out.println("Cidade: " + webServiceCep.getCidade() + "/" + webServiceCep.getUf());

					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado. Por favor, verifique.", "CEP inválido",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.WHITE);
		lblCep.setBounds(32, 386, 46, 14);
		contentPane.add(lblCep);
		txtCEP.setForeground(Color.DARK_GRAY);
		txtCEP.setColumns(10);
		txtCEP.setBounds(32, 411, 160, 30);
		contentPane.add(txtCEP);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setForeground(Color.WHITE);
		lblUf.setBounds(212, 386, 160, 14);
		contentPane.add(lblUf);

		txtUF = new JTextField();

		txtUF.setForeground(Color.DARK_GRAY);
		txtUF.setColumns(10);
		txtUF.setBounds(212, 411, 160, 30);
		contentPane.add(txtUF);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBounds(32, 452, 160, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setForeground(Color.DARK_GRAY);
		txtCidade.setColumns(10);
		txtCidade.setBounds(32, 477, 160, 30);
		contentPane.add(txtCidade);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setBounds(212, 452, 46, 14);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setForeground(Color.DARK_GRAY);
		txtBairro.setColumns(10);
		txtBairro.setBounds(212, 477, 160, 30);
		contentPane.add(txtBairro);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setBounds(32, 518, 340, 14);
		contentPane.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setForeground(Color.DARK_GRAY);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(32, 543, 340, 30);
		contentPane.add(txtEndereco);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setBounds(212, 584, 160, 14);
		contentPane.add(lblComplemento);

		txtLogradouro = new JTextField();
		txtLogradouro.setForeground(Color.DARK_GRAY);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(32, 609, 160, 30);
		contentPane.add(txtLogradouro);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(Color.WHITE);
		lblLogradouro.setBounds(32, 584, 160, 14);
		contentPane.add(lblLogradouro);

		txtComplemento = new JTextField();
		txtComplemento.setForeground(Color.DARK_GRAY);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(212, 609, 160, 30);
		contentPane.add(txtComplemento);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelUsuario u = new ModelUsuario();
				ControllerUsuario cu = new ControllerUsuario();

				u.setUsuario_bairro(txtBairro.getText());
				u.setUsuario_cep(txtCEP.getText());
				u.setUsuario_cidade(txtCidade.getText());
				u.setUsuario_complemento(txtComplemento.getText());
				u.setUsuario_cpf(txtCpf.getText());
				u.setUsuario_email(txtEmail.getText());
				u.setUsuario_endereco(txtEndereco.getText());
				u.setUsuario_logradouro(txtLogradouro.getText());
				u.setUsuario_nome(txtNome.getText());
				u.setUsuario_thumbnail("");
				u.setUsuario_uf(txtUF.getText());
				u.setUsuario_celular(txtCelular.getText());

				cu.cadastrarUsuario(u);

				JOptionPane.showMessageDialog(null,
						"Cadastrado de usuário completado com sucesso! Agora você cadastrará suas credenciais.",
						"Usuário cadastrado", JOptionPane.OK_OPTION);

				ControllerLogin cl = new ControllerLogin();
				cl.carregarCadastroLogin(u);
				dispose();

			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setOpaque(true);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(true);
		btnCadastrar.setBounds(32, 662, 160, 23);
		contentPane.add(btnCadastrar);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBackground(new Color(51, 51, 51));
		separator.setBounds(32, 373, 340, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.ORANGE);
		separator_1.setBackground(new Color(51, 51, 51));
		separator_1.setBounds(32, 50, 340, 2);
		contentPane.add(separator_1);
	}
}
