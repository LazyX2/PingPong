package PingPong;

public class Player {

    int score;
    char up;
    char down;
    int Y;

    public Player(char up, char down, boolean bot) {
        score = 0;
        Y = Launcher.window.getHeight()/2;
        this.up = up;
        this.down = down;
    }
}
