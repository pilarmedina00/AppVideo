package view;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	private JLabel logo;
	private JButton login;
	private JButton signUp;
	private JButton premium;
	private JButton logOut;
	private PanelLogin panelLogin = new PanelLogin();
	private PanelRegistro registro = new PanelRegistro();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("AppVideo");
		frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		logo = new JLabel("AppVideo");
		logo.setFont(new Font("Cambria", Font.BOLD, 60));
		logo.setForeground(Color.BLACK);
		panel.add(logo);

		panel.add(Box.createRigidArea(new Dimension(220, 150)));

		login = new JButton("LOGIN");
		login.addActionListener(this);
		login.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel.add(login);
		panel.add(Box.createRigidArea(new Dimension(1, 5)));

		signUp = new JButton("SIGN UP");
		signUp.addActionListener(this);
		signUp.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(Box.createRigidArea(new Dimension(50, 5)));
		panel.add(signUp);

		premium = new JButton("PREMIUM");
		premium.setBackground(UIManager.getColor("activeCaption"));
		premium.addActionListener(this);
		premium.setForeground(SystemColor.textHighlight);
		premium.setFont(new Font("Verdana", Font.BOLD, 13));

		panel.add(premium);

		panel.add(Box.createRigidArea(new Dimension(50, 5)));
		
		logOut = new JButton("LOG OUT");
		logOut.addActionListener(this);
		logOut.setForeground(SystemColor.textInactiveText);
		logOut.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(logOut);
		
		frame.getContentPane().add(panelLogin);		

	}

	public void abrirRegistro() {
		frame.setContentPane(registro);
	}
	
	private void volverLogin() {
		frame.setContentPane(panelLogin);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signUp) {
			this.abrirRegistro();
		}
		else if (e.getSource() == login) {
			this.volverLogin();
		}
	}
}