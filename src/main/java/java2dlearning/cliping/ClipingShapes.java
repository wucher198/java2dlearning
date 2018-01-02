package java2dlearning.cliping;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class ClipingShapes extends Java2DPanel implements ActionListener {
    private Timer timer;
    private double rotate = 1;
    private int posX = 8;
    private int posY = 8;
    private final double delta[] = {1, 1};

    private final int RADIUS = 60;

    public ClipingShapes() {
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Shape oldClip = g2d.getClip();

        int w = getWidth();
        int h = getHeight();

        Rectangle rect = new Rectangle(0, 0, 200, 80);

        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(rotate), w / 2, h / 2);
        tx.translate(w / 2 - 100, h / 2 - 40);

        Ellipse2D circle = new Ellipse2D.Double(posX, posY, RADIUS, RADIUS);

        GeneralPath path = new GeneralPath();
        path.append(tx.createTransformedShape(rect), false);

        g2d.clip(circle);
        g2d.clip(path);

        g2d.setPaint(new Color(110, 110, 110));
        g2d.fill(circle);

        g2d.setClip(oldClip);
        g2d.draw(circle);
        g2d.draw(path);
    }

    public void step() {
        int w = getWidth();
        int h = getHeight();

        rotate += 1;

        if (posX < 0) {
            delta[0] = 1;
        } else if (posX > w - RADIUS) {
            delta[0] = -1;
        }

        if (posY < 0) {
            delta[1] = 1;
        } else if (posY > h - RADIUS) {
            delta[1] = -1;
        }

        posX += delta[0];
        posY += delta[1];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        repaint();
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new ClipingShapes());
        frame.setSize(350, 300);
        frame.setTitle("Spotlight");
        frame.initUI();
        Java2DFrame.show(frame);
    }
}
