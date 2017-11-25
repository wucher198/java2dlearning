package java2dlearning.cliping;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;
import java2dlearning.composition.Spotlight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Cliping extends Java2DPanel implements ActionListener {
    private Image image;
    private Timer timer;

    private final double delta[] = {3, 3};
    private int posX = 8;
    private int posY = 8;
    private final int RADIUS = 90;
    private final int DELAY = 35;

    public Cliping() {
        loadImage();
        determineAndSetImageSize();
        initTimer();
    }

    private void loadImage() {
        image = new ImageIcon("penguin.jpg").getImage();
    }

    private void determineAndSetImageSize() {
        int h = image.getHeight(this);
        int w = image.getWidth(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveCircle();
        repaint();
    }

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.clip(new Ellipse2D.Double(posX, posY, RADIUS, RADIUS));
        g2d.drawImage(image,0, 0, null);

        g2d.dispose();
    }

    private void moveCircle() {
        int w = getWidth();
        int h = getHeight();

        if (posX < 0) {
            delta[0] = 4;
        } else if (posX > w - RADIUS) {
            delta[0] = - (4);
        }

        if (posY < 0) {
            delta[1] = 4;
        } else if (posY > h - RADIUS) {
            delta[1] = - (4);
        }

        posX += delta[0];
        posY += delta[1];
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Cliping());
        frame.setSize(350, 300);
        frame.setTitle("Spotlight");
        frame.initUI();
        Java2DFrame.show(frame);
    }
}
