package java2dlearning.shapesandfills;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Star extends JFrame {
	public Star() {
		initUI();
	}
	
	private void initUI() {
		add(new GeneralPathSurface());
		
		setTitle("General Path - Star");
		setSize(350, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Star gp = new Star();
			gp.setVisible(true);
		}); 
	}
}

class GeneralPathSurface extends JPanel {
	private final double points[][] = {
	        { 0, 85 }, { 75, 75 }, { 100, 10 }, { 125, 75 }, 
	        { 200, 85 }, { 150, 125 }, { 160, 190 }, { 100, 150 }, 
	        { 40, 190 }, { 50, 125 }, { 0, 85 } 			
	};
	
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.setPaint(Color.gray);
		g2d.translate(25, 5);
		
		GeneralPath star = new GeneralPath();
		star.moveTo(points[0][0], points[0][1]);

		Stream.of(points).skip(1).forEach(point -> {
			star.lineTo(point[0], point[1]);
		});
		
		star.closePath();
		g2d.fill(star);
		
		g2d.dispose();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}
