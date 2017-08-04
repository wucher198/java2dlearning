package java2dlearning.common;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

abstract public class Java2DPanel extends JPanel {
	abstract protected void doDrawing(Graphics g);
	
	protected Graphics2D create(Graphics g) {
		return (Graphics2D) g.create();
	}
	
	protected Graphics2D cast(Graphics g) {
		return (Graphics2D) g;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
	}
}
