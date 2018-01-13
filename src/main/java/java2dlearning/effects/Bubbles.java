package java2dlearning.effects;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Bubbles extends Java2DPanel implements ActionListener {
    private final Color colors[] = {
            Color.blue, Color.cyan, Color.green,
            Color.magenta, Color.orange, Color.pink,
            Color.red, Color.yellow, Color.lightGray, Color.white
    };

    private Ellipse2D.Float[] ellipses;
    private double esize[];
    private float estroke[];
    private double maxSize = 0;
    private final int NUMBER_OF_ECLIPSES = 25;
    private final int DELAY = 30;
    private final int INITAL_DELAY = 150;
    private Timer timer;

    public Bubbles() {
        initSurface();
        initEllipses();
        initTimer();
    }

    private void initSurface() {
        setBackground(Color.black);
        ellipses = new Ellipse2D.Float[NUMBER_OF_ECLIPSES];
        esize = new double[ellipses.length];
        estroke = new float[ellipses.length];
    }

    private void initEllipses() {
        int w = 350;
        int h = 250;

        maxSize = w / 10;

        for (int i = 0; i < ellipses.length; i++) {
            ellipses[i] = new Ellipse2D.Float();
            posRandEllipses(i, maxSize * Math.random(), w, h);
        }
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITAL_DELAY);
        timer.start();
    }

    private void posRandEllipses(int i, double size, int w, int h) {
        esize[i] = size;
        estroke[i] = 1.0f;
        double x = Math.random() * (w - (maxSize / 2));
        double y = Math.random() * (h - (maxSize / 2));
        ellipses[i].setFrame(x, y, size, size);
    }

     private void doStep(int w, int h) {
        for (int i = 0; i < ellipses.length; i++) {
            estroke[i] += 0.25f;
            esize[i]++;

            if (esize[i] > maxSize) {
                posRandEllipses(i, 1, w, h);
            } else {
                ellipses[i].setFrame(ellipses[i].getX(), ellipses[i].getY(), esize[i], esize[i]);
            }
        }
     }

     private void drawEllipses(Graphics2D g2d) {
         for (int i = 0; i < ellipses.length; i++) {
             g2d.setColor(colors[i % colors.length]);
             g2d.setStroke(new BasicStroke(estroke[i]));
             g2d.draw(ellipses[i]);
         }
     }

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = create(g);
        setRenderingHints(g2d);

        Dimension size = getSize();
        doStep(size.width, size.height);
        drawEllipses(g2d);

        dispose(g2d);
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Bubbles());
        frame.setSize(350, 250);
        frame.setTitle("Bubbles");
        frame.initUI();
        Java2DFrame.show(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
