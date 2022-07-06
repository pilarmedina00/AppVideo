package view;


import java.awt.*;

import javax.swing.*;

public class PanelVideo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PanelVideo() {
		setBackground(UIManager.getColor("Button.background")); 
		//Pensado para la parte donde aparece el video y si se le anaden etiquetas
		
		JPanel marco = new JPanel();
		marco.setBackground(UIManager.getColor("Button.background"));
		marco.setForeground(SystemColor.scrollbar);
		marco.setPreferredSize(new Dimension(650, 450));
		marco.setLayout(new BoxLayout(marco, BoxLayout.Y_AXIS));

		JPanel contenedor = new JPanel();
		contenedor.setBackground(UIManager.getColor("Button.background"));
		contenedor.setPreferredSize(new Dimension(200, 200));
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
		
		JPanel barraInferior = new JPanel();
		barraInferior.setBackground(UIManager.getColor("Button.background"));
		barraInferior.setPreferredSize(new Dimension(900, 90));

		
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBackground(UIManager.getColor("Button.background"));
		
		JLabel titulo = new JLabel("Video title goes here", SwingConstants.CENTER);
		titulo.setForeground(Color.DARK_GRAY);
		titulo.setBackground(SystemColor.controlHighlight);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel visualizaciones = new JLabel("Seen by: x users.", SwingConstants.CENTER);
		visualizaciones.setForeground(SystemColor.controlDkShadow);
		visualizaciones.setBackground(SystemColor.controlHighlight);
		visualizaciones.setFont(new Font("Verdana", Font.PLAIN, 14));
		barraSuperior.setLayout(new BorderLayout(0, 0));
		
		barraSuperior.add(titulo, BorderLayout.NORTH);
		barraSuperior.add(visualizaciones, BorderLayout.SOUTH);
		
		JLabel etiqueta = new JLabel("New tag: ");
		etiqueta.setForeground(Color.DARK_GRAY);
		etiqueta.setBackground(SystemColor.controlHighlight);
		etiqueta.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JTextField etiquetas = new JTextField();
		etiquetas.setFont(new Font("Verdana", Font.PLAIN, 14));
		etiquetas.setColumns(45);
		
		JButton anadir = new JButton("Add tag");
		anadir.setFont(new Font("Verdana", Font.BOLD, 13));
		
		contenedor.add(Box.createRigidArea(new Dimension(70, 70)));
		contenedor.add(barraSuperior);
		contenedor.add(Box.createRigidArea(new Dimension(200, 250)));

		barraInferior.add(etiqueta);
		barraInferior.add(etiquetas);
		barraInferior.add(anadir);
				
		marco.add(contenedor);
		marco.add(barraInferior);
		
		this.add(marco);
	}
}
