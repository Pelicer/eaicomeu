package view.usuario;

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

import controller.ControllerEntrega;
import controller.ControllerItensPedido;
import controller.ControllerPedido;
import controller.ControllerProduto;
import controller.ControllerRestaurante;
import controller.ControllerStatus;
import controller.ControllerUsuario;
import model.ModelItensPedido;
import model.ModelPedido;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelUsuario;

public class ViewCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel viewport;

	ControllerPedido cped = new ControllerPedido();
	ControllerProduto cprod = new ControllerProduto();
	ControllerItensPedido cip = new ControllerItensPedido();
	ControllerUsuario cuser = new ControllerUsuario();
	ControllerRestaurante cr = new ControllerRestaurante();

	ModelItensPedido itensPedido = new ModelItensPedido();
	ModelUsuario usuario = new ModelUsuario();
	ModelPedido pedido = new ModelPedido();
	ModelProduto produto = new ModelProduto();
	ModelRestaurante restaurante = new ModelRestaurante();

	List<ModelItensPedido> itens_encapsulado = new ArrayList<ModelItensPedido>();
	List<ModelItensPedido> itens;
	ModelItensPedido i;
	int yproduto;

	public ViewCarrinho(ModelUsuario u, ModelPedido p) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ViewCarrinho.class.getResource("/img/logo/logo (64x64).png")));
		usuario = u;
		pedido = p;

		itens = new ArrayList<ModelItensPedido>();
		itens = cip.carregarCarrinho(p.getPedido_id());
		itens_encapsulado = itens;

		if (!itens.isEmpty()) {
			itensPedido = itens.get(0);
			produto = cprod.selecionarProduto(itensPedido.getProduto_id());
			restaurante = cr.selecionarRestauranteID(produto.getRestaurante_id());
		}

		setResizable(false);
		setTitle("Meu carrinho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			public void actionPerformed(ActionEvent e) {
				ControllerUsuario cu = new ControllerUsuario();
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(ViewCarrinho.class.getResource("/img/icon/home (64x64).png")));
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
				usuario = cu.selecionarUsuarioID(u.getUsuario_id());
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewCarrinho.class.getResource("/img/icon/profile (64x64).png")));
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
		btnPedidos.setIcon(new ImageIcon(ViewCarrinho.class.getResource("/img/icon/list (64x64).png")));
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
		btnCarrinho.setIcon(new ImageIcon(ViewCarrinho.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setOpaque(true);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBounds(316, 18, 64, 64);
		panel.add(btnCarrinho);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(414, 414));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 100, 414, 621);
		contentPane.add(scrollPane);

		viewport = new JPanel();
		viewport.setLayout(null);
		viewport.setPreferredSize(new Dimension(414, 52));
		scrollPane.setViewportView(viewport);

		if (itens.isEmpty()) {
			JLabel lblTitulo = new JLabel();
			lblTitulo.setText("Seu carrinho está vazio.");
			lblTitulo.setName("titulo");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTitulo.setBounds(10, 11, 375, 22);
			viewport.add(lblTitulo);
		} else {
			JLabel lblTitulo = new JLabel();
			lblTitulo.setText("Seu pedido em: " + restaurante.getRestaurante_razaosocial());
			lblTitulo.setName("titulo");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTitulo.setBounds(10, 11, 375, 22);
			viewport.add(lblTitulo);
		}

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator.setBounds(10, 37, 375, 2);
		viewport.add(separator);

		yproduto = 60;

		atualizarItens();

		yproduto += 20 + 32;

		viewport.setPreferredSize(new Dimension(414, yproduto));
		scrollPane.setViewportView(viewport);
		contentPane.add(scrollPane);
	}

	public void cancelarItem() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja excluir este produto do seu carrinho?",
				"Confirmação", dialogButton);
		if (dialogResult == 0) {
			cip.excluirItem(i);
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.", "Confirmação",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			//
		}
	}

	public void atualizarItens() {
		for (int x = 0; x < itens.size(); x++) {

			i = itens.get(x);
			ModelProduto prod = new ModelProduto();
			prod = cprod.selecionarProduto(i.getProduto_id());

			JPanel item = new JPanel();
			item.setName("item_" + i);
			item.setBounds(10, yproduto, 375, 93);
			item.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.BLACK));
			item.setBackground(Color.WHITE);
			item.setLayout(null);

			JLabel cancel = new JLabel();
			cancel.setName("cancel_" + i + "_");
			cancel.setIcon(new ImageIcon(ViewCarrinho.class.getResource("/img/icon/cancel(16px).png")));
			cancel.setBounds(349, 11, 16, 16);
			cancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					cancelarItem();
					reiniciarTela();
				}
			});
			item.add(cancel);

			JLabel thumbnail = new JLabel();
			thumbnail.setName("item_" + i + "_thumbnail");
			thumbnail.setIcon(new ImageIcon(ViewCarrinho.class.getResource(prod.getProduto_thumbnail())));
			thumbnail.setBounds(10, 11, 78, 71);
			item.add(thumbnail);

			JLabel titulo = new JLabel();
			titulo.setName("item_" + i + "_nome");
			titulo.setText(prod.getProduto_nome());
			titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			titulo.setBounds(98, 11, 250, 20);
			item.add(titulo);

			JTextArea descricao = new JTextArea();
			descricao.setName("item_" + i + "_descricao");
			descricao.setText(prod.getProduto_descricao());
			descricao.setLineWrap(true);
			descricao.setEditable(false);
			descricao.setRows(2);
			descricao.setBounds(98, 30, 250, 30);
			item.add(descricao);

			String valor = String.format("%.2f", prod.getProduto_valor());

			JLabel preco = new JLabel();
			preco.setName("item_" + i + "_valor");
			preco.setText("R$" + valor);
			preco.setBounds(98, 57, 250, 30);
			item.add(preco);

			viewport.add(item);
			yproduto += 111;

			if (x == itens.size() - 1) {

				JButton btnLimparCarrinho = new JButton("LIMPAR CARRINHO");
				btnLimparCarrinho.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null,
								"Tem certeza de que deseja limpar seu carrinho? Isso limpará todos os produtos.",
								"Confirmação", dialogButton);
						if (dialogResult == 0) {
							cip.limparCarrinho(pedido.getPedido_id());
							JOptionPane.showMessageDialog(null, "Carrinho limpo com sucesso.", "Confirmação",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							//
						}
					}
				});

				btnLimparCarrinho.setForeground(Color.RED);
				btnLimparCarrinho.setOpaque(true);
				btnLimparCarrinho.setContentAreaFilled(false);
				btnLimparCarrinho.setBorderPainted(true);
				btnLimparCarrinho.setBounds(10, yproduto + 5, 160, 23);
				viewport.add(btnLimparCarrinho);

				String valorTotal = String.format("%.2f", pedido.getValorTotal());

				JLabel total = new JLabel("");
				total.setFont(new Font("Tahoma", Font.BOLD, 16));
				total.setText("Total: R$ " + valorTotal);
				total.setForeground(Color.BLACK);
				total.setBounds(180, yproduto, 150, 32);
				viewport.add(total);

				JLabel lblPagar = new JLabel("");
				lblPagar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						ControllerEntrega ce = new ControllerEntrega();
						ControllerStatus cs = new ControllerStatus();
						cs.cadastrarStatusUpdate(pedido, 2);
						cs.atualizarStatus(pedido, 3);
						cs.cadastrarStatusUpdate(pedido, 3);
						ce.carregarViewEntrega(usuario, pedido);
						dispose();
					}
				});
				lblPagar.setIcon(new ImageIcon(ViewIndex.class.getResource("/img/icon/next (32x32).png")));
				lblPagar.setBounds(330, yproduto, 32, 32);
				viewport.add(lblPagar);
			}
		}
	}

	public void reiniciarTela() {
		this.dispose();
		pedido = cped.selecionarUltimaEntrada();
		cped.carregarViewCarrinho(usuario, pedido);
	}
}