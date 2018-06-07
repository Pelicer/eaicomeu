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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import controller.ControllerLogin;
import controller.ControllerPedido;
import controller.ControllerUsuario;
import model.ModelPedido;
import model.ModelUsuario;

public class ViewPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

	ModelUsuario usuario = new ModelUsuario();
	ControllerLogin cl = new ControllerLogin();

	private JPanel pessoal;
	private JTextField txtNome;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtLogradouro;
	private JTextField txtComplemento;
	private JTextField txtUf;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtCelular;

	public ViewPerfil(ModelUsuario u) {
		setForeground(Color.BLACK);
		usuario = u;

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
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
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
		button.setForeground(Color.BLACK);
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
		button_1.setForeground(Color.BLACK);
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
		button_2.setForeground(Color.BLACK);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(221, 18, 64, 64);
		panel.add(button_2);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				ControllerPedido cp = new ControllerPedido();
				ModelPedido p = new ModelPedido();
				p = cp.selecionarPedidosAbertos(usuario.getUsuario_id());
				cu.carregarCarrinho(usuario, p);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		button_3.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/cart (64x64).png")));
		button_3.setOpaque(true);
		button_3.setForeground(Color.BLACK);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(316, 18, 64, 64);
		panel.add(button_3);

		JPanel viewport = new JPanel();
		viewport.setForeground(Color.BLACK);
		viewport.setBackground(Color.WHITE);
		viewport.setBounds(0, 100, 414, 622);
		contentPane.add(viewport);
		viewport.setLayout(null);

		pessoal = new JPanel();
		pessoal.setBackground(Color.WHITE);
		pessoal.setBounds(0, 0, 414, 233);
		viewport.add(pessoal);
		pessoal.setLayout(null);

		JLabel label = new JLabel("INFORMA\u00C7\u00D5ES PESSOAIS");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		label.setBounds(30, 39, 166, 20);
		pessoal.add(label);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator.setBounds(30, 65, 354, 2);
		pessoal.add(separator);

		JLabel label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(30, 98, 50, 14);
		pessoal.add(label_1);

		txtNome = new JTextField();
		txtNome.setForeground(Color.BLACK);
		txtNome.setColumns(10);
		txtNome.setBounds(90, 95, 294, 20);
		txtNome.setDocument(new JTextFieldLimit(30));
		txtNome.setText(u.getUsuario_nome());
		pessoal.add(txtNome);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(30, 151, 50, 14);
		pessoal.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 148, 294, 20);
		txtEmail.setDocument(new JTextFieldLimit(30));
		txtEmail.setText(u.getUsuario_email());
		pessoal.add(txtEmail);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setBounds(30, 204, 50, 14);
		pessoal.add(lblCpf);

		txtCpf = new JFormattedTextField(campoCpf);
		txtCpf.setForeground(Color.BLACK);
		txtCpf.setColumns(10);
		txtCpf.setBounds(90, 201, 101, 20);
		txtCpf.setText(u.getUsuario_cpf());
		pessoal.add(txtCpf);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCelular.setForeground(Color.BLACK);
		lblCelular.setBounds(201, 204, 50, 14);
		pessoal.add(lblCelular);

		txtCelular = new JFormattedTextField(campoCelular);
		txtCelular.setForeground(Color.BLACK);
		txtCelular.setColumns(10);
		txtCelular.setBounds(264, 201, 120, 20);
		txtCelular.setText(u.getUsuario_celular());
		pessoal.add(txtCelular);

		JPanel botoes = new JPanel();
		botoes.setBackground(Color.WHITE);
		botoes.setBounds(0, 506, 414, 116);
		viewport.add(botoes);
		botoes.setLayout(null);

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnSalvar.setIcon(new ImageIcon(ViewPerfil.class.getResource("/img/icon/save (64x64).png")));
		btnSalvar.setOpaque(true);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setBorderPainted(false);
		btnSalvar.setBounds(174, 11, 64, 64);
		botoes.add(btnSalvar);

		JButton btnDeletarConta = new JButton("");
		btnDeletarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Tem certeza de que deseja deletar sua conta? Seus dados continuarão salvos caso queira voltar.",
						"Confirmação", dialogButton);
				if (dialogResult == 0) {
					cl.deletarLogin(u);
					JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso.", "Confirmação",
							JOptionPane.INFORMATION_MESSAGE);
					cl.carregarLogin();
					dispose();
				} else {
					//
				}

			}
		});
		btnDeletarConta.setIcon(new ImageIcon(ViewPerfil.class.getResource("/img/icon/delete (64x64).png")));
		btnDeletarConta.setOpaque(true);
		btnDeletarConta.setForeground(Color.BLACK);
		btnDeletarConta.setContentAreaFilled(false);
		btnDeletarConta.setBorderPainted(false);
		btnDeletarConta.setBounds(55, 11, 64, 64);
		botoes.add(btnDeletarConta);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerLogin cl = new ControllerLogin();
				cl.carregarLogin();
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(ViewPerfil.class.getResource("/img/icon/exit (64x64).png")));
		btnSair.setOpaque(true);
		btnSair.setForeground(Color.BLACK);
		btnSair.setContentAreaFilled(false);
		btnSair.setBorderPainted(false);
		btnSair.setBounds(293, 11, 64, 64);
		botoes.add(btnSair);

		JPanel endereco = new JPanel();
		endereco.setBackground(Color.WHITE);
		endereco.setBounds(0, 204, 414, 316);
		viewport.add(endereco);
		endereco.setLayout(null);

		JLabel label_5 = new JLabel("ENDERE\u00C7O DE ENTREGA");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		label_5.setBounds(31, 40, 157, 20);
		endereco.add(label_5);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator_1.setBounds(31, 66, 354, 2);
		endereco.add(separator_1);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.BLACK);
		lblCep.setBounds(31, 262, 50, 14);
		endereco.add(lblCep);

		txtCep = new JFormattedTextField(campoCep);
		txtCep.setForeground(Color.BLACK);
		txtCep.setColumns(10);
		txtCep.setBounds(91, 259, 90, 20);
		txtCep.setText(u.getUsuario_cep());
		endereco.add(txtCep);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.BLACK);
		lblCidade.setBounds(31, 208, 50, 14);
		endereco.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setText((String) null);
		txtCidade.setForeground(Color.BLACK);
		txtCidade.setColumns(10);
		txtCidade.setBounds(91, 205, 207, 20);
		txtCidade.setText(u.getUsuario_cidade());
		endereco.add(txtCidade);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.BLACK);
		lblBairro.setBounds(30, 154, 50, 14);
		endereco.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setText((String) null);
		txtBairro.setForeground(Color.BLACK);
		txtBairro.setColumns(10);
		txtBairro.setBounds(90, 151, 295, 20);
		txtBairro.setText(u.getUsuario_bairro());
		endereco.add(txtBairro);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(Color.BLACK);
		lblEndereco.setBounds(31, 100, 70, 14);
		endereco.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setText((String) null);
		txtEndereco.setForeground(Color.BLACK);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(91, 97, 158, 20);
		txtEndereco.setText(u.getUsuario_endereco());
		endereco.add(txtEndereco);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogradouro.setForeground(Color.BLACK);
		lblLogradouro.setBounds(259, 100, 70, 14);
		endereco.add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setForeground(Color.BLACK);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(345, 97, 40, 20);
		txtLogradouro.setDocument(new JTextFieldLimit(10));
		txtLogradouro.setText(u.getUsuario_logradouro());
		endereco.add(txtLogradouro);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplemento.setForeground(Color.BLACK);
		lblComplemento.setBounds(184, 262, 90, 14);
		endereco.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setForeground(Color.BLACK);
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(275, 259, 110, 20);
		txtComplemento.setDocument(new JTextFieldLimit(60));
		txtComplemento.setText(u.getUsuario_complemento());
		endereco.add(txtComplemento);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setForeground(Color.BLACK);
		lblUf.setBounds(297, 208, 30, 14);
		endereco.add(lblUf);

		txtUf = new JTextField();
		txtUf.setForeground(Color.BLACK);
		txtUf.setColumns(10);
		txtUf.setBounds(345, 205, 40, 20);
		txtUf.setDocument(new JTextFieldLimit(2));
		txtUf.setText(u.getUsuario_uf());
		endereco.add(txtUf);

	}
}
