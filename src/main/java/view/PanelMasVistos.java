package view;

import javax.swing.*;

//import controlador.AppVideo;

import java.awt.*;

public class PanelMasVistos extends JPanel {

	private static final long serialVersionUID = 1L;
	//private AppVideo appVideo = AppVideo.getUnicaInstancia();


	public PanelMasVistos() {
		setBackground(UIManager.getColor("Button.background"));
		
		JPanel marco = new JPanel();
		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(740, 450));
		marco.setLayout(new BoxLayout(marco, BoxLayout.Y_AXIS));

		JPanel contenedor = new JPanel();
		contenedor.setBackground(UIManager.getColor("Button.background"));
		contenedor.setLayout(new BorderLayout(0, 0));
		
		JPanel centro = new JPanel();
		centro.setBackground(UIManager.getColor("Button.background"));
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		
		JLabel titulo = new JLabel("Trending videos:");
		titulo.setForeground(Color.DARK_GRAY);
		titulo.setBackground(SystemColor.controlHighlight);
		titulo.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JTable tablaVideos = new JTable();
		tablaVideos.setFillsViewportHeight(true);
		tablaVideos.setBackground(SystemColor.controlHighlight);
					
		JScrollPane listado = new JScrollPane(tablaVideos);
		listado.setPreferredSize(new Dimension(600, 390));

		tablaVideos.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		centro.add(titulo);
		centro.add(listado);
		
		contenedor.add(centro);
				
		marco.add(contenedor);
		
		this.add(marco);
	}
}
