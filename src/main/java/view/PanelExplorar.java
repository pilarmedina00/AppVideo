package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import controlador.AppVideo;

public class PanelExplorar extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	//private AppVideo appVideo = AppVideo.getUnicaInstancia();
	private JTextField busqueda;
	private JButton buscar;
	private JButton limpiar;
	private JTextArea textArea;
	private JTextArea textArea1;
	private PanelMasVistos trends = new PanelMasVistos();
	

	public PanelExplorar() {
		this.setPreferredSize(new Dimension(1070, 510));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel marco = new JPanel();
		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(1040, 500));
		marco.setLayout(new BorderLayout()); 
		
		JPanel contenedorIzq = new JPanel();
		contenedorIzq.setBackground(UIManager.getColor("Button.background"));

		JPanel contenedorDer = new JPanel();
		contenedorDer.setBackground(UIManager.getColor("Button.background"));
		
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBackground(UIManager.getColor("Button.background"));
		barraSuperior.setLayout(new BoxLayout(barraSuperior, BoxLayout.X_AXIS));
		
		busqueda = new JTextField();
		busqueda.setFont(new Font("Verdana", Font.PLAIN, 14));
		busqueda.setToolTipText("");
		busqueda.setColumns(45);
		
		buscar = new JButton("Search");
		buscar.setFont(new Font("Verdana", Font.BOLD, 14));
		
		limpiar = new JButton("Clean history");
		limpiar.setFont(new Font("Verdana", Font.BOLD, 14));
		
	    barraSuperior.add(Box.createRigidArea(new Dimension(80, 15)));
		barraSuperior.add(busqueda);
		barraSuperior.add(buscar);
		barraSuperior.add(Box.createRigidArea(new Dimension(30, 15)));
		barraSuperior.add(limpiar);
	    barraSuperior.add(Box.createRigidArea(new Dimension(80, 15)));
		
		JPanel barraDerecha = new JPanel();
		barraDerecha.setBackground(UIManager.getColor("Button.background"));
		barraDerecha.setPreferredSize(new Dimension(150, 450));
		
		JLabel etiqueta = new JLabel("Avaliable tags:", SwingConstants.LEFT);
		etiqueta.setForeground(Color.DARK_GRAY);
		etiqueta.setBackground(SystemColor.controlHighlight);
		etiqueta.setFont(new Font("Verdana", Font.BOLD, 13));
		
		textArea = new JTextArea(9, 10);
		textArea.setLineWrap(true);
		textArea.setTabSize(10);

		JScrollPane etiquetas = new JScrollPane(textArea);
		textArea.setBackground(SystemColor.window);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel etiquetaSel = new JLabel("Searching tags:", SwingConstants.LEFT);
		etiquetaSel.setForeground(Color.DARK_GRAY);
		etiquetaSel.setBackground(SystemColor.controlHighlight);
		etiquetaSel.setFont(new Font("Verdana", Font.BOLD, 13));
		
		textArea1 = new JTextArea(9, 10);
		textArea1.setLineWrap(true);
		textArea1.setTabSize(10);
		textArea1.setBackground(SystemColor.window);
		textArea1.setFont(new Font("Verdana", Font.PLAIN, 14));
		JScrollPane etiquetasSel = new JScrollPane(textArea1);
		
		barraDerecha.add(etiqueta);
		barraDerecha.add(etiquetas);
	    barraDerecha.add(Box.createRigidArea(new Dimension(60, 20)));
		barraDerecha.add(etiquetaSel);
		barraDerecha.add(etiquetasSel);

		JPanel barraCentro = new JPanel();
		barraCentro.setBackground(UIManager.getColor("Button.background"));
		barraCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel listaVideos = new JPanel();
		listaVideos.setLayout(new BoxLayout(listaVideos, BoxLayout.Y_AXIS));
		listaVideos.setPreferredSize(new Dimension(840, 440));
		
		barraCentro.add(trends);
		contenedorIzq.add(barraSuperior, BorderLayout.NORTH);
		contenedorDer.add(barraDerecha,  BorderLayout.EAST);
		
		marco.add(contenedorIzq, BorderLayout.NORTH);
		marco.add(contenedorDer, BorderLayout.EAST);
		marco.add(barraCentro);
		
		this.add(marco);	
		this.setBackground(Color.GRAY);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
