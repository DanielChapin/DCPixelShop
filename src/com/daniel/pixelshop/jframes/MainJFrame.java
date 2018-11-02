package com.daniel.pixelshop.jframes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.daniel.pixelshop.listeners.MouseClickedListener;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.opengl.awt.GLJPanel;

/*
	Made By: Daniel Chapin
*/

public class MainJFrame extends JFrame {
	
	JPanel panel;
	
	GLJPanel artPanel = new GLJPanel();
	
	public MainJFrame() {
		this.panel = new JPanel();
		this.setTitle("DC Pixel Shop");
		
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(this.panel);
		this.setVisible(true);
		
		initComponents();
		
		artPanel.setBackground(new Color(1));
	}
	
	private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout artPanelLayout = new javax.swing.GroupLayout(artPanel);
        artPanel.setLayout(artPanelLayout);
        artPanelLayout.setHorizontalGroup(
            artPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        artPanelLayout.setVerticalGroup(
            artPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(artPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(artPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        artPanel.addMouseListener(new java.awt.event.MouseListener() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				System.out.println("Mouse Clicked");
				
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				
				
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				
				
			}
        	
        });
        
        System.out.println(artPanel.getMouseListeners());

        pack();
    }

}
