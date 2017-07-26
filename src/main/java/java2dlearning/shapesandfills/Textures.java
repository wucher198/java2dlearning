package java2dlearning.shapesandfills;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Textures extends JFrame {
	public Textures() {
		initUI();
	}
	
	private void initUI() {
		add(new TexturesSurface());
		
		setTitle("Textures");
		setSize(360, 120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Textures tx = new Textures();
			tx.setVisible(true);
		});
	}
}

class TexturesSurface extends JPanel {
	private BufferedImage texture1;
	private BufferedImage texture2;
	private BufferedImage texture3;
	private TexturePaint texture1Paint;
	private TexturePaint texture2Paint;
	private TexturePaint texture3Paint;
	
	public TexturesSurface() {
		loadImages();
	}
	
	private void loadImages() {
		try {
			texture1 = ImageIO.read(new File("texture1.png"));
			texture2 = ImageIO.read(new File("texture2.png"));
			texture3 = ImageIO.read(new File("texture3.png"));
		} catch (IOException ex) {
			Logger.getLogger(TexturesSurface.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		texture1Paint = new TexturePaint(texture1, new Rectangle(0, 0, 90, 60));
		texture2Paint = new TexturePaint(texture2, new Rectangle(0, 0, 90, 60));
		texture3Paint = new TexturePaint(texture3, new Rectangle(0, 0, 90, 60));
		
		g2d.setPaint(texture1Paint);
		g2d.fillRect(10,  15, 90, 60);
		
		g2d.setPaint(texture2Paint);
		g2d.fillRect(130, 15, 90, 60);
		
		g2d.setPaint(texture3Paint);
		g2d.fillRect(250, 15, 90, 60);
		
		g2d.dispose();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}
