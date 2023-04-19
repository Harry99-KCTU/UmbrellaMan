import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class Person extends JPanel implements KeyListener {

    private int xPosHead = 35;
    private int yTopArm = 511;
    private int bodyX = 40;
    private int bodyY2 = 531;
    private int topUmbY = 477;
    private int lArmX = 30;
    private int rArmX = 50;
    private int topUmbX1 = 40;
    private int topUmbX2 = 60;
    private int yBotArm = 521;
    private int lLegX = 20;
    private int rLegX = 60;
    private int yBotLeg = 550;
    private int lShoeX1 = 15;
    private int lShoeX2 = 25;
    private int rShoeX1 = 55;
    private int rShoeX2 = 65;
    private int vPerson;
    private int distanceBetweenLegs = 40;

    Ball ball = new Ball();
    ScoreCount scoreCount = new ScoreCount();

    public Person() {
               Timer timer = new Timer(100, new TimerListener());
               timer.start();
               setFocusable(true);
               setFocusTraversalKeysEnabled(false);
               addKeyListener(this);
           }

    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        paintPerson(g2d);
        g2d.setColor(Color.DARK_GRAY);
        ball.paintComponent(g2d);
        scoreCount.paintComponent(g2d);
    }


    public void paintPerson(Graphics g) {
        paintHead(g);
        paintBody(g);
        paintUmbrella(g);
        paintLeftArm(g);
        paintRightArm(g);
        paintLeftLeg(g);
        paintRightLeg(g);
        g.setColor(Color.BLUE);
        paintLeftShoe(g);
        g.setColor(Color.YELLOW);
        paintRightShoe(g);
    }

    public void paintHead(Graphics g) {
        int widHead = 10;
        int heiHead = 10;
        int yPosHead = 491;
        super.paintComponent(g);
        g.fillOval(xPosHead, yPosHead,widHead,heiHead);
    }

    public void paintBody(Graphics g) {
        int bodyY1 = 501;
        g.drawLine(bodyX,bodyY1,bodyX,bodyY2);
    }

    public void paintUmbrella(Graphics g){ {
        //Draw top of umbrella.
        g.drawLine(topUmbX1,topUmbY,topUmbX2,topUmbY);
        g.drawLine(topUmbX1,topUmbY,topUmbX2,topUmbY);
        //Draw handle of umbrella.
        int umbY1 = 478;
        int umbY2 = 526;
        g.drawLine(rArmX,umbY1,rArmX,umbY2);
     }}

    public void paintLeftArm(Graphics g) {g.drawLine(lArmX,yTopArm,bodyX,yBotArm);}
    public void paintRightArm(Graphics g) {g.drawLine(rArmX,yTopArm,bodyX,yBotArm);}
    public void paintLeftLeg(Graphics g) {g.drawLine(bodyX,bodyY2,lLegX,yBotLeg);}
    public void paintRightLeg(Graphics g) {g.drawLine(bodyX,bodyY2,rLegX,yBotLeg);}
    public void paintLeftShoe(Graphics g) {g.drawLine(lShoeX1,yBotLeg,lShoeX2,yBotLeg);}
    public void paintRightShoe(Graphics g) {g.drawLine(rShoeX1,yBotLeg,rShoeX2,yBotLeg);}


    private void movePerson() {
        moveHead();
        moveBody();
        moveArms();
        moveLegs();
        moveShoes();
    }

    private void moveLegs() {
        moveLeftLeg();
        moveRightLeg();
    }

    private void moveArms() {
         moveUmbrella();
         moveLeftArm();
    }

    private void moveShoes() {
         moveLeftShoe();
         moveRightShoe();
    }

    private void moveHead() { xPosHead += vPerson; }
    private void moveBody() { bodyX += vPerson; }

    private void moveUmbrella() {
        rArmX += vPerson;
        topUmbX1 += vPerson;
        topUmbX2 += vPerson;
    }

    private void moveLeftArm(){
         lArmX += vPerson;
    }

    //Changes which arm holds the umbrella.
    private void switchArms() {
         switchHanUmb();
         switchTopUmb();
    }

    private void switchHanUmb() {
        int conLArm = lArmX;
        lArmX = rArmX;
        rArmX = conLArm;

    }

    private void switchTopUmb() {
         topUmbX1 = rArmX - 10;
         topUmbX2 = rArmX + 10;
    }

    public void moveLeftLeg() {

        //Each coordinate of x is in divisible by 10.
        if (lLegX % 10 == 0) {
            lLegX += distanceBetweenLegs + vPerson;
        }

        else  {
            lLegX -= distanceBetweenLegs - vPerson;
        }
    }

     public void moveRightLeg() {

         //- y coord LIFT LEG UP

         //Each coordinate of x is in divisible by 10.
         if (rLegX %10 ==0) {
             rLegX -= distanceBetweenLegs - vPerson;
         }

         else {
             rLegX += distanceBetweenLegs + vPerson;
         }
     }

     public void moveLeftShoe() {
         if (lShoeX1%10 ==0) {
             lShoeX1 -= distanceBetweenLegs - vPerson;
             lShoeX2 -= distanceBetweenLegs - vPerson;
         }

         else {
             lShoeX1 += distanceBetweenLegs + vPerson;
             lShoeX2 += distanceBetweenLegs + vPerson;
         }
     }

     public void moveRightShoe() {
         //Every second coordinate of x is in divisible by 10.
         if (rShoeX1%10 ==0) {
             rShoeX1 += distanceBetweenLegs + vPerson;
             rShoeX2 += distanceBetweenLegs + vPerson;
         }

         else {
             rShoeX1 -= distanceBetweenLegs - vPerson;
             rShoeX2 -= distanceBetweenLegs - vPerson;
         }
     }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            int xEdgScrL = 5;
            int xEdgScrR = 1030;


        if (key == KeyEvent.VK_A && lShoeX1 > xEdgScrL) {
                vPerson = -5;
                movePerson();

                if(lArmX < topUmbX1) {
                    switchArms();
                }
            }

            if (key == KeyEvent.VK_D && rShoeX2 < xEdgScrR) {
                vPerson = 5;
                movePerson();

                if(lArmX > topUmbX1) {
                    switchArms();
                }
            }
        }

        public class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                scoreCount.scrInc();
                collision();
                repaint();
         }
     }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void collision() {
        int widOfUmb = 1;

        //USE RANGE
        if((ball.xPosBall +- (ball.widBall * .5) >= topUmbX1) && (ball.xPosBall +- (ball.widBall * .5) <= topUmbX2)) {
            if ((ball.yPosBall + (ball.widBall * .5) + widOfUmb) >= topUmbY - (ball.widBall * .5) + widOfUmb) {
              isColl();
           }
        }
    }

    public void isColl() {
        ball.reverseBall();
        ball.incBallSpd();
        incPerSpd();
        scoreCount.scrHit();
    }

    public void incPerSpd() {
        double incVPerson = 0.5;
        int incVPersonAsInt = (int) incVPerson;
        vPerson = vPerson + incVPersonAsInt;
    }
}




