package java2dlearning.transformations;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import java.awt.*;

public class Rotation extends Java2DPanel {

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = create(g);

        g2d.setPaint(new Color(150, 150, 150));
        g2d.drawRect(20, 20, 80, 50);
//        g2d.translate(180, -50);
        g2d.rotate(Math.PI / 16);
        g2d.drawRect(20, 20, 80, 50);

        dispose(g2d);
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Rotation());
        frame.setSize(300, 200);
        frame.setTitle("Rotation");
        frame.initUI();
        Java2DFrame.show(frame);
    }
}
