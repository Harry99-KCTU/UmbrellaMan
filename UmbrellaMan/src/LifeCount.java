import javax.swing.*;
import java.awt.*;

public class LifeCount extends JPanel {

    int livesLeft = 3;

    public void paintComponent(Graphics g) {
        int xPosLifeCnt = 950;
        int yPosLifeCnt = 20;
        int sizeOfTxt = 20;
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g.setColor(Color.BLACK);
        g.setFont(new Font("serif", Font.ITALIC, sizeOfTxt));
        g.drawString("Lives: " + livesLeft, xPosLifeCnt, yPosLifeCnt);
    }

     void liveDec() {
         livesLeft = --livesLeft;
     }
}