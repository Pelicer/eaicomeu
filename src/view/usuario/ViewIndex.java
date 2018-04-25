package view.usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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

import controller.ControllerRestaurante;
import controller.ControllerUsuario;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.cadastro.ViewCadastroLogin;

public class ViewIndex extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ModelUsuario usuario = new ModelUsuario();

	ControllerRestaurante cr = new ControllerRestaurante();
	List<ModelRestaurante> r = cr.carregarRestaurantes();

	int pageCount = 1;
	float pages;
	String res[] = new String[4];

	public ViewIndex(ModelUsuario u) {

		// Iniciando a variável RES para a primeira página.
		res[0] = "0";
		res[1] = "1";
		res[2] = "2";
		res[3] = "3";

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewIndex.class.getResource("/img/logo/logo (64x64).png")));
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

		JLabel lblTitulo = new JLabel("RESTAURANTES ABERTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 21));
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setBounds(37, 115, 340, 30);
		contentPane.add(lblTitulo);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(51, 51, 51));
		separator.setForeground(Color.BLACK);
		separator.setBounds(37, 156, 340, 2);
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 414, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnHome = new JButton("");
		btnHome.setBounds(31, 18, 64, 64);
		panel.add(btnHome);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setForeground(Color.WHITE);
		btnHome.setOpaque(true);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);

		JButton btnPerfil = new JButton("");
		btnPerfil.setBounds(126, 18, 64, 64);
		panel.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPerfil(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setOpaque(true);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);

		JButton btnPedidos = new JButton("");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPedidos(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPedidos.setBounds(221, 18, 64, 64);
		panel.add(btnPedidos);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setOpaque(true);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarCarrinho(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnCarrinho.setBounds(316, 18, 64, 64);
		panel.add(btnCarrinho);
		btnCarrinho.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setOpaque(true);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarRestaurante(carregarRazaoSocial(Integer.parseInt(res[0])), usuario.getUsuario_id());
				dispose();
			}
		});
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(37, 169, 340, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		if (r.size() != 0) {
			JLabel lblImagem_1 = new JLabel("");
			lblImagem_1.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(0))));
			lblImagem_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblImagem_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblImagem_1.setBackground(Color.BLACK);
			lblImagem_1.setBounds(10, 11, 78, 78);
			panel_1.add(lblImagem_1);

			JLabel lblRestaurante_1 = new JLabel(carregarRazaoSocial(0));
			lblRestaurante_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
			lblRestaurante_1.setBounds(98, 11, 232, 39);
			panel_1.add(lblRestaurante_1);

			JSeparator separator_1 = new JSeparator();
			separator_1.setForeground(Color.ORANGE);
			separator_1.setBackground(new Color(51, 51, 51));
			separator_1.setBounds(98, 50, 232, 2);
			panel_1.add(separator_1);

			JLabel lblEndereco_1 = new JLabel(carregarEndereco(0));
			lblEndereco_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblEndereco_1.setBounds(98, 61, 232, 28);
			panel_1.add(lblEndereco_1);

			JPanel panel_2 = new JPanel();
			panel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					ControllerUsuario cu = new ControllerUsuario();
					cu.carregarRestaurante(carregarRazaoSocial(Integer.parseInt(res[1])), usuario.getUsuario_id());
					dispose();
				}
			});
			panel_2.setLayout(null);
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(37, 280, 340, 100);
			contentPane.add(panel_2);

			JLabel lblImagem_2 = new JLabel("");
			lblImagem_2.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(1))));
			lblImagem_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblImagem_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblImagem_2.setBackground(Color.BLACK);
			lblImagem_2.setBounds(10, 11, 78, 78);
			panel_2.add(lblImagem_2);

			JLabel lblRestaurante_2 = new JLabel(carregarRazaoSocial(1));
			lblRestaurante_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
			lblRestaurante_2.setBounds(98, 11, 232, 39);
			panel_2.add(lblRestaurante_2);

			JSeparator separator_2 = new JSeparator();
			separator_2.setForeground(Color.ORANGE);
			separator_2.setBackground(new Color(51, 51, 51));
			separator_2.setBounds(98, 50, 232, 2);
			panel_2.add(separator_2);

			JLabel lblEndereco_2 = new JLabel(carregarEndereco(1));
			lblEndereco_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblEndereco_2.setBounds(98, 61, 232, 28);
			panel_2.add(lblEndereco_2);

			JPanel panel_3 = new JPanel();
			panel_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					ControllerUsuario cu = new ControllerUsuario();
					cu.carregarRestaurante(carregarRazaoSocial(Integer.parseInt(res[2])), usuario.getUsuario_id());
					dispose();
				}
			});
			panel_3.setLayout(null);
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(37, 391, 340, 100);
			contentPane.add(panel_3);

			JLabel lblImagem_3 = new JLabel("");
			lblImagem_3.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(2))));
			lblImagem_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblImagem_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblImagem_3.setBackground(Color.BLACK);
			lblImagem_3.setBounds(10, 11, 78, 78);
			panel_3.add(lblImagem_3);

			JLabel lblRestaurante_3 = new JLabel(carregarRazaoSocial(2));
			lblRestaurante_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
			lblRestaurante_3.setBounds(98, 11, 232, 39);
			panel_3.add(lblRestaurante_3);

			JSeparator separator_3 = new JSeparator();
			separator_3.setForeground(Color.ORANGE);
			separator_3.setBackground(new Color(51, 51, 51));
			separator_3.setBounds(98, 50, 232, 2);
			panel_3.add(separator_3);

			JLabel lblEndereco_3 = new JLabel(carregarEndereco(2));
			lblEndereco_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblEndereco_3.setBounds(98, 61, 232, 28);
			panel_3.add(lblEndereco_3);

			JPanel panel_4 = new JPanel();
			panel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					ControllerUsuario cu = new ControllerUsuario();
					cu.carregarRestaurante(carregarRazaoSocial(Integer.parseInt(res[3])), usuario.getUsuario_id());
					dispose();
				}
			});
			panel_4.setLayout(null);
			panel_4.setBackground(Color.WHITE);
			panel_4.setBounds(37, 502, 340, 100);
			contentPane.add(panel_4);

			JLabel lblImagem_4 = new JLabel("");
			lblImagem_4.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(3))));
			lblImagem_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblImagem_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblImagem_4.setBackground(Color.BLACK);
			lblImagem_4.setBounds(10, 11, 78, 78);
			panel_4.add(lblImagem_4);

			JLabel lblRestaurante_4 = new JLabel(carregarRazaoSocial(3));
			lblRestaurante_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
			lblRestaurante_4.setBounds(98, 11, 232, 39);
			panel_4.add(lblRestaurante_4);

			JSeparator separator_4 = new JSeparator();
			separator_4.setForeground(Color.ORANGE);
			separator_4.setBackground(new Color(51, 51, 51));
			separator_4.setBounds(98, 50, 232, 2);
			panel_4.add(separator_4);

			JLabel lblEndereco_4 = new JLabel(carregarEndereco(3));
			lblEndereco_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblEndereco_4.setBounds(98, 61, 232, 28);
			panel_4.add(lblEndereco_4);

			JLabel lblPrevious = new JLabel("");

			JLabel lblNext = new JLabel("");
			lblNext.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					pageCount++;
					r = cr.carregarRestaurantes();

					float contagem = pageCount;
					pages = r.size() / (4 * contagem);

					lblPrevious.setVisible(true);
					if (pages < 1) {
						lblNext.setVisible(false);
					} else if (pageCount >= pages) {
						lblNext.setVisible(true);
					} else {
						lblNext.setVisible(false);
					}

					int restaurante[] = new int[4];

					res[0] = "";
					res[1] = "";
					res[2] = "";
					res[3] = "";

					restaurante[0] = (pageCount * 4) - 4;
					restaurante[1] = (pageCount * 4) - 3;
					restaurante[2] = (pageCount * 4) - 2;
					restaurante[3] = (pageCount * 4) - 1;

					int f = 0;

					for (int i = restaurante[0]; i < r.size(); i++) {
						if (f <= 3) {
							if (restaurante[f] <= i) {
								res[f] = Integer.toString(restaurante[f]);
							} else {
								res[f] = "";
							}
							f++;
						}
					}

					if (res[0].toString().equals("")) {

						lblImagem_1.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_1.setText("");
						lblEndereco_1.setText("");

					} else {
						lblImagem_1.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[0]))));
						lblRestaurante_1.setText(carregarRazaoSocial(restaurante[0]));
						lblEndereco_1.setText(carregarEndereco(restaurante[0]));
					}

					if (res[1].toString().equals("")) {

						lblImagem_2.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_2.setText("");
						lblEndereco_2.setText("");
					} else {
						lblImagem_2.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[1]))));
						lblRestaurante_2.setText(carregarRazaoSocial(restaurante[1]));
						lblEndereco_2.setText(carregarEndereco(restaurante[1]));

					}

					if (res[2].toString().equals("")) {
						lblImagem_3.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_3.setText("");
						lblEndereco_3.setText("");

					} else {
						lblImagem_3.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[2]))));
						lblRestaurante_3.setText(carregarRazaoSocial(restaurante[2]));
						lblEndereco_3.setText(carregarEndereco(restaurante[2]));
					}

					if (res[3].toString().equals("")) {

						lblImagem_4.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_4.setText("");
						lblEndereco_4.setText("");

					} else {
						lblImagem_4.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[3]))));
						lblRestaurante_4.setText(carregarRazaoSocial(restaurante[3]));
						lblEndereco_4.setText(carregarEndereco(restaurante[3]));
					}

				}
			});
			lblNext.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/next (32x32).png")));
			lblNext.setBounds(264, 641, 32, 32);
			contentPane.add(lblNext);

			if (pageCount == 1 && pages == 1) {
				lblNext.setVisible(false);
			} else {
				lblNext.setVisible(true);
			}

			// JLabel lblPrevious = new JLabel("");
			lblPrevious.setVisible(false);
			lblPrevious.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					pageCount--;
					r = cr.carregarRestaurantes();

					lblNext.setVisible(true);
					if (pageCount > r.size() / (4 * pageCount)) {
						lblPrevious.setVisible(true);
					} else {
						lblPrevious.setVisible(false);
					}

					int restaurante[] = new int[4];

					res[0] = "";
					res[1] = "";
					res[2] = "";
					res[3] = "";

					restaurante[0] = (pageCount * 4) - 4;
					restaurante[1] = (pageCount * 4) - 3;
					restaurante[2] = (pageCount * 4) - 2;
					restaurante[3] = (pageCount * 4) - 1;

					int f = 0;

					for (int i = restaurante[0]; i < r.size(); i++) {
						if (f <= 3) {
							if (restaurante[f] <= i) {
								res[f] = Integer.toString(restaurante[f]);
							} else {
								res[f] = "";
							}
							f++;
						}
					}

					if (res[0].toString().equals("")) {

						lblImagem_1.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_1.setText("");
						lblEndereco_1.setText("");

					} else {
						lblImagem_1.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[0]))));
						lblRestaurante_1.setText(carregarRazaoSocial(restaurante[0]));
						lblEndereco_1.setText(carregarEndereco(restaurante[0]));
					}

					if (res[1].toString().equals("")) {

						lblImagem_2.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_2.setText("");
						lblEndereco_2.setText("");
					} else {
						lblImagem_2.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[1]))));
						lblRestaurante_2.setText(carregarRazaoSocial(restaurante[1]));
						lblEndereco_2.setText(carregarEndereco(restaurante[1]));

					}

					if (res[2].toString().equals("")) {
						lblImagem_3.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_3.setText("");
						lblEndereco_3.setText("");

					} else {
						lblImagem_3.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[2]))));
						lblRestaurante_3.setText(carregarRazaoSocial(restaurante[2]));
						lblEndereco_3.setText(carregarEndereco(restaurante[2]));
					}

					if (res[3].toString().equals("")) {

						lblImagem_4.setIcon(new ImageIcon(ViewCadastroLogin.class.getResource("")));
						lblRestaurante_4.setText("");
						lblEndereco_4.setText("");

					} else {
						lblImagem_4.setIcon(
								new ImageIcon(ViewCadastroLogin.class.getResource(carregarImagem(restaurante[3]))));
						lblRestaurante_4.setText(carregarRazaoSocial(restaurante[3]));
						lblEndereco_4.setText(carregarEndereco(restaurante[3]));
					}

				}
			});
			lblPrevious.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/back (32x32).png")));
			lblPrevious.setBounds(116, 641, 32, 32);
			contentPane.add(lblPrevious);
		} else {
			JLabel semRestaurantes = new JLabel("Não foram encontrados restaurantes...");
			semRestaurantes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			semRestaurantes.setHorizontalAlignment(SwingConstants.CENTER);
			semRestaurantes.setBackground(Color.BLACK);
			semRestaurantes.setBounds(10, 11, 320, 78);
			panel_1.add(semRestaurantes);
		}

	}

	// Métodos para retornar razão social, imagem e endereço de cada restaurante
	public String carregarRazaoSocial(int i) {
		if (r.size() == 0) {
			return "";
		} else {
			ModelRestaurante res = r.get(i);
			return res.getRestaurante_razaosocial();
		}
	}

	public String carregarImagem(int i) {
		if (r.size() == 0) {
			return "";
		} else {
			ModelRestaurante res = r.get(i);
			return res.getRestaurante_thumbnail();
		}
	}

	public String carregarEndereco(int i) {
		if (r.size() == 0) {
			return "";
		} else {
			ModelRestaurante res = r.get(i);
			return res.getRestaurante_endereco();
		}
	}
}
