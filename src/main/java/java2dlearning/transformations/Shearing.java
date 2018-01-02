package java2dlearning.transformations;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Shearing extends Java2DPanel {
    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = create(g);
        AffineTransform tx1 = new AffineTransform();
        tx1.translate(50, 90);

        g2d.setTransform(tx1);
        g2d.setPaint(Color.green);
        g2d.drawRect(0, 0, 160, 50);

        AffineTransform tx2 = new AffineTransform();
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Shearing());
        frame.setSize(330, 270);
        frame.setTitle("Shearing");
        frame.initUI();
        Java2DFrame.show(frame);
    }
}
