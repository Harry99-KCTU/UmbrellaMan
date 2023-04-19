import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame implements ActionListener {

          private JFrame mnu = new JFrame();
          private JButton srtBut = new JButton("Start Game");
          private JButton credBut = new JButton("Credits");

         public MainGui() {
                JPanel optBut = new JPanel();
                //Sets height and width of gui
                int widGui = 1048;
                int heiGui = 590;
                mnu.setTitle("Main Menu");
                mnu.setSize(widGui,heiGui);
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                //XCoord and yCoord includes equation for getting middle of gui on the middle of the screen
                int xCoord = (int) (((dimension.getWidth() - optBut.getWidth()) / 2) - (0.5 * widGui));
                int yCoord = (int) (((dimension.getHeight() - optBut.getHeight()) / 2) - (0.5 * heiGui));
                //CODE FOR JPANEL
                // Adds button for starting UmbMan.
                optBut.add(srtBut);
                optBut.setBackground(Color.BLACK);
                // Adds button for credits.
                optBut.add(credBut);
                optBut.setSize(widGui, heiGui);
                mnu.add(optBut);
                //CODE FOR JFRAME
                mnu.setTitle("Main Menu");
                mnu.setResizable(false);
                mnu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                mnu.setSize(widGui, heiGui);
                mnu.setLocation(xCoord, yCoord);
                mnu.setVisible(true);
                //CODE FOR BUTTONS
                srtBut.addActionListener(this);
                credBut.addActionListener(this);
        }
                public void actionPerformed(ActionEvent e){
                        //Plays UmbMan when play button is pressed.

                        if (e.getSource() == srtBut) {
                                //Links main menu gui to the game of the gui.
                                 new UmbMan();
                                 //Removes main menu when start button is pressed.
                                 mnu.dispose();
                        }

                        //Closes application when button is pressed.
                        else if (e.getSource() == credBut) {
                                System.exit(0);
                        }
                }

    public static void main(String[] args) {
             new MainGui();
     }
  }

