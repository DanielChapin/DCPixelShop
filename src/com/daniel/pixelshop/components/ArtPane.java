package com.daniel.pixelshop.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ArtPane extends JPanel {
	
	int width, height;
	int blockWidth, blockHeight;
	
	public Color[] texture;
	
	Dimension size;
	
	public ArtPane(int width, int height, int blockWidth, int blockHeight) {
		this.width = width;
		this.height = height;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.size = new Dimension(width * blockWidth, height * blockHeight);
		this.setBackground(new Color(0.95f, 0.95f, 0.95f));
		this.generateDefaultTexture();
	}
	
	public ArtPane(int width, int height, int blockWidth, int blockHeight, Color[] texture) {
		this.width = width;
		this.height = height;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.texture = texture;
		this.size = new Dimension(width * blockWidth, height * blockHeight);
		this.setBackground(new Color(0.95f, 0.95f, 0.95f));
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.render(g);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return this.size;
    }
	
	private void render(Graphics g) {
		int y = -1;
		for(int i = 0; i < texture.length; i++) {
			if(i % this.width == 0) y++;
			g.setColor(texture[i]);
			g.fillRect((i % this.width) * this.blockWidth, y * this.blockHeight, this.blockWidth, this.blockHeight);
		}
	}
	
	public void generateDefaultTexture() {
		this.texture = new Color[this.width * this.height];
		for(int i = 0; i < this.width * this.height; i++) texture[i] = new Color((float) i / (this.width * this.height), (float) i / (this.width * this.height), (float) i / (this.width * this.height));
		repaint();
	}

}
