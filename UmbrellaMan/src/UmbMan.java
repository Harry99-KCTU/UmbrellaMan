import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UmbMan extends JFrame {
    JFrame game = new JFrame();
    JFrame mss = new JFrame("Show message box");
    int i = 0;

    Person person = new Person();
    private String endMess = "";

    public UmbMan() {
        double widGuiMss = 209.6;
        int widGuiMssAsInt = (int) widGuiMss;
        int heiMssGui= 118;
        int widGui = 1048;
        int heiGui = 590;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //XCoord and yCoord includes equation for getting middle of gui on the middle of the screen
        int xCoord = (int) (((dimension.getWidth() - getWidth()) / 2) - (0.5 * widGui));
        int yCoord = (int) (((dimension.getHeight() - getHeight()) / 2) - (0.5 * heiGui));
        int xCoordMess = (int) ((dimension.getWidth()) - (0.5 * widGuiMssAsInt));
        int yCoordMess = (int) ((dimension.getHeight()) - (0.5 * heiMssGui));
        mss.setLocation(xCoordMess, yCoordMess);
        game.setTitle("Umbrella Man");
        game.setResizable(false);
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(widGui, heiGui);
        game.setLocation(xCoord, yCoord);
        game.setVisible(true);
        game.setBackground(Color.black);
        game.add(person);
        Timer timer = new Timer(100, new TimerListener());
        timer.start();
    }


    public static void main(String[] args) {
        new UmbMan();
    }

    public void exitScr() {


        if (person.ball.lifeCount.livesLeft == 0) {
            while(i == 0) {
               // mss.setVisible(true);
               // disEndGameMess();
                i = 1;
                game.dispose();
                new MainGui();
            }
        }
    }

    public void disEndGameMess() {
        int scrToWin = 5000;

        if (person.ball.lifeCount.livesLeft == 0) {
            while (i == 0) {
                i = 1;
                if (person.scoreCount.score > scrToWin) {
                    endGameWin();
                   }
                else {
                    endGameLose();
                }
            }
        }
    }

    void endGameWin() {
        endMess = "You scored " + person.scoreCount.score + " well done.";
        JOptionPane.showMessageDialog(mss,endMess);
    }

    void endGameLose() {
        endMess = "You scored " + person.scoreCount.score + " poorly done.";
        JOptionPane.showMessageDialog(mss,endMess);
    }

   private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            exitScr();
            }
        }
}




