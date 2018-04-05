package view.usuario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.text.MaskFormatter;

import dao.DaoUsuario;
import model.ModelUsuario;
import view.ViewLogin;

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
	private JSeparator separator2;
	private JTextField txtBairro;
	private JTextField txtEndereco;
	private JTextField txtLogradouro;
	private JTextField txtComplemento;
	private JTextField txtUf;
	private JButton btnAtualizar;
	private JButton btnVoltarAoMenu;

	public ViewPerfil(ModelUsuario u) {
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

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ViewPerfil.class.getResource("/img/logo/logo-small.png")));
		lblLogo.setBounds(197, 29, 172, 75);
		contentPane.add(lblLogo);

		JLabel lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(ViewPerfil.class.getResource("/img/user/user (128px).png")));
		lblUsuario.setBounds(39, 29, 128, 128);
		contentPane.add(lblUsuario);

		JLabel lblInformacoesPessoais = new JLabel("INFORMA\u00C7\u00D5ES PESSOAIS");
		lblInformacoesPessoais.setForeground(Color.WHITE);
		lblInformacoesPessoais.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblInformacoesPessoais.setBounds(39, 196, 191, 14);
		contentPane.add(lblInformacoesPessoais);

		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.WHITE);
		separator1.setBounds(39, 221, 330, 2);
		contentPane.add(separator1);

		txtNome = new JTextField();
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setText(u.getUsuario_nome());
		txtNome.setBounds(39, 234, 330, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setText(u.getUsuario_email());
		txtEmail.setColumns(10);
		txtEmail.setBounds(39, 275, 330, 30);
		contentPane.add(txtEmail);

		txtCpf = new JFormattedTextField(campoCpf);
		txtCpf.setForeground(Color.DARK_GRAY);
		txtCpf.setText(u.getUsuario_cpf());
		txtCpf.setColumns(10);
		txtCpf.setBounds(39, 316, 160, 30);
		contentPane.add(txtCpf);

		txtCelular = new JFormattedTextField(campoCelular);
		txtCelular.setForeground(Color.DARK_GRAY);
		txtCelular.setText(u.getUsuario_celular());
		txtCelular.setColumns(10);
		txtCelular.setBounds(209, 316, 160, 30);
		contentPane.add(txtCelular);

		txtCep = new JFormattedTextField(campoCep);
		txtCep.setForeground(Color.DARK_GRAY);
		txtCep.setText(u.getUsuario_cep());
		txtCep.setColumns(10);
		txtCep.setBounds(39, 398, 160, 30);
		contentPane.add(txtCep);

		txtCidade = new JTextField();
		txtCidade.setForeground(Color.DARK_GRAY);
		txtCidade.setText(u.getUsuario_cidade());
		txtCidade.setColumns(10);
		txtCidade.setBounds(209, 398, 160, 30);
		contentPane.add(txtCidade);

		lblEndereoDeEntrega = new JLabel("ENDERE\u00C7O DE ENTREGA");
		lblEndereoDeEntrega.setForeground(Color.WHITE);
		lblEndereoDeEntrega.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblEndereoDeEntrega.setBounds(39, 358, 191, 14);
		contentPane.add(lblEndereoDeEntrega);

		separator2 = new JSeparator();
		separator2.setForeground(Color.WHITE);
		separator2.setBounds(39, 383, 330, 2);
		contentPane.add(separator2);

		txtBairro = new JTextField();
		txtBairro.setForeground(Color.DARK_GRAY);
		txtBairro.setText(u.getUsuario_bairro());
		txtBairro.setColumns(10);
		txtBairro.setBounds(39, 439, 160, 30);
		contentPane.add(txtBairro);

		txtEndereco = new JTextField();
		txtEndereco.setForeground(Color.DARK_GRAY);
		txtEndereco.setText(u.getUsuario_endereco());
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(209, 439, 160, 30);
		contentPane.add(txtEndereco);

		txtLogradouro = new JTextField();
		txtLogradouro.setForeground(Color.DARK_GRAY);
		txtLogradouro.setText(u.getUsuario_logradouro());
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(39, 480, 75, 30);
		contentPane.add(txtLogradouro);

		txtComplemento = new JTextField();
		txtComplemento.setForeground(Color.DARK_GRAY);
		txtComplemento.setText(u.getUsuario_complemento());
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(209, 480, 160, 30);
		contentPane.add(txtComplemento);

		txtUf = new JTextField();
		txtUf.setForeground(Color.DARK_GRAY);
		txtUf.setText(u.getUsuario_uf());
		txtUf.setColumns(10);
		txtUf.setBounds(124, 480, 75, 30);
		contentPane.add(txtUf);

		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelUsuario attU = new ModelUsuario();
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

				if (txtBairro.getText().equals("") || txtCelular.getText().equals("") || txtCep.getText().equals("")
						|| txtCidade.getText().equals("") || txtComplemento.getText().equals("")
						|| txtCpf.getText().equals("") || txtEmail.getText().equals("")
						|| txtEndereco.getText().equals("") || txtLogradouro.getText().equals("")
						|| txtNome.getText().equals("") || txtUf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Não é possível atualizar com campos vazios.", "Campos vazios",
							JOptionPane.WARNING_MESSAGE);
				} else {
					DaoUsuario daoU = new DaoUsuario();
					daoU.atualizarUsuario(attU);

					JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.", "Atualizado!",
							JOptionPane.INFORMATION_MESSAGE);
				}

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							ViewIndex frame = new ViewIndex(u);
							frame.setLocationRelativeTo(null);
							frame.setUndecorated(false);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}
		});
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setOpaque(true);
		btnAtualizar.setContentAreaFilled(false);
		btnAtualizar.setBorderPainted(true);
		btnAtualizar.setBounds(39, 595, 160, 23);
		contentPane.add(btnAtualizar);

		btnVoltarAoMenu = new JButton("VOLTAR AO MENU");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							ViewIndex frame = new ViewIndex(u);
							frame.setLocationRelativeTo(null);
							frame.setUndecorated(false);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				dispose();

			}
		});

		btnVoltarAoMenu.setForeground(Color.WHITE);
		btnVoltarAoMenu.setOpaque(true);
		btnVoltarAoMenu.setContentAreaFilled(false);
		btnVoltarAoMenu.setBorderPainted(true);
		btnVoltarAoMenu.setBounds(209, 595, 160, 23);
		contentPane.add(btnVoltarAoMenu);

		JButton btnLogout = new JButton("LOG OUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewLogin frame = new ViewLogin();
							frame.setLocationRelativeTo(null);
							frame.setUndecorated(false);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}
		});
		btnLogout.setOpaque(true);
		btnLogout.setForeground(Color.RED);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(true);
		btnLogout.setBounds(39, 678, 160, 23);
		contentPane.add(btnLogout);
	}
}
