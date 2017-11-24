package java2dlearning.composition;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class SunAndCloud extends Java2DPanel implements ActionListener {
    private Image sun;
    private Image cloud;
    private Timer timer;
    private float aplha = 1f;

    private final int DELAY = 600;

    public SunAndCloud() {
        loadImages();
        initTimer();
    }

    private void loadImages() {
        sun = new ImageIcon("sun.png").getImage();
        cloud = new ImageIcon("cloud.png").getImage();
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        BufferedImage bufferedImage = new BufferedImage(220, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gbi = bufferedImage.createGraphics();
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, aplha);
        gbi.drawImage(sun, 40, 30, null);
        gbi.setComposite(ac);
        gbi.drawImage(cloud, 0, 0, null);
        g2d.drawImage(bufferedImage, 20, 20, null);
        gbi.dispose();
        g2d.dispose();
    }

    private void step() {
        aplha -= 0.1;

        if (aplha <= 0) {
            aplha = 0;
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        repaint();
    }

    public static void main(String[] arg) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new SunAndCloud());
        frame.setTitle("Sun and Cloud");
        frame.setSize(300, 210);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Java2DFrame.show(frame);
    }
}
