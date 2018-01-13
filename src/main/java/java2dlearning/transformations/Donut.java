package java2dlearning.transformations;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Donut extends Java2DPanel {
    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = create(g);
        setRenderingHints(g2d);

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(Color.gray);

        for (double deg = 0; deg < 360; deg += 12) {
            AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Donut());
        frame.setSize(370, 320);
        frame.setTitle("Donut");
        frame.initUI();
        Java2DFrame.show(frame);
    }
}
