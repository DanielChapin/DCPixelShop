package src.com.daniel.pixelshop.objects;

import java.awt.Color;

public class Block extends Color {
	
	public boolean defaultBlock = false;
	
	public Block(float r, float g, float b) {
		super(r, g, b);
	}
	
	public Block(Color color) {
		super(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	public Block(Color color, boolean defaultBlock) {
		super(color.getRed(), color.getGreen(), color.getBlue());
		this.defaultBlock = defaultBlock;
	}
	
}
