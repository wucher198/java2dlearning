package java2dlearning.common;

import java.awt.EventQueue;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Java2DFrame extends JFrame {
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
