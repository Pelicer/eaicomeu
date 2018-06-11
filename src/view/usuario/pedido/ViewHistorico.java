package view.usuario.pedido;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerItensPedido;
import controller.ControllerPagamento;
import controller.ControllerPedido;
import controller.ControllerProduto;
import controller.ControllerRestaurante;
import controller.ControllerStatus;
import controller.ControllerUsuario;
import model.ModelPagamento;
import model.ModelPedido;
import model.ModelProduto;
import model.ModelRestaurante;
import model.ModelStatus;
import model.ModelUsuario;
import view.usuario.ViewCarrinho;
import view.usuario.ViewPedido;

public class ViewHistorico extends JFrame {

	ControllerPedido cp = new ControllerPedido();
	ControllerStatus cs = new ControllerStatus();
	ControllerPagamento cpag = new ControllerPagamento();
	ControllerProduto cprod = new ControllerProduto();
	ControllerItensPedido cip = new ControllerItensPedido();
	ControllerUsuario cuser = new ControllerUsuario();
	ControllerRestaurante cr = new ControllerRestaurante();

	ModelPedido pedido = new ModelPedido();
	ModelStatus status = new ModelStatus();
	ModelPagamento pagamento = new ModelPagamento();
	ModelUsuario usuario = new ModelUsuario();
	ModelProduto produto = new ModelProduto();
	ModelRestaurante restaurante = new ModelRestaurante();

	List<ModelStatus> historico = new ArrayList<ModelStatus>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewHistorico(ModelUsuario u, ModelPedido p) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewPedido.class.getResource("/img/icon/list (64x64).png")));

		usuario = u;
		pedido = p;
		pagamento = cpag.selecionarPagamento(pedido.getPagamento_id());

		restaurante = cr.selecionarRestauranteID(cp.selecionarRestaurante(pedido));
		historico = cs.carregarStatusHistorico(pedido);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(pedido.getPedido_data());

		setTitle("Pedido do dia " + dataFormatada);
		setResizable(false);
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
		btnHome.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/home (64x64).png")));
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
				cu.carregarIndex(usuario.getUsuario_id());
				dispose();
			}
		});
		btnPerfil.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/profile (64x64).png")));
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
		btnPedidos.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/list (64x64).png")));
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
		btnCarrinho.setIcon(new ImageIcon(ViewPedido.class.getResource("/img/icon/cart (64x64).png")));
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

		JPanel viewport = new JPanel();
		viewport.setLayout(null);
		viewport.setPreferredSize(new Dimension(414, 52));
		scrollPane.setViewportView(viewport);

		JLabel lblTitulo = new JLabel();
		lblTitulo.setText(restaurante.getRestaurante_razaosocial());
		lblTitulo.setName("titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(10, 11, 375, 22);
		viewport.add(lblTitulo);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator.setBounds(10, 37, 394, 2);
		viewport.add(separator);

		int yproduto = 60;

		JPanel item = new JPanel();
		item.setName("pedido");
		item.setBounds(10, 60, 394, 548);
		item.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.BLACK));
		item.setBackground(Color.WHITE);
		item.setLayout(null);

		JLabel thumbnail = new JLabel();
		thumbnail.setName("pedido");
		thumbnail.setIcon(new ImageIcon(ViewCarrinho.class.getResource(restaurante.getRestaurante_thumbnail())));
		thumbnail.setBounds(10, 11, 78, 71);
		item.add(thumbnail);

		JLabel titulo = new JLabel();
		titulo.setName("pedido");
		titulo.setText("Pedido " + cs.statusDescricao(pedido.getStatus_id()));
		if (pedido.getStatus_id() == 6) {
			titulo.setForeground(new Color(90, 155, 82));
		}
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titulo.setBounds(98, 11, 250, 20);
		item.add(titulo);

		pagamento = cpag.selecionarPagamento(pedido.getPagamento_id());

		JLabel formaPagamento = new JLabel();
		formaPagamento.setName("formaPagamento");
		formaPagamento.setText(" • Pagamento por " + pagamento.getPagamento_descricao());
		if (pedido.getStatus_id() == 6) {
			titulo.setForeground(new Color(90, 155, 82));
		}
		formaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formaPagamento.setBounds(98, 60, 250, 20);
		item.add(formaPagamento);

		String entrega = cp.selecionarFormaEntrega(pedido);

		JLabel formaEntrega = new JLabel();
		formaEntrega.setName("formaEntrega");
		formaEntrega.setText(" • Forma de recebimento: " + entrega);
		if (pedido.getStatus_id() == 6) {
			titulo.setForeground(new Color(90, 155, 82));
		}
		formaEntrega.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formaEntrega.setBounds(98, 90, 250, 20);
		item.add(formaEntrega);

		JSeparator separator2 = new JSeparator();
		separator2.setForeground(Color.BLACK);
		separator2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator2.setBounds(10, 120, 375, 2);
		item.add(separator2);

		int ystatus = 140;

		for (int i = 0; i < historico.size(); i++) {

			status = historico.get(i);
			String statusDescricao = cs.statusDescricao(status.getStatus_id());

			JTextArea descricao = new JTextArea();
			descricao.setName("pedido");
			descricao.setText("• " + statusDescricao + " - " + status.getStatus_data_formatada());
			descricao.setLineWrap(true);
			descricao.setEditable(false);
			descricao.setRows(2);
			descricao.setBounds(30, ystatus, 360, 30);
			descricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			item.add(descricao);

			ystatus += 30;

		}

		String valor = String.format("%.2f", pedido.getValorTotal());

		JLabel preco = new JLabel();
		preco.setName("pedido");
		preco.setText("R$" + valor);
		preco.setBounds(98, ystatus + 30, 250, 30);
		item.add(preco);

		viewport.add(item);
		yproduto += 111;

		viewport.setPreferredSize(new Dimension(414, yproduto + ystatus));
		scrollPane.setViewportView(viewport);
		contentPane.add(scrollPane);
	}

}
