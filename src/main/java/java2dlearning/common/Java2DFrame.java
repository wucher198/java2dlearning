package java2dlearning.common;

import java.awt.EventQueue;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Java2DFrame extends JFrame {
//	private Point2D position = null;
//	
//	
//	public Java2DFrame panel(JPanel panel) {
//		add(panel);
//		
//		return this;
//	}
//	
//	public Java2DFrame withTitle(String title) {
//		setTitle(title);
//		
//		return this;
//	}
//	
//	public Java2DFrame onPosition(int x, int y) {
//		setLocation(x, y);
//		
//		return this;
//	}
//	
//	public Java2DFrame withSize(int width, int height) {
//		setSize(width, height);
//		
//		return this;
//	}
//	
//	public Java2DFrame doPack() {
//		pack();
//		
//		return this;
//	}
	
	public Java2DFrame initUI() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return this;
	}
	
	public static void show(final Java2DFrame frame) {
		EventQueue.invokeLater(() -> {
			frame.setVisible(true);
		});
	}
}
