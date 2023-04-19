import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndMess extends LifeCount{
    double widGui = 209.6;
    int widGuiAsInt = (int) widGui;
    int heiGui = 118;
    int i = 0;
    ScoreCount scoreCount = new ScoreCount();
    UmbMan umbMan = new UmbMan();
    private String endMess = "";
    JFrame frame = new JFrame("Show message box");
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();


    public EndMess() {
        int xCoord = (int) ((dimension.getWidth()) - (0.5 * widGuiAsInt));
        int yCoord = (int) ((dimension.getHeight()) - (0.5 * heiGui));
        frame.setLocation(xCoord, yCoord);
        Timer timer = new Timer(100, new TimerListener());
        timer.start();
    }


    void endGameWin() {
        endMess = "You scored " + scoreCount.score + " well done.";
        JOptionPane.showMessageDialog(frame,endMess);
    }

    void endGameLose() {
        endMess = "You scored " + scoreCount.score + " poorly done.";
        JOptionPane.showMessageDialog(frame,endMess);
    }

    public void disEndGameMess() {
        int scrToWin = 5000;
        if (umbMan.person.ball.lifeCount.livesLeft == 0) {
            while (i == 0) {
                i = 1;
                if (umbMan.person.scoreCount.score > scrToWin) {
                    endGameWin(); }
                else {
                   endGameLose();
                }
            }
        }
    }


    public static void main(String[] args) {
        new EndMess();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            disEndGameMess();
        }
    }
}


