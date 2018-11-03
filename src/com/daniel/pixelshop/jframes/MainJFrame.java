package com.daniel.pixelshop.jframes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;
import com.sun.javafx.tk.Toolkit;

/*
	Made By: Daniel Chapin
*/

public class MainJFrame extends JFrame {
	
	JPanel panel;
	GLJPanel artPanel = new GLJPanel();
	JColorChooser colorPicker = new JColorChooser();
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	
	int canvasWidth = 100;
	int canvasHeight = 100;
	Color[] colors = new Color[canvasWidth * canvasHeight];
	
	public MainJFrame() {
		this.panel = new JPanel();
		this.setTitle("DC Pixel Shop");
		
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(this.panel);
		this.setVisible(true);
		
		setupDefaultTexture();
		
		initComponents();
		
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(colorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(artPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorPicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        
        artPanel.addMouseListener(new java.awt.event.MouseListener() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				System.out.println(e.getX() + " , " + e.getY());
				
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
        
        artPanel.addGLEventListener(new GLEventListener() {

			@Override
			public void display(GLAutoDrawable drawable) {
				final GL2 gl = drawable.getGL().getGL2();
				float y = 0;
				for(int i = 0; i < colors.length; i++) {
					float x = i % canvasWidth;
					if(x == 0f && i > 20) y += 1f;
					  gl.glColor3f(colors[i].getRed(), colors[i].getGreen(), colors[i].getBlue());
					  gl.glBegin(GL2.GL_QUADS);
					  gl.glVertex2f(x, y);
					  gl.glVertex2f(x + 1, y);
					  gl.glVertex2f(x + 1, y + 1);
					  gl.glVertex2f(x, y + 1);
					  gl.glEnd();
				}
				
			}

			@Override
			public void dispose(GLAutoDrawable arg0) {
				
				
			}

			@Override
			public void init(GLAutoDrawable drawable) {
				final GL2 gl = drawable.getGL().getGL2();
				gl.glMatrixMode(GL2.GL_PROJECTION);
				gl.glPushMatrix();
				gl.glOrtho(0f, 100f, 100f, 0f, 1.0, -1.0);
				
			}

			@Override
			public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
				
				
			}
        
        });
        
        System.out.println(artPanel.getMouseListeners());

        pack();
    }
	
	private void setupDefaultTexture() {
		for(int i = 0; i < colors.length; i++) colors[i] = new Color(0.5f, 0.5f, 0.5f);
	}

}
