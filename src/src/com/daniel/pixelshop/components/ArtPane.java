package src.com.daniel.pixelshop.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import src.com.daniel.pixelshop.jframes.MainJFrame;

public class ArtPane extends JPanel {
	
	int width, height;
	int blockWidth, blockHeight;
	
	public Color[] texture;
	
	Dimension size;
	
	public boolean showGrid = false;
	
	public ArtPane(int width, int height, int blockWidth, int blockHeight) {
		this.width = width;
		this.height = height;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.size = new Dimension(width * blockWidth + 1, height * blockHeight + 1);
		invalidate();
        revalidate();
		this.setBackground(new Color(0.95f, 0.95f, 0.95f));
		this.generateDefaultTexture();
		this.addListeners();
	}
	
	public ArtPane(int width, int height, int blockWidth, int blockHeight, Color[] texture) {
		this.width = width;
		this.height = height;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.texture = texture;
		this.size = new Dimension(width * blockWidth, height * blockHeight);
		this.setBackground(new Color(0.5f, 0.95f, 0.95f));
		this.repaint();
		this.addListeners();
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
	
	private void addListeners() {
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent event) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent event) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent event) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent event) {
				final int x = event.getX(), y = event.getY();
				texture[getArrayIndex(x, y)] = MainJFrame.colorPicker.getColor();
				repaint();
				
			}

			@Override
			public void mouseReleased(MouseEvent event) {
				
				
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent event) {
				final int i = getArrayIndex(event.getX(), event.getY());
				int lasti = -1;
				if(i != lasti) {
					texture[i] = MainJFrame.colorPicker.getColor();
					lasti = i;
					repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent event) {
				
				
			}
			
		});
		
	}
	
	private void render(Graphics g) {
		int y = -1;
		for(int i = 0; i < texture.length; i++) {
			if(i % this.width == 0) y++;
			g.setColor(texture[i]);
			g.fillRect((i % this.width) * this.blockWidth, y * this.blockHeight, this.blockWidth, this.blockHeight);
			g.setColor(new Color(0, 0, 0));
			if(this.showGrid) g.drawRect((i % this.width) * this.blockWidth, y * this.blockHeight, this.blockWidth, this.blockWidth);
		}
	}
	
	private int getArrayIndex(int x, int y) {
		return (x / this.blockWidth) + ((y / this.blockHeight) * this.height);
	}
	
	public void generateDefaultTexture() {
		this.texture = new Color[this.width * this.height];
		for(int i = 0; i < this.width * this.height; i++) texture[i] = new Color((float) i / (this.width * this.height), (float) i / (this.width * this.height), (float) i / (this.width * this.height));
		repaint();
	}

}
