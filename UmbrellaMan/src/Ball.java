import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends JPanel implements KeyListener {

    int xPosBall = 10;
    int yPosBall = 10;
    int widBall = 10;
    private int i = 0;
    private int vXBall = 15;
    private int vYBall = 15;
    LifeCount lifeCount = new LifeCount();
    //EndMess endMess = new EndMess();
    //private ScoreCount scoreCount = new ScoreCount();

    public void paintComponent(Graphics g) {
        int heiBall = 10;
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g.setColor(Color.BLACK);
        g.fillOval(xPosBall, yPosBall, widBall, heiBall);
        lifeCount.paintComponent(g2d);
    }

    public void reverseBallVelX() {
        vXBall = -vXBall;
    }

    public void reverseBallVelY() {
        vYBall = -vYBall;
    }

    public void reverseBall() {
        reverseBallVelX();
        reverseBallVelY();
    }


    public void ballHitScr() {

        int xEdgScr = 0;
        int heiScr = 590;
        int widScr = 1000;
        int heiPer = 75;
        xPosBall += vXBall;
        yPosBall += vYBall;

        if (yPosBall <= 10 || xPosBall >= widScr || xPosBall <= xEdgScr || yPosBall >= heiScr - heiPer) {
            reverseBallVelY();

            if (yPosBall >= heiScr - 75)
                lifeCount.liveDec();
            if (xPosBall >= widScr || xPosBall <= xEdgScr) {
                reverseBallVelX();
            }
        }
    }

    public Ball() {
        Thread moveBallThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                   isRun();
                    try {
                        Thread.sleep(100);
                    } catch (Exception ex) {
                    }
                }
            }
        });
        moveBallThread.start();
    }

    public void isRun() {
        ballHitScr();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void incBallSpd() {
        double incVBall = 0.75;
        int incVBallAsInt = (int) incVBall;
        vXBall = vXBall + incVBallAsInt;
        vYBall = vXBall + incVBallAsInt;
    }
}

