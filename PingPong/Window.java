package PingPong;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        setTitle("Ping Pong!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        MenuBar menuBar = new MenuBar();
        Menu startMenu = new Menu("Start");
        setMenuBar(menuBar);
    }
}
