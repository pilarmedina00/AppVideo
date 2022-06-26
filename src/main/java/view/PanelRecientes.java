package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;

//import controlador.AppVideo;

public class PanelRecientes extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton reproducir;
	//private AppVideo appVideo = AppVideo.getUnicaInstancia();

	
	public PanelRecientes() {
		JPanel marco = new JPanel();
		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(1040, 500));
		marco.setLayout(new BorderLayout());

		JPanel contenedorIzq = new JPanel();
		contenedorIzq.setBackground(UIManager.getColor("Button.background"));
		contenedorIzq.setPreferredSize(new Dimension(400, 400));
		
		JButton cancelar = new JButton("Cancel");
		cancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		
		JPanel barraIzquierda = new JPanel();
		barraIzquierda.setBackground(UIManager.getColor("Button.background"));
		barraIzquierda.setPreferredSize(new Dimension(380, 500));
		
		JTextArea textArea = new JTextArea(18, 24);
		textArea.setLineWrap(true);
		textArea.setTabSize(10);
					
		JScrollPane listado = new JScrollPane(textArea);
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lista = new JLabel("Last played:");
		lista.setForeground(Color.DARK_GRAY);
		lista.setBackground(SystemColor.controlHighlight);
		lista.setFont(new Font("Verdana", Font.BOLD, 16));
		
		barraIzquierda.add(lista);
		
		barraIzquierda.add(Box.createRigidArea(new Dimension(200, 50)));
		
		reproducir = new JButton("Play");
		reproducir.setFont(new Font("Verdana", Font.BOLD, 14));
		
		barraIzquierda.add(reproducir);
		barraIzquierda.add(listado);
		barraIzquierda.add(cancelar);

		JPanel contenedorResultados = new JPanel();
			
		JPanel listaVideos = new JPanel();
		listaVideos.setPreferredSize(new Dimension(580, 480));
		listaVideos.setLayout(new BoxLayout(listaVideos, BoxLayout.Y_AXIS));

		JTable tablaVideos = new JTable();
		tablaVideos.setFillsViewportHeight(true);
		tablaVideos.setBackground(SystemColor.control);
		 
		JScrollPane video = new JScrollPane(tablaVideos);
		listaVideos.add(video);
		
		contenedorResultados.add(listaVideos);
		contenedorIzq.add(barraIzquierda,  BorderLayout.WEST);
		marco.add(contenedorIzq, BorderLayout.WEST);
		marco.add(contenedorResultados, BorderLayout.CENTER);
		
		this.add(marco);		
		this.setBackground(Color.GRAY);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reproducir) {
			// Play video
			//appVideo.getVideosRecientes(appVideo.getUsuarioActual())
		}
	}
}
