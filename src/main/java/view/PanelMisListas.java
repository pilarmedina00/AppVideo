package view;


import java.awt.*;

import javax.swing.*;

/*
import controlador.AppVideo;
import model.ListaVideos;
*/

public class PanelMisListas extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private PanelVideo video = new PanelVideo();
	//private AppVideo appVideo = AppVideo.getUnicaInstancia();

	
	public PanelMisListas() {
		
		JPanel marco = new JPanel();
		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(1040, 500));
		marco.setLayout(new BorderLayout());

		JPanel contenedorIzq = new JPanel();
		contenedorIzq.setBackground(UIManager.getColor("Button.background"));
		
		JButton cancelar = new JButton("Cancel");
		cancelar.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton reproducir = new JButton("Play");
		reproducir.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JPanel barraIzquierda = new JPanel();
		barraIzquierda.setBackground(UIManager.getColor("Button.background"));
		barraIzquierda.setPreferredSize(new Dimension(280, 500));
			
		JPanel barraSeleccion = new JPanel();
		barraSeleccion.setBackground(UIManager.getColor("Button.background"));
		barraSeleccion.setPreferredSize(new Dimension(210, 25));
		
		JTextArea textArea = new JTextArea(16, 18);
		textArea.setLineWrap(true);
		textArea.setTabSize(10);
		
		JComboBox<String> listasCombo = new JComboBox<String>();
		listasCombo.setMaximumRowCount(16);
		listasCombo.setEditable(true);
		/*for (ListaVideos playlist: appVideo.getUsuarioActual().getListasReproduccion()) {
			listasCombo.addItem(playlist.getNombreLista());
		}
		*/
		
		barraSeleccion.setLayout(new BoxLayout(barraSeleccion, BoxLayout.X_AXIS));
		barraSeleccion.add(listasCombo);
			
		JScrollPane listado = new JScrollPane(textArea);
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		barraIzquierda.add(Box.createRigidArea(new Dimension(200, 30)));
		
		JLabel lista = new JLabel("Select playlist:");
		lista.setForeground(Color.DARK_GRAY);
		lista.setBackground(SystemColor.controlHighlight);
		lista.setFont(new Font("Verdana", Font.BOLD, 13));
		
		barraIzquierda.add(lista);	
		barraIzquierda.add(barraSeleccion);
		barraIzquierda.add(reproducir);
		barraIzquierda.add(listado);
		barraIzquierda.add(cancelar);

		JPanel contenedorResultados = new JPanel();
		contenedorResultados.setPreferredSize(new Dimension(770, 400));
		contenedorResultados.setLayout(new BoxLayout(contenedorResultados, BoxLayout.X_AXIS));
		
		contenedorResultados.add(video);
		contenedorIzq.add(barraIzquierda,  BorderLayout.WEST);
		marco.add(contenedorIzq, BorderLayout.WEST);
		marco.add(contenedorResultados, BorderLayout.CENTER);
		
		this.add(marco);		
		this.setBackground(Color.GRAY);

	}

}