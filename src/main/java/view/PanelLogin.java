package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import controlador.AppVideo;

public class PanelLogin extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel marco = new JPanel();
	private JPanel contenedor = new JPanel();
	private JPanel bienvenido = new JPanel();
	private JTextField textField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel username;
	private JLabel password;
	private JPanel userInfo = new JPanel();
	private JPanel userInfo_1 = new JPanel();
	private JButton aceptar;
	private JButton cancelar;
	private JPanel botones;
	//private AppVideo appVideo = AppVideo.getUnicaInstancia();

	public PanelLogin() {

		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(450, 450));

		contenedor.setBackground(UIManager.getColor("Button.background"));
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));

		bienvenido.setBackground(SystemColor.controlHighlight);
		JLabel welcome = new JLabel("WELCOME!", SwingConstants.CENTER);
		welcome.setFont(new Font("Cambria", Font.BOLD, 26));
		welcome.setBackground(Color.BLACK);
		bienvenido.add(welcome);

		username = new JLabel("Username: ", SwingConstants.RIGHT);
		username.setBackground(SystemColor.controlHighlight);
		username.setFont(new Font("Cambria", Font.BOLD, 17));
		password = new JLabel("Password: ", SwingConstants.RIGHT);
		password.setBackground(SystemColor.controlHighlight);
		password.setFont(new Font("Cambria", Font.BOLD, 17));

		userInfo.setLayout(new GridLayout(1, 2));
		userInfo.add(username);
		userInfo.add(textField);
		textField.setColumns(10);

		userInfo_1.setLayout(new GridLayout(1, 2));
		userInfo_1.add(password);
		userInfo_1.add(passwordField);
		passwordField.setColumns(10);

		aceptar = new JButton("Accept");
		aceptar.addActionListener(this);
		aceptar.setFont(new Font("Verdana", Font.BOLD, 13));

		cancelar = new JButton("Reset");
		cancelar.addActionListener(this);
		cancelar.setFont(new Font("Verdana", Font.BOLD, 13));

		botones = new JPanel();
		botones.setBackground(UIManager.getColor("Button.background"));
		botones.add(aceptar);
		botones.add(Box.createRigidArea(new Dimension(200, 200)));
		botones.add(cancelar);
		botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));

		contenedor.add(Box.createRigidArea(new Dimension(60, 30)));
		contenedor.add(bienvenido);
		contenedor.add(Box.createRigidArea(new Dimension(60, 30)));
		contenedor.add(userInfo);
		contenedor.add(userInfo_1);
		contenedor.add(botones);

		marco.add(contenedor);
		this.add(marco);
		this.setBackground(Color.GRAY);

	}


	//@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == aceptar) {
			if (appVideo.login(textField.getText(), passwordField.getText()) == false) {
				JOptionPane.showMessageDialog(PanelLogin.this, "Username or password fields are incorrect", "Login process failed", JOptionPane.CLOSED_OPTION);
			}
		} */ 
		if (e.getSource() == cancelar) {
			textField.setText("");
			passwordField.setText("");
		}
	}
}
