package view.usuario.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControllerCEP;
import dao.DaoUsuario;
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
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewCadastroUsuario.class.getResource("/img/logo/logo-medium.png")));
		label.setBounds(10, 44, 379, 75);
		contentPane.add(label);

		JLabel lblPessoais = new JLabel("PESSOAIS");
		lblPessoais.setBounds(32, 153, 100, 14);
		lblPessoais.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblPessoais.setForeground(Color.WHITE);
		contentPane.add(lblPessoais);

		txtNome = new JTextField();
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setBounds(32, 178, 340, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(32, 219, 340, 30);
		contentPane.add(txtEmail);

		txtCpf = new JFormattedTextField(campoCpf);
		txtCpf.setText("CPF (APENAS N\u00DAMEROS)");
		txtCpf.setForeground(Color.DARK_GRAY);
		txtCpf.setColumns(10);
		txtCpf.setBounds(32, 260, 340, 30);
		contentPane.add(txtCpf);

		txtCelular = new JFormattedTextField(campoCelular);
		txtCelular.setText("CELULAR");
		txtCelular.setForeground(Color.DARK_GRAY);
		txtCelular.setColumns(10);
		txtCelular.setBounds(32, 301, 340, 30);
		contentPane.add(txtCelular);

		JLabel lblEndereco = new JLabel("ENDERE\u00C7O");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblEndereco.setBounds(32, 342, 100, 14);
		contentPane.add(lblEndereco);

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
		txtCEP.setForeground(Color.DARK_GRAY);
		txtCEP.setColumns(10);
		txtCEP.setBounds(32, 367, 160, 30);
		contentPane.add(txtCEP);

		txtUF = new JTextField();

		txtUF.setForeground(Color.DARK_GRAY);
		txtUF.setColumns(10);
		txtUF.setBounds(212, 367, 160, 30);
		contentPane.add(txtUF);

		txtCidade = new JTextField();
		txtCidade.setForeground(Color.DARK_GRAY);
		txtCidade.setColumns(10);
		txtCidade.setBounds(32, 408, 160, 30);
		contentPane.add(txtCidade);

		txtBairro = new JTextField();
		txtBairro.setForeground(Color.DARK_GRAY);
		txtBairro.setColumns(10);
		txtBairro.setBounds(212, 408, 160, 30);
		contentPane.add(txtBairro);

		txtEndereco = new JTextField();
		txtEndereco.setForeground(Color.DARK_GRAY);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(32, 449, 340, 30);
		contentPane.add(txtEndereco);

		txtLogradouro = new JTextField();
		txtLogradouro.setForeground(Color.DARK_GRAY);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(32, 490, 160, 30);
		contentPane.add(txtLogradouro);

		txtComplemento = new JTextField();
		txtComplemento.setForeground(Color.DARK_GRAY);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(212, 490, 160, 30);
		contentPane.add(txtComplemento);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelUsuario u = new ModelUsuario();
				DaoUsuario du = new DaoUsuario();

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

				du.cadastrarUsuario(u);

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastro realizado",
						JOptionPane.OK_OPTION);

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewCadastroLogin frame = new ViewCadastroLogin(u);
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							// frame.setUndecorated(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();

			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setOpaque(true);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(true);
		btnCadastrar.setBounds(32, 570, 160, 23);
		contentPane.add(btnCadastrar);
	}
}
