package view.usuario.pedido;

import java.awt.Color;
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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.ControllerPedido;
import controller.ControllerUsuario;
import model.ModelPedido;
import model.ModelUsuario;

public class ViewPagamento extends JFrame {

	private static final long serialVersionUID = 1L;

	ControllerUsuario cu = new ControllerUsuario();
	ControllerPedido cp = new ControllerPedido();
	ModelPedido p = new ModelPedido();
	ModelUsuario u = new ModelUsuario();

	private JPanel contentPane;

	public static void main(String[] args) {

	}

	public ViewPagamento(ModelUsuario usuario, ModelPedido pedido) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ViewPagamento.class.getResource("/img/logo/logo (64x64).png")));
		setTitle("Pagamento");

		p = pedido;
		u = usuario;

		List<Integer> pagamentos = new ArrayList<Integer>();
		pagamentos = cp.pagamentosRestaurante(p);
		int numPagamentos = pagamentos.size();

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnHome.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/home (64x64).png")));
		btnHome.setOpaque(true);
		btnHome.setForeground(Color.WHITE);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(31, 18, 64, 64);
		panel.add(btnHome);

		JButton btnPerfil = new JButton("");
		btnPerfil.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/profile (64x64).png")));
		btnPerfil.setOpaque(true);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(126, 18, 64, 64);
		panel.add(btnPerfil);

		JButton btnPedidos = new JButton("");
		btnPedidos.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/list (64x64).png")));
		btnPedidos.setOpaque(true);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setBounds(221, 18, 64, 64);
		panel.add(btnPedidos);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/cart (64x64).png")));
		btnCarrinho.setOpaque(true);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.setContentAreaFilled(false);
		btnCarrinho.setBorderPainted(false);
		btnCarrinho.setBounds(316, 18, 64, 64);
		panel.add(btnCarrinho);

		for (int i = 0; i < numPagamentos; i++) {
			System.out.println(pagamentos.get(i));
			if (pagamentos.get(i) == 1) {
				JLabel lblDinner = new JLabel("");
				lblDinner.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						if (pedido.getPagamento_id() == 1) {
							lblDinner.setBorder(null);
						}
						pedido.setPagamento_id(1);
						lblDinner.setBorder(
								new EtchedBorder(EtchedBorder.LOWERED, (new Color(0, 188, 34)), Color.WHITE));
					}
				});
				lblDinner.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_diners.png")));
				lblDinner.setBounds(137, 205, 50, 35);
				contentPane.add(lblDinner);
			}

			if (pagamentos.get(i) == 2) {
				JLabel lblElo = new JLabel("");
				lblElo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						if (pedido.getPagamento_id() == 2) {
							lblElo.setBorder(null);
						}
						pedido.setPagamento_id(2);
						lblElo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, (new Color(0, 188, 34)), Color.WHITE));
					}
				});
				lblElo.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_elo.png")));
				lblElo.setBounds(228, 205, 50, 35);
				contentPane.add(lblElo);
			}

			if (pagamentos.get(i) == 3) {
				JLabel lblMaster = new JLabel("");
				lblMaster.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						if (pedido.getPagamento_id() == 3) {
							lblMaster.setBorder(null);
						}
						pedido.setPagamento_id(3);
						lblMaster.setBorder(
								new EtchedBorder(EtchedBorder.LOWERED, (new Color(0, 188, 34)), Color.WHITE));

					}
				});
				lblMaster.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_master.png")));
				lblMaster.setBounds(319, 205, 50, 35);
				contentPane.add(lblMaster);
			}

			if (pagamentos.get(i) == 4) {
				JLabel lblVisa = new JLabel("");
				lblVisa.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						if (pedido.getPagamento_id() == 4) {
							lblVisa.setBorder(null);
						}
						pedido.setPagamento_id(4);
						lblVisa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, (new Color(0, 188, 34)), Color.WHITE));
					}
				});
				lblVisa.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_visa.png")));
				lblVisa.setBounds(46, 205, 50, 35);
				contentPane.add(lblVisa);
			}

			if (pagamentos.get(i) == 5) {
				JLabel lblDinheiro = new JLabel("");
				lblDinheiro.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						if (pedido.getPagamento_id() == 5) {
							lblDinheiro.setBorder(null);
						}
						pedido.setPagamento_id(5);
						lblDinheiro.setBorder(
								new EtchedBorder(EtchedBorder.LOWERED, (new Color(0, 188, 34)), Color.WHITE));
					}
				});
				lblDinheiro.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/money.png")));
				lblDinheiro.setBounds(175, 286, 64, 64);
				contentPane.add(lblDinheiro);
			}
		}

		JLabel lblFormaPagamento = new JLabel();
		lblFormaPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormaPagamento.setText("Quase l\u00E1! Selecione sua forma de pagamento");
		lblFormaPagamento.setName("ingredientes");
		lblFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFormaPagamento.setBounds(10, 142, 394, 22);
		contentPane.add(lblFormaPagamento);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		separator.setBounds(10, 167, 394, 2);
		contentPane.add(separator);

		JButton btnFinalizar = new JButton("FINALIZAR MEU PEDIDO");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja finalizar seu pedido?", "Confirmação",
						dialogButton);
				if (dialogResult == 0) {
					JOptionPane.showMessageDialog(null,
							"Pedido realizado com sucesso! \nVocê poderá acompanhar seu status na aba de pedidos!",
							"Confirmação", JOptionPane.INFORMATION_MESSAGE);
					cp.atualizarPedido(pedido);

					// Atualiza status para confirmado.
					cp.atualizarStatus(pedido, 2);

					cu.carregarPedidos(usuario);
					dispose();
				} else {
					//
				}

			}
		});
		btnFinalizar.setBounds(46, 392, 318, 38);
		btnFinalizar.setOpaque(true);
		btnFinalizar.setBackground(new Color(0, 188, 34));
		btnFinalizar.setContentAreaFilled(true);
		btnFinalizar.setBorderPainted(true);
		contentPane.add(btnFinalizar);
	}
}
