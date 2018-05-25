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
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import controller.ControllerRestaurante;
import controller.ControllerUsuario;
import model.ModelIngrediente;
import model.ModelItensPedido;
import model.ModelPedido;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelUsuario;
import view.usuario.ViewIndex;

public class ViewAdicionais extends JFrame {

	int adc_posicao = 0;
	String[] observacao = new String[50];

	ModelUsuario u = new ModelUsuario();
	ModelPedido pe = new ModelPedido();
	ModelProduto pr = new ModelProduto();
	ModelItensPedido ip = new ModelItensPedido();
	ModelRestaurante r = new ModelRestaurante();

	ControllerUsuario cu = new ControllerUsuario();
	ControllerPedido cp = new ControllerPedido();
	ControllerIngrediente ci = new ControllerIngrediente();
	ControllerItensPedido cip = new ControllerItensPedido();
	ControllerRestaurante cr = new ControllerRestaurante();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {

	}

	public ViewAdicionais(ModelUsuario usuario, ModelPedido pedido, ModelProduto produto, ModelRestaurante restaurante,
			String[] obs) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ViewAdicionais.class.getResource("/img/logo/logo (64x64).png")));
		u = usuario;
		pe = pedido;
		pr = produto;
		r = restaurante;
		observacao = obs;

		int yproduto = 40;
		List<ModelIngrediente> ingredientes = new ArrayList<ModelIngrediente>();
		ingredientes = ci.carregarAdicionais(produto.getRestaurante_id());

		String[] adicionais = new String[50];
		for (int i = 0; i < 50; i++) {
			adicionais[i] = "";
		}

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(pr.getProduto_nome());
		setBounds(100, 100, 420, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		btnHome.setIcon(new ImageIcon(ViewAdicionais.class.getResource("/img/icon/home (64x64).png")));
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
		btnPerfil.setIcon(new ImageIcon(ViewAdicionais.class.getResource("/img/icon/profile (64x64).png")));
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
				u = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPedidos.setIcon(new ImageIcon(ViewAdicionais.class.getResource("/img/icon/list (64x64).png")));
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
			}
		});
		btnCarrinho.setIcon(new ImageIcon(ViewAdicionais.class.getResource("/img/icon/cart (64x64).png")));
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
		imgProduto.setIcon(new ImageIcon(ViewRestaurante.class.getResource(pr.getProduto_thumbnail())));
		painelProduto.add(imgProduto);

		JLabel lblNome = new JLabel((String) null);
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNome.setBounds(124, 11, 232, 25);
		lblNome.setText(pr.getProduto_nome());
		painelProduto.add(lblNome);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBackground(new Color(51, 51, 51));
		separator.setBounds(124, 33, 232, 2);
		painelProduto.add(separator);

		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setText(pr.getProduto_descricao());
		txtDescricao.setRows(2);
		txtDescricao.setLineWrap(true);
		txtDescricao.setEditable(false);
		txtDescricao.setBackground(Color.WHITE);
		txtDescricao.setBounds(124, 47, 232, 54);
		painelProduto.add(txtDescricao);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(414, 414));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 217, 414, 505);
		contentPane.add(scrollPane);

		JPanel viewport = new JPanel();
		viewport.setLayout(null);
		viewport.setPreferredSize(new Dimension(414, 52));
		scrollPane.setViewportView(viewport);

		JLabel lblAdicionais = new JLabel();
		lblAdicionais.setText("Adicionais");
		lblAdicionais.setName("adicionais");
		lblAdicionais.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdicionais.setBounds(10, 11, 375, 22);
		viewport.add(lblAdicionais);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator_1.setBounds(10, 37, 375, 2);
		viewport.add(separator_1);

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
			desejado.setSelected(false);
			desejado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (desejado.isSelected()) {
						for (int i = 0; i < adicionais.length; i++) {
							if (adicionais[i].equals(desejado.getName())) {
								adicionais[i] = "";
								for (int j = i + 1; j < adicionais.length; j++) {
									adicionais[j - 1] = adicionais[j];
									i = adicionais.length;
								}
							}
						}

					} else {
						if (adicionais[adc_posicao].equals("")) {
							adicionais[adc_posicao] = desejado.getName();
						} else {
							adc_posicao++;
							adicionais[adc_posicao] = desejado.getName();
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

						pe = cp.selecionarUltimaEntrada();
						ip = cip.selecionarUltimaEntrada();
						cip.atualizarItensPedido(pe.getPedido_id(), adicionais, ip.getItensPedido_id());
						ip = cip.selecionarItensPedido(ip.getItensPedido_id());
						cp.carregarViewCarrinho(u, pe);
						dispose();
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
