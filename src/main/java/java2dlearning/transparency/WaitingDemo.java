package java2dlearning.transparency;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by anonim on 04.08.17.
 */
public class WaitingDemo extends Java2DPanel implements ActionListener {
    private Timer timer;
    private int count;

    private final int INITIAL_DELAY = 200;
    private final int DELAY = 80;
    private final int NUMBER_OF_LINES = 8;
    private final int STROKE_WIDTH = 3;

    private final double[][] trs = {
            {0.0, 0.15, 0.30, 0.5, 0.65, 0.80, 0.9, 1.0},
            {1.0, 0.0, 0.15, 0.30, 0.5, 0.65, 0.8, 0.9},
            {0.9, 1.0, 0.0, 0.15, 0.3, 0.5, 0.65, 0.8},
            {0.8, 0.9, 1.0, 0.0, 0.15, 0.3, 0.5, 0.65},
            {0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.3, 0.5},
            {0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.3},
            {0.3, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15},
            {0.15, 0.3, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0}
    };

    public WaitingDemo() {
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = create(g);

        setRenderingHints(g2d);

        int width = getWidth();
        int height = getHeight();

        g2d.setStroke(new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.translate(width / 2, height / 2);

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            float alpha = (float) trs[count % NUMBER_OF_LINES][i];
            AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(acomp);
            g2d.rotate(Math.PI / 4f);
            g2d.drawLine(0, -10, 0, -40);
        }

        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        count++;
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new WaitingDemo());
        frame.setTitle("Wating");
        frame.setSize(300, 200);
        frame.initUI();
        Java2DFrame.show(frame);
    }
}
