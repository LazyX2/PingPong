package PingPong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Launcher {

    static boolean running = false;
    static Frame frame;
    static Window window;

    static Player player1;
    static Player player2;
    static int ballDirectionY = -1;
    static int ballDirectionX = 1;
    static int ballY;
    static int ballX;

    public static void main(String[] args) {
        running = true;
        window = new Window();
        frame = new Frame();
        window.add(frame);
        ballY = window.getHeight()/2;
        ballX = window.getWidth()/2;
        player1 = new Player('w', 's', false);
        player2 = new Player('8', '2', true);

        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == player1.up) {
                    if (player1.Y >= 25) {
                        player1.Y -= 5;
                    } else {
                        player1.Y = window.getHeight() - 25;
                    }
                    frame.repaint();
                } else if (e.getKeyChar() == player1.down) {
                    if (player1.Y <= window.getHeight() - 25) {
                        player1.Y += 5;
                    } else {
                        player1.Y = 25;
                    }
                    frame.repaint();
                }
            }
        });
        new WindowUpdater().run();
    }
}