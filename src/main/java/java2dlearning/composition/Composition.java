package java2dlearning.composition;

import java2dlearning.common.Java2DFrame;
import java2dlearning.common.Java2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Composition extends Java2DPanel {
    private final int rules[] = {
            AlphaComposite.DST,
            AlphaComposite.DST_ATOP,
            AlphaComposite.DST_OUT,
            AlphaComposite.SRC,
            AlphaComposite.SRC_ATOP,
            AlphaComposite.SRC_OUT
    };

    @Override
    protected void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        for (int x = 20, y = 20, i = 0; i < rules.length; x += 60, i++) {
            AlphaComposite ac = AlphaComposite.getInstance(rules[i], 0.8f);
            BufferedImage bufferedImage = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = bufferedImage.createGraphics();
            gbi.setPaint(Color.blue);
            gbi.fillRect(0,0, 40, 40);
            gbi.setComposite(ac);
            gbi.setPaint(Color.green);
            gbi.fillRect(5, 5, 40, 40);
            g2d.drawImage(bufferedImage, x, y, null);
            gbi.dispose();
        }

        g2d.dispose();
    }

    public static void main(String[] args) {
        Java2DFrame frame = new Java2DFrame();
        frame.add(new Composition());
        frame.setTitle("Composition");
        frame.setSize(400,120);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Java2DFrame.show(frame);
    }
}
