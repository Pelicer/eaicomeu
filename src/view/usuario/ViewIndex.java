package view.usuario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DaoRestaurante;
import dao.DaoUsuario;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.cadastro.ViewCadastroLogin;
import java.awt.Toolkit;

public class ViewIndex extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ModelUsuario usuario = new ModelUsuario();

	DaoRestaurante dao = new DaoRestaurante();
	List<ModelRestaurante> r = dao.carregarRestaurantes();

	public ViewIndex(ModelUsuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewIndex.class.getResource("/img/logo/logo (16x16).png")));
		setTitle("E a\u00ED, Comeu?");
		usuario = u;

		setBounds(100, 100, 420, 750);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("RESTAURANTES ABERTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setBounds(32, 128, 340, 30);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(51, 51, 51));
		separator.setForeground(Color.BLACK);
		separator.setBounds(32, 156, 340, 2);
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 404, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnHome = new JButton("");
		btnHome.setBounds(29, 18, 64, 64);
		panel.add(btnHome);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// carregarTabela();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setForeground(Color.WHITE);
		btnHome.setOpaque(true);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);

		JButton btnPerfil = new JButton("");
		btnPerfil.setBounds(122, 18, 64, 64);
		panel.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewPerfil frame = new ViewPerfil(usuario);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				dispose();

				DaoUsuario daoU = new DaoUsuario();
				usuario = daoU.selecionarUsuarioID(u.getUsuario_id());

			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setOpaque(true);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);

		JButton btnPedidos = new JButton("");
		btnPedidos.setBounds(215, 18, 64, 64);
		panel.add(btnPedidos);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setOpaque(true);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.setBounds(308, 18, 64, 64);
		panel.add(btnCarrinho);
		btnCarrinho.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setOpaque(true);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(32, 169, 340, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblImagem_1 = new JLabel("");
		lblImagem_1.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(0))));
		lblImagem_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblImagem_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem_1.setBackground(Color.BLACK);
		lblImagem_1.setBounds(10, 11, 78, 78);
		panel_1.add(lblImagem_1);

		JLabel lblRestaurante_1 = new JLabel(carregarRazaoSocial(0));
		lblRestaurante_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblRestaurante_1.setBounds(98, 11, 232, 14);
		panel_1.add(lblRestaurante_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.ORANGE);
		separator_1.setBackground(new Color(51, 51, 51));
		separator_1.setBounds(98, 25, 232, 2);
		panel_1.add(separator_1);

		JLabel lblEndereco_1 = new JLabel(carregarEndereco(0));
		lblEndereco_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEndereco_1.setBounds(98, 36, 232, 53);
		panel_1.add(lblEndereco_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(32, 280, 340, 100);
		contentPane.add(panel_2);

		JLabel lblImagem_2 = new JLabel("");
		lblImagem_2.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(1))));
		lblImagem_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblImagem_2.setBackground(Color.BLACK);
		lblImagem_2.setBounds(10, 11, 78, 78);
		panel_2.add(lblImagem_2);

		JLabel lblRestaurante_2 = new JLabel(carregarRazaoSocial(1));
		lblRestaurante_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblRestaurante_2.setBounds(98, 11, 232, 14);
		panel_2.add(lblRestaurante_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.ORANGE);
		separator_2.setBackground(new Color(51, 51, 51));
		separator_2.setBounds(98, 25, 232, 2);
		panel_2.add(separator_2);

		JLabel lblEndereco_2 = new JLabel(carregarEndereco(1));
		lblEndereco_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEndereco_2.setBounds(98, 36, 232, 53);
		panel_2.add(lblEndereco_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(32, 391, 340, 100);
		contentPane.add(panel_3);

		JLabel lblImagem_3 = new JLabel("");
		lblImagem_3.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(2))));
		lblImagem_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblImagem_3.setBackground(Color.BLACK);
		lblImagem_3.setBounds(10, 11, 78, 78);
		panel_3.add(lblImagem_3);

		JLabel lblRestaurante_3 = new JLabel(carregarRazaoSocial(2));
		lblRestaurante_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblRestaurante_3.setBounds(98, 11, 232, 14);
		panel_3.add(lblRestaurante_3);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.ORANGE);
		separator_3.setBackground(new Color(51, 51, 51));
		separator_3.setBounds(98, 25, 232, 2);
		panel_3.add(separator_3);

		JLabel lblEndereco_3 = new JLabel(carregarEndereco(2));
		lblEndereco_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEndereco_3.setBounds(98, 36, 232, 53);
		panel_3.add(lblEndereco_3);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(32, 502, 340, 100);
		contentPane.add(panel_4);

		JLabel lblImagem_4 = new JLabel("");
		lblImagem_4.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(3))));
		lblImagem_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblImagem_4.setBackground(Color.BLACK);
		lblImagem_4.setBounds(10, 11, 78, 78);
		panel_4.add(lblImagem_4);

		JLabel lblRestaurante_4 = new JLabel(carregarRazaoSocial(3));
		lblRestaurante_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblRestaurante_4.setBounds(98, 11, 232, 14);
		panel_4.add(lblRestaurante_4);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.ORANGE);
		separator_4.setBackground(new Color(51, 51, 51));
		separator_4.setBounds(98, 25, 232, 2);
		panel_4.add(separator_4);

		JLabel lblEndereco_4 = new JLabel(carregarEndereco(3));
		lblEndereco_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEndereco_4.setBounds(98, 36, 232, 53);
		panel_4.add(lblEndereco_4);

		JLabel lblNext = new JLabel("");
		lblNext.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/next (32x32).png")));
		lblNext.setBounds(258, 641, 32, 32);
		contentPane.add(lblNext);

		JLabel lblPrevious = new JLabel("");
		lblPrevious.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/back (32x32).png")));
		lblPrevious.setBounds(113, 641, 32, 32);
		contentPane.add(lblPrevious);

	}

	// Métodos para retornar razão social, imagem e endereço de cada restaurante
	public String carregarRazaoSocial(int i) {
		ModelRestaurante res = r.get(i);
		return res.getRestaurante_razaosocial();
	}

	public String carregarImagem(int i) {
		ModelRestaurante res = r.get(i);
		return res.getRestaurante_thumbnail();
	}

	public String carregarEndereco(int i) {
		ModelRestaurante res = r.get(i);
		return res.getRestaurante_endereco();
	}
}
