package view.usuario.pedido;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerIngrediente;
import controller.ControllerItensPedido;
import controller.ControllerPedido;
import controller.ControllerUsuario;
import model.ModelIngrediente;
import model.ModelItensPedido;
import model.ModelPedido;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.ViewIndex;

public class ViewProduto extends JFrame {

	int obs_posicao = 0;

	ModelUsuario usuario = new ModelUsuario();
	ModelRestaurante restaurante = new ModelRestaurante();
	ModelProduto produto = new ModelProduto();
	ModelItensPedido itensPedido = new ModelItensPedido();

	ControllerIngrediente ci = new ControllerIngrediente();
	ControllerItensPedido cip = new ControllerItensPedido();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
	}

	public ViewProduto(ModelProduto pr, ModelRestaurante r, ModelUsuario u) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewProduto.class.getResource("/img/logo/logo (64x64).png")));
		usuario = u;
		restaurante = r;
		produto = pr;

		int yproduto = 40;
		List<ModelIngrediente> ingredientes = new ArrayList<ModelIngrediente>();
		ingredientes = ci.carregarIngredientes(produto.getProduto_id());

		String[] observacao = new String[50];
		for (int i = 0; i < 50; i++) {
			if (i >= ingredientes.size()) {
				observacao[i] = "";
			} else {
				observacao[i] = ingredientes.get(i).getIngrediente_descricao();
			}

		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle(produto.getProduto_nome());
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 414, 100);
		contentPane.add(panel);

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setOpaque(true);
		btnHome.setForeground(Color.WHITE);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(31, 18, 64, 64);
		panel.add(btnHome);

		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPerfil(usuario);
				dispose();
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(126, 18, 64, 64);
		panel.add(btnPerfil);

		JButton btnPedidos = new JButton("");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarPedidos(usuario);
				dispose();
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPedidos.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setOpaque(true);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setBounds(221, 18, 64, 64);
		panel.add(btnPedidos);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.addActionListener(new ActionListener() {
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
		btnCarrinho.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setOpaque(true);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBounds(316, 18, 64, 64);
		panel.add(btnCarrinho);

		JPanel painelProduto = new JPanel();
		painelProduto.setLayout(null);
		painelProduto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		painelProduto.setBackground(Color.WHITE);
		painelProduto.setBounds(0, 100, 414, 118);
		contentPane.add(painelProduto);

		JLabel imgProduto = new JLabel("");
		imgProduto.setBackground(Color.DARK_GRAY);
		imgProduto.setBounds(21, 20, 78, 78);
		imgProduto.setIcon(new ImageIcon(ViewRestaurante.class.getResource(produto.getProduto_thumbnail())));
		painelProduto.add(imgProduto);

		JLabel lblNome = new JLabel((String) null);
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNome.setBounds(124, 11, 232, 25);
		lblNome.setText(produto.getProduto_nome());
		painelProduto.add(lblNome);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBackground(new Color(51, 51, 51));
		separator.setBounds(124, 33, 232, 2);
		painelProduto.add(separator);

		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setText(produto.getProduto_descricao());
		txtDescricao.setRows(2);
		txtDescricao.setLineWrap(true);
		txtDescricao.setEditable(false);
		txtDescricao.setBackground(Color.WHITE);
		txtDescricao.setBounds(124, 47, 232, 54);
		painelProduto.add(txtDescricao);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 217, 414, 505);
		scrollPane.setPreferredSize(new Dimension(414, 414));

		JPanel viewport = new JPanel();
		viewport.setLayout(null);
		viewport.setBounds(0, 0, 414, 505);

		JLabel tipo = new JLabel();
		tipo.setName("ingredientes");
		tipo.setText("Ingredientes");
		tipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tipo.setBounds(10, 11, 375, 22);
		viewport.add(tipo);

		JSeparator separadortipo = new JSeparator();
		separadortipo.setForeground(Color.BLACK);
		separadortipo.setBounds(10, 37, 375, 2);
		separadortipo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		viewport.add(separadortipo);

		for (int x = 0; x < ingredientes.size(); x++) {

			ModelIngrediente i = ingredientes.get(x);

			JPanel ingrediente = new JPanel();
			ingrediente.setName("ingrediente_" + x);
			ingrediente.setBounds(10, yproduto, 200, 30); // 375
			ingrediente.setLayout(null);

			JLabel titulo = new JLabel();
			titulo.setName("ingrediente_" + x + "_titulo");
			titulo.setText(i.getIngrediente_descricao());
			titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			titulo.setBounds(50, 11, 250, 20);

			JCheckBox desejado = new JCheckBox("");
			desejado.setName(i.getIngrediente_descricao());
			desejado.setBounds(20, 11, 20, 20);
			desejado.setSelected(true);
			desejado.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					if (desejado.isSelected()) {
						for (int i = 0; i <= observacao.length + 1; i++) {
							if (observacao[i].equals("")) {
								observacao[i] = desejado.getName();
								break;
							}
						}
					} else {
						String rejeitado = "";
						rejeitado = desejado.getName();
						int posicao = 0;

						for (int z = 0; z < observacao.length; z++) {
							if (observacao[z].equals(rejeitado)) {
								posicao = z;
								break;
							}
						}

						for (int x = posicao; x < observacao.length; x++) {
							if (!observacao[x].equals("") && !observacao[x].equals(null)) {
								observacao[x] = observacao[x + 1];
							}
						}
					}

				}
			});

			ingrediente.add(desejado);
			ingrediente.add(titulo);

			viewport.add(ingrediente);
			yproduto += 40;

			if (x == ingredientes.size() - 1) {
				JLabel lblNext = new JLabel("");
				lblNext.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {

						ModelPedido pe = new ModelPedido();
						ControllerPedido cpe = new ControllerPedido();

						pe.setUsuario_id(usuario.getUsuario_id());
						pe.setValorTotal(produto.getProduto_valor());
						Date data = new Date();
						pe.setPedido_data(data);

						boolean outros = cpe.verificarOutrosPedidos(usuario.getUsuario_id(),
								restaurante.getRestaurante_id());

						if (outros) {
							JOptionPane.showMessageDialog(null,
									"Opa! Parece que você tem um pedido em aberto com outro restaurante.",
									"Pedido em Aberto", JOptionPane.WARNING_MESSAGE);
						} else {
							boolean aberto = cpe.verificarPedidoAberto(usuario.getUsuario_id(),
									restaurante.getRestaurante_id());

							if (!aberto) {
								cpe.cadastrarPedido(pe);
							} else {
								pe = cpe.selecionarPedidoAberto(usuario.getUsuario_id(),
										restaurante.getRestaurante_id());
							}

							cip.cadastrarItensPedidoNull(pr, observacao);
							cpe.carregarViewAdicionais(u, pe, produto, restaurante, observacao);
							dispose();

						}
					}

				});
				lblNext.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/next (32x32).png")));
				lblNext.setBounds(330, yproduto, 32, 32);
				viewport.add(lblNext);
			}
		}
		yproduto += 20 + 32;

		viewport.setPreferredSize(new Dimension(414, yproduto));
		scrollPane.setViewportView(viewport);
		contentPane.add(scrollPane);
	}

}
