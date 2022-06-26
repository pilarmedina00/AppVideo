package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

//import controlador.AppVideo;
//import model.Video;

import java.awt.FlowLayout;
import java.awt.Component;

public class PanelNuevaLista extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	//private AppVideo appVideo = AppVideo.getUnicaInstancia();
	private JButton anadir;
	private JTextField busqueda2;
	
	public PanelNuevaLista() {
		
		JPanel marco = new JPanel();
		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(1040, 500));
		marco.setLayout(new BorderLayout()); 
		
		JPanel contenedorSup = new JPanel();
		contenedorSup.setBackground(UIManager.getColor("Button.background"));
		contenedorSup.setPreferredSize(new Dimension(400, 50));

		JPanel contenedorIzq = new JPanel();
		contenedorIzq.setBackground(UIManager.getColor("Button.background"));
		contenedorIzq.setPreferredSize(new Dimension(300, 600));
		
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBackground(UIManager.getColor("Button.background"));
		barraSuperior.setLayout(new BoxLayout(barraSuperior, BoxLayout.X_AXIS));
		
		JPanel buscarLista = new JPanel();
		buscarLista.setBackground(UIManager.getColor("Button.background"));
		buscarLista.setLayout(new BoxLayout(buscarLista, BoxLayout.X_AXIS));
		
		JPanel crearLista = new JPanel();
		crearLista.setBackground(UIManager.getColor("Button.background"));
		crearLista.setLayout(new BoxLayout(crearLista, BoxLayout.X_AXIS));
		
		anadir = new JButton("Add");
		anadir.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton quitar = new JButton("Remove");
		quitar.setFont(new Font("Verdana", Font.BOLD, 13));
		
		crearLista.add(anadir);
		crearLista.add(quitar);
		
		JTextField busqueda = new JTextField();
		busqueda.setFont(new Font("Verdana", Font.PLAIN, 14));
		busqueda.setColumns(45);
		
		JButton buscar = new JButton("Search");
		buscar.setFont(new Font("Verdana", Font.BOLD, 14));
				
		JButton limpiar = new JButton("Clean history");
		limpiar.setFont(new Font("Verdana", Font.BOLD, 14));
		
	    barraSuperior.add(Box.createRigidArea(new Dimension(100, 15)));
		barraSuperior.add(busqueda);
		barraSuperior.add(buscar);
		barraSuperior.add(Box.createRigidArea(new Dimension(30, 15)));
		barraSuperior.add(limpiar);
	    barraSuperior.add(Box.createRigidArea(new Dimension(100, 15)));
		
		JPanel barraIzquierda = new JPanel();
		barraIzquierda.setBackground(UIManager.getColor("Button.background"));
		barraIzquierda.setPreferredSize(new Dimension(280, 450));
		
		busqueda2 = new JTextField();
		busqueda2.setFont(new Font("Verdana", Font.PLAIN, 14));
		busqueda2.setColumns(12);
		
		JButton buscar2 = new JButton("Search");
		buscar2.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton eliminar = new JButton("Delete");
		eliminar.setFont(new Font("Verdana", Font.BOLD, 13));
			
		JTextArea textArea = new JTextArea(16, 20);
		textArea.setLineWrap(true);
		textArea.setTabSize(10);
		buscarLista.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		buscarLista.add(busqueda2);
		buscarLista.add(buscar2);
			
		JScrollPane listado = new JScrollPane(textArea);
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 14));
		barraIzquierda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lista = new JLabel("Enter playlist:", SwingConstants.LEFT);
		lista.setForeground(Color.DARK_GRAY);
		lista.setBackground(SystemColor.controlHighlight);
		lista.setFont(new Font("Verdana", Font.BOLD, 13));
		
		barraIzquierda.add(lista);	
		barraIzquierda.add(buscarLista);
		barraIzquierda.add(eliminar);
		barraIzquierda.add(listado);
		barraIzquierda.add(crearLista);
		Component rigidArea = Box.createRigidArea(new Dimension(30, 30));
		crearLista.add(rigidArea);
		
		JButton aceptar = new JButton("Accept");
		crearLista.add(aceptar);
		aceptar.setFont(new Font("Verdana", Font.BOLD, 13));

		JPanel contenedorResultados = new JPanel();
			
		JPanel listaVideos = new JPanel();
		listaVideos.setPreferredSize(new Dimension(680, 420));
		listaVideos.setLayout(new BoxLayout(listaVideos, BoxLayout.Y_AXIS));

		JTable tablaVideos = new JTable();
		tablaVideos.setBackground(UIManager.getColor("Button.light"));
		tablaVideos.setFillsViewportHeight(true);
		tablaVideos.setPreferredScrollableViewportSize(new Dimension(550, 500));
		 
		JScrollPane scrollPane = new JScrollPane(tablaVideos);
		listaVideos.add(scrollPane);
		
		contenedorResultados.add(listaVideos);
		contenedorSup.add(barraSuperior, BorderLayout.NORTH);
		contenedorIzq.add(barraIzquierda,  BorderLayout.WEST);
		
		marco.add(contenedorSup, BorderLayout.NORTH);
		marco.add(contenedorIzq, BorderLayout.WEST);
		marco.add(contenedorResultados, BorderLayout.CENTER);
		
		this.add(marco);		
		this.setBackground(Color.GRAY);	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * if(e.getSource() == anadir) {
			if (appVideo.getUsuarioActual().getListaVideos(busqueda2.getText()) != null) {
				appVideo.addVideoLista(appVideo.getUsuarioActual(), busqueda2.getText(), appVideo.getVideoSeleccionado());

			}
			else {
				LinkedList<Video> nuevaLista = new LinkedList<Video>();
				nuevaLista.add(appVideo.getVideoSeleccionado());
				appVideo.crearLista(appVideo.getUsuarioActual(),busqueda2.getText(), nuevaLista);
			}
		}
		*/
	}
}

