package PingPong;

public class WindowUpdater extends Thread {

    public int autoBot(int side) {
        int result = Launcher.window.getHeight();
        int distance = side-Launcher.ballX;
        if (Launcher.window.getHeight()-Launcher.ballY > distance) {
            result -= Launcher.window.getHeight()-Launcher.ballY-distance;
        } else {
            result -= distance;
        }
        return result;
    }

    @Override
    public void run() {
        super.run();
        while (Launcher.running) {
            synchronized (this) {
                try {
                    Launcher.player1.Y = autoBot(200);
                    Launcher.player2.Y = autoBot(Launcher.window.getWidth()-215);
                    if (Launcher.ballX > 200 && Launcher.ballX < 215) {
                        if (Launcher.ballY > Launcher.player1.Y - 25 && Launcher.ballY < Launcher.player1.Y + 25) {
                            Launcher.ballDirectionX *= -1;
                            Launcher.ballDirectionY *= -1;
                        }
                    } else if (Launcher.ballX > Launcher.window.getWidth()-215 && Launcher.ballX < Launcher.window.getWidth()-200) {
                        if (Launcher.ballY > Launcher.player2.Y - 25 && Launcher.ballY < Launcher.player2.Y + 25) {
                            Launcher.ballDirectionX *= -1;
                            Launcher.ballDirectionY *= -1;
                        }
                    } else if (Launcher.ballX < 200) {
                        Launcher.player2.score += 1;
                        System.out.println(Launcher.player1.score + " : " + Launcher.player2.score);
                        Launcher.ballY = Launcher.window.getHeight() / 2;
                        Launcher.ballX = Launcher.window.getWidth() / 2;
                        Launcher.ballDirectionX *= -1;
                        Launcher.ballDirectionY *= -1;
                        if (Launcher.player2.score >= 10) {
                            Launcher.running = false;
                        }
                    } else if (Launcher.ballX > Launcher.window.getWidth() - 200) {
                        Launcher.player1.score += 1;
                        System.out.println(Launcher.player1.score + " : " + Launcher.player2.score);
                        Launcher.ballY = Launcher.window.getHeight() / 2;
                        Launcher.ballX = Launcher.window.getWidth() / 2;
                        Launcher.ballDirectionX *= -1;
                        Launcher.ballDirectionY *= -1;
                        if (Launcher.player1.score >= 10) {
                            Launcher.running = false;
                        }
                    } else if (Launcher.ballY <= 0) {
                        Launcher.ballDirectionY *= -1;
                    } else if (Launcher.ballY >= Launcher.window.getHeight()) {
                        Launcher.ballDirectionY *= -1;
                    }
                    Launcher.ballX += Launcher.ballDirectionX;
                    Launcher.ballY += Launcher.ballDirectionY;
                    Launcher.frame.repaint();
                    wait(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
