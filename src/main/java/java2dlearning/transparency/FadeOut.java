package java2dlearning.transparency;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

public class FadeOut extends Java2DPanel implements ActionListener {
	private Image img;
	private Timer timer;
	private float alpha = 1f;
	
	private final int DELAY = 40;
	private final int INITIAL_DELAY = 500;
	
	public FadeOut() {
		loadImage();
		setPanelSize();
		initTimer();
	}
	
	private void loadImage() {
		img = new ImageIcon("texture1.png").getImage();
	}
	
	private void setPanelSize() {
		setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
	}
	
	private void initTimer() {
		timer = new Timer(DELAY, this);
		timer.setInitialDelay(INITIAL_DELAY);
		timer.start();
	}
	
	private void step() {
		alpha += -0.01f;
		
		if (alpha <= 0) {
			alpha = 0;
			timer.stop();
		}
	}

	@Override
	protected void doDrawing(Graphics g) {
		Graphics2D g2d = create(g);
		
		AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(acomp);
		g2d.drawImage(img, 0, 0, null);
		
		g2d.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		step();
		repaint();
	}
	
	
	public static void main(String[] args) {
		Java2DFrame frame = new Java2DFrame();
		frame.add(new FadeOut());
		frame.pack();
		frame.setTitle("Fade out");
		frame.initUI();
		Java2DFrame.show(frame);
	}
}
