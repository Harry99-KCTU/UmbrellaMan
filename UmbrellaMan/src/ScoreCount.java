import javax.swing.*;
import java.awt.*;

public class ScoreCount extends JPanel {

    int score;

    public void paintComponent(Graphics g) {

        int xPosScrCnt = 10;
        int yPosScrCnt = 20;
        int sizeOfTxt = 20;

        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g.setColor(Color.BLACK);
        g.setFont(new Font("serif", Font.ITALIC, sizeOfTxt));
        g.drawString("Score: " + score, xPosScrCnt, yPosScrCnt);
    }

    public void scrHit() {
        int scoreHit = 50;
          score += score + scoreHit;
        }

     public void scrInc() {
        score++;
     }
}

