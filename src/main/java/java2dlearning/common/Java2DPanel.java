package java2dlearning.common;

import java.awt.*;

import javax.swing.JPanel;

abstract public class Java2DPanel extends JPanel {
	abstract protected void doDrawing(Graphics g);
	
	protected Graphics2D create(Graphics g) {
		return (Graphics2D) g.create();
	}
	
	protected Graphics2D cast(Graphics g) {
		return (Graphics2D) g;
	}

	protected void dispose(Graphics2D g2) {
		g2.dispose();
	}

	protected void setRenderingHints(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);
		
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
}
