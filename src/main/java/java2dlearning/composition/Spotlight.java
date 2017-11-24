package java2dlearning.composition;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Spotlight extends Java2DPanel {
    private final int RADIUS = 50;
    private Image image;
    private int iw;
    private int ih;
    private int x;
    private int y;
    private boolean mouseIn;

    public Spotlight() {
        initUI();
    }

    private void initUI() {
        loadImage();
        iw = image.getWidth(null);
        ih = image.getHeight(null);

        addMouseMotionListener(new MyMouseAdapter());
        addMouseListener(new MyMouseAdapter());
    }

    private void loadImage() {
        image = new ImageIcon("penguin.jpg").getImage();
    }

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int midX = (getWidth() - iw) / 2;
        int midY = (getHeight() - ih) / 2;

        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gbi = bi.createGraphics();

        if (mouseIn) {
            gbi.setPaint(Color.white);
            gbi.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
            gbi.setComposite(AlphaComposite.SrcAtop);
            gbi.drawImage(image, midX, midY, iw, ih, this);
        }

        gbi.setComposite(AlphaComposite.SrcOver.derive(0.1f));
        gbi.drawImage(image, midX, midY, iw, ih, this);
        gbi.dispose();
        g2d.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
        g2d.dispose();
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Spotlight());
        frame.setSize(350, 300);
        frame.setTitle("Spotlight");
        frame.initUI();
        Java2DFrame.show(frame);
    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseExited(MouseEvent e) {
            mouseIn = false;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseIn = true;
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();

            repaint();
        }
    }
}
