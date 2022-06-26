package view;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

//import controlador.AppVideo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.time.LocalDate;
//import java.time.ZoneId;

public class PanelRegistro extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoCorreo;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private JButton aceptar;
	private JButton cancelar;
	private JDateChooser dateChooser;
	//private AppVideo appVideo = AppVideo.getUnicaInstancia();

	public PanelRegistro() {

		JPanel marco = new JPanel();
		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(450, 450));

		JPanel contenedor = new JPanel();
		contenedor.setBackground(UIManager.getColor("Button.background"));
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));

		JPanel registro = new JPanel();
		registro.setBackground(SystemColor.controlHighlight);
		JLabel signUp = new JLabel("SIGN UP", SwingConstants.CENTER);
		signUp.setFont(new Font("Cambria", Font.BOLD, 20));
		signUp.setBackground(Color.BLACK);
		registro.add(signUp);

		textField = new JTextField();
		passwordField = new JPasswordField();
		passwordField2 = new JPasswordField();

		JLabel username = new JLabel("*Username: ", SwingConstants.RIGHT);
		username.setBackground(SystemColor.controlHighlight);
		username.setFont(new Font("Cambria", Font.BOLD, 15));

		JLabel password = new JLabel("*Choose password: ", SwingConstants.RIGHT);
		password.setBackground(SystemColor.controlHighlight);
		password.setFont(new Font("Cambria", Font.BOLD, 15));

		JLabel passwordRep = new JLabel("*Repeat password: ", SwingConstants.RIGHT);
		passwordRep.setBackground(SystemColor.controlHighlight);
		passwordRep.setFont(new Font("Cambria", Font.BOLD, 15));

		campoNombre = new JTextField();
		campoApellido = new JTextField();
		campoCorreo = new JTextField();

		JLabel name = new JLabel("*Name: ", SwingConstants.RIGHT);
		name.setBackground(SystemColor.controlHighlight);
		name.setFont(new Font("Cambria", Font.BOLD, 14));

		JLabel surname = new JLabel("Surname: ", SwingConstants.RIGHT);
		surname.setBackground(SystemColor.controlHighlight);
		surname.setFont(new Font("Cambria", Font.BOLD, 14));

		JLabel birth = new JLabel("Date of brith: ", SwingConstants.RIGHT);
		birth.setBackground(SystemColor.controlHighlight);
		birth.setFont(new Font("Cambria", Font.BOLD, 14));

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");

		JLabel email = new JLabel("E-mail: ", SwingConstants.RIGHT);
		email.setBackground(SystemColor.controlHighlight);
		email.setFont(new Font("Cambria", Font.BOLD, 14));

		JLabel compulsory = new JLabel("*: Required fields", SwingConstants.CENTER);
		compulsory.setBackground(Color.GRAY);
		compulsory.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));

		JLabel calendar = new JLabel("*Date of birth: ", SwingConstants.RIGHT);
		calendar.setBackground(SystemColor.controlHighlight);
		calendar.setFont(new Font("Cambria", Font.BOLD, 14));

		aceptar = new JButton("Accept");
		aceptar.setFont(new Font("Verdana", Font.BOLD, 14));
		aceptar.addActionListener(this);

		cancelar = new JButton("Reset");
		cancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		cancelar.addActionListener(this);

		JPanel userInfo = new JPanel();
		userInfo.setLayout(new GridLayout(1, 2));
		userInfo.add(username);
		userInfo.add(textField);
		textField.setColumns(10);

		JPanel contrasena = new JPanel();
		contrasena.setLayout(new GridLayout(1, 2));
		contrasena.add(password);
		contrasena.add(passwordField);
		textField.setColumns(10);

		JPanel contrasenaRep = new JPanel();
		contrasenaRep.setLayout(new GridLayout(1, 2));
		contrasenaRep.add(passwordRep);
		contrasenaRep.add(passwordField2);
		textField.setColumns(10);

		JPanel nombre = new JPanel();
		nombre.setLayout(new GridLayout(1, 2));
		nombre.add(name);
		nombre.add(campoNombre);
		campoNombre.setColumns(10);

		JPanel apellido = new JPanel();
		apellido.setLayout(new GridLayout(1, 2));
		apellido.add(surname);
		apellido.add(campoApellido);
		campoApellido.setColumns(10);

		JPanel calendario = new JPanel();
		calendario.setLayout(new GridLayout(1, 2));
		calendario.add(calendar);
		calendario.add(dateChooser);

		JPanel correo = new JPanel();
		correo.setLayout(new GridLayout(1, 2));
		correo.add(email);
		correo.add(campoCorreo);
		campoCorreo.setColumns(10);

		JPanel obligatorio = new JPanel();
		obligatorio.setLayout(new GridLayout(1, 2));
		obligatorio.add(compulsory);

		JPanel botones = new JPanel();
		botones.setBackground(UIManager.getColor("Button.background"));
		botones.add(aceptar);
		botones.add(Box.createRigidArea(new Dimension(180, 20)));
		botones.add(cancelar);
		botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));

		contenedor.add(Box.createRigidArea(new Dimension(30, 30)));
		contenedor.add(registro);
		contenedor.add(Box.createRigidArea(new Dimension(30, 50)));
		contenedor.add(nombre);
		contenedor.add(apellido);
		contenedor.add(calendario);
		contenedor.add(correo);
		contenedor.add(Box.createRigidArea(new Dimension(30, 30)));
		contenedor.add(userInfo);
		contenedor.add(contrasena);
		contenedor.add(contrasenaRep);
		contenedor.add(Box.createRigidArea(new Dimension(30, 15)));
		contenedor.add(obligatorio);
		contenedor.add(Box.createRigidArea(new Dimension(30, 40)));
		contenedor.add(botones);

		marco.add(contenedor);
		this.add(marco);
		this.setBackground(Color.GRAY);

	}


	//@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * if (e.getSource() == aceptar) {
			LocalDate fechaNac = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (appVideo.registrarUsuario(campoNombre.getText(), campoApellido.getText(), campoCorreo.getText(),
					textField.getText(), passwordField.getText(), passwordField2.getText(), fechaNac) == false) {
				JOptionPane.showMessageDialog(PanelRegistro.this, "Username already exists or passwords fields do not match", "Sign Up process failed",
			    JOptionPane.CLOSED_OPTION);
			}
			else {
				JOptionPane.showMessageDialog(PanelRegistro.this, "You did it! Click LOGIN to start using AppVideo", "Sign Up process success",
				JOptionPane.CLOSED_OPTION);
			}
		} else */
		if (e.getSource() == this.cancelar) {
			textField.setText("");
			passwordField.setText("");
			passwordField2.setText("");
			campoNombre.setText("");
			campoApellido.setText("");
			campoCorreo.setText("");
		} 

	}

}
