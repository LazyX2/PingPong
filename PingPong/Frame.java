package PingPong;

import javax.swing.*;
import java.awt.*;

public class Frame extends JPanel {

    public Frame() {
        setBackground(Color.BLACK);
    }

    public Graphics graphics;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graphics = g;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.setStroke(new BasicStroke(30));
        g2D.drawLine(200, Launcher.player1.Y+25, 200, Launcher.player1.Y-25);

        g2D.drawLine(Launcher.window.getWidth()-200, Launcher.player2.Y+25, Launcher.window.getWidth()-200, Launcher.player2.Y-25);

        g2D.drawLine(Launcher.ballX, Launcher.ballY-5, Launcher.ballX, Launcher.ballY);
    }
}
