package java2dlearning.transformations;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Scaling extends Java2DPanel {
    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = create(g);

        g2d.setColor(new Color(150, 150, 150));
        g2d.fillRect(20, 20, 80, 50);

        AffineTransform tx1 = new AffineTransform();
        tx1.translate(110, 22);
        tx1.scale(0.5, 0.5);

        g2d.setTransform(tx1);
        g2d.fillRect(0, 0, 80, 50);

        AffineTransform tx2 = new AffineTransform();
        tx2.translate(170, 20);
        tx2.scale(1.5, 1.5);

        g2d.setTransform(tx2);
        g2d.fillRect(0, 0, 80, 50);

        dispose(g2d);
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Scaling());
        frame.setSize(330, 160);
        frame.setTitle("Scaling");
        frame.initUI();
        Java2DFrame.show(frame);
    }
}
