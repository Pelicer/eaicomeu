package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControllerLogin;
import controller.ControllerUsuario;

public class ViewReenvio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;

	public ViewReenvio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ControllerLogin cl = new ControllerLogin();
				cl.carregarLogin();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewReenvio.class.getResource("/img/logo/logo (64x64).png")));
		setTitle("Recupera\u00E7\u00E3o de Senha");
		setResizable(false);
		setBounds(100, 100, 420, 750);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel imgLogo = new JLabel("");
		imgLogo.setIcon(new ImageIcon(ViewReenvio.class.getResource("/img/logo/logo-medium.png")));
		imgLogo.setBounds(10, 95, 379, 75);
		contentPane.add(imgLogo);

		JLabel lblInsiraSeuEmail = new JLabel("Insira seu e-mail, te enviaremos um e-mail para recupera\u00E7\u00E3o!");
		lblInsiraSeuEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblInsiraSeuEmail.setForeground(Color.WHITE);
		lblInsiraSeuEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblInsiraSeuEmail.setBounds(39, 244, 350, 40);
		contentPane.add(lblInsiraSeuEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					boolean recuperado = false;
					ControllerUsuario cu = new ControllerUsuario();
					recuperado = cu.recuperarSenha(txtEmail.getText());

					if (recuperado) {
						JOptionPane.showMessageDialog(null,
								"Um e-mail com as informa��es sobre a recupera��o da conta foi enviado � voc�.",
								"E-Mail enviado", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		txtEmail.setBounds(39, 295, 331, 30);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnRecuperar = new JButton("RECUPERAR");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean recuperado = false;
				ControllerUsuario cu = new ControllerUsuario();
				recuperado = cu.recuperarSenha(txtEmail.getText());

				if (recuperado) {
					JOptionPane.showMessageDialog(null,
							"Um e-mail com as informa��es sobre a recupera��o da conta foi enviado � voc�.",
							"E-Mail enviado", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnRecuperar.setOpaque(true);
		btnRecuperar.setContentAreaFilled(false);
		btnRecuperar.setBorderPainted(true);
		btnRecuperar.setForeground(Color.WHITE);
		btnRecuperar.setBounds(39, 336, 115, 23);
		contentPane.add(btnRecuperar);

	}
}
