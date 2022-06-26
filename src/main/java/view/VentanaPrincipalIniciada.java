package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventObject;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import controlador.AppVideo;
import pulsador.IEncendidoListener;
import pulsador.Luz;

public class VentanaPrincipalIniciada extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTabbedPane opciones;
	private JPanel explorar;
	private JPanel listas;
	private JPanel nuevaLista;
	private JPanel recientes;
	private JPanel panel;
	private JLabel logo;
	private JPanel panel_1;
	private JButton premium;
	private JButton logOut;
	private Luz luz = new Luz();
	private AppVideo appVideo =  AppVideo.getUnicaInstancia();
	private PanelExplorar explore = new PanelExplorar();
	private PanelMisListas playlists = new PanelMisListas();
	private PanelNuevaLista newPlaylist = new PanelNuevaLista();
	private PanelRecientes recents = new PanelRecientes();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalIniciada window = new VentanaPrincipalIniciada();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipalIniciada() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame("Welcome to AppVideo");
		frame.setBounds(100, 100, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		opciones = new JTabbedPane(JTabbedPane.TOP);
		opciones.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		opciones.setBackground(SystemColor.control);

		explorar = explore;
		explorar.setFont(new Font("Cambria", Font.PLAIN, 22));

		listas = playlists;
		listas.setFont(new Font("Cambria", Font.PLAIN, 22));

		nuevaLista = newPlaylist;
		nuevaLista.setFont(new Font("Cambria", Font.PLAIN, 22));

		recientes = recents;
		recientes.setFont(new Font("Cambria", Font.PLAIN, 22));

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		logo = new JLabel("AppVideo");
		logo.setFont(new Font("Cambria", Font.BOLD, 60));
		logo.setForeground(Color.BLACK);
		panel.add(logo);

		panel.add(Box.createRigidArea(new Dimension(220, 130)));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_1 = new JPanel();
		panel.add(panel_1);
		luz.setForeground(SystemColor.textHighlight);
		luz.setColor(SystemColor.textHighlight);
		luz.addEncendidoListener(new IEncendidoListener() {
			@Override
			public void enteradoCambioEncendido(EventObject e) {

				JFileChooser archivoXML = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = archivoXML.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = archivoXML.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
				}
			}
		});
		panel_1.add(luz);
		panel.add(Box.createRigidArea(new Dimension(1, 5)));

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

		opciones.addTab("Explore", null, explorar, "Descubrir");
		opciones.addTab("Created playlists", null, listas, "Listas creadas");
		opciones.addTab("New playlist", null, nuevaLista, "Crear lista");
		opciones.addTab("Recents", null, recientes, "Videos recientes");
		frame.getContentPane().add(opciones);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == premium) {
			appVideo.mejorarCuenta(appVideo.getUsuarioActual());
			JOptionPane.showMessageDialog(VentanaPrincipalIniciada.this, "Congrats! Your account is now premium", "Premium account", JOptionPane.CLOSED_OPTION);
		}
		else if (e.getSource() == logOut) {
			
		}
	}
}
