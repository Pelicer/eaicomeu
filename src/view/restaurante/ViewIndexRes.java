package view.restaurante;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ModelRestaurante;
import java.awt.Toolkit;

public class ViewIndexRes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewIndexRes(ModelRestaurante r) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewIndexRes.class.getResource("/img/logo/logo (16x16).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
