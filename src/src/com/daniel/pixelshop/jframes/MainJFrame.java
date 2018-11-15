package src.com.daniel.pixelshop.jframes;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import src.com.daniel.pixelshop.components.ArtPane;
import src.com.daniel.pixelshop.components.ColorPicker;

/*
	Made By: Daniel Chapin
*/

public class MainJFrame extends JFrame {
	
	JPanel panel;
	public static ArtPane artPanel;
	public static ColorPicker colorPicker = new ColorPicker();
	JMenuBar menuBar = new JMenuBar();
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	
	public MainJFrame() {
		this.panel = new JPanel();
		this.artPanel = new ArtPane(40, 40, 10, 10);
		this.setTitle("DC Pixel Shop");
		
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(this.panel);
		this.setVisible(true);
		
		this.initComponents();
	}
	
	private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        JMenu file = new JMenu("File");
        
        JMenu edit = new JMenu("Edit");
        JPopupMenu editPopup = new JPopupMenu();
        editPopup.add("Canvas");
        edit.add(editPopup);
        
        this.menuBar.add(file);
        this.menuBar.add(edit);
        this.setJMenuBar(this.menuBar);

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
        
        pack();
        
        this.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowGainedFocus(WindowEvent event) {
				artPanel.grabFocus();
				
			}

			@Override
			public void windowLostFocus(WindowEvent event) {
				
				
			}
        	
        });
    }
	
	

}
