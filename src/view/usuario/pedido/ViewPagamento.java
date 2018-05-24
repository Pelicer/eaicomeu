package view.usuario.pedido;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ModelPedido;
import javax.swing.JLabel;

public class ViewPagamento extends JFrame {

	private static final long serialVersionUID = 1L;

	ModelPedido p = new ModelPedido();

	private JPanel contentPane;

	public static void main(String[] args) {

	}

	public ViewPagamento(ModelPedido pedido) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ViewPagamento.class.getResource("/img/logo/logo (64x64).png")));
		setTitle("Pagamento");
		p = pedido;

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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_american.png")));
		label.setBounds(12, 241, 45, 30);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_boleto.png")));
		label_2.setBounds(126, 241, 45, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_diners.png")));
		label_3.setBounds(183, 241, 45, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_elo.png")));
		label_4.setBounds(240, 241, 45, 30);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_hiper.png")));
		label_5.setBounds(297, 241, 45, 30);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_master.png")));
		label_6.setBounds(354, 241, 45, 30);
		contentPane.add(label_6);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/icon/payment/band_visa.png")));
		label_9.setBounds(69, 241, 45, 30);
		contentPane.add(label_9);
	}
}
