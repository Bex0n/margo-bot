import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.TextArea;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.Thread;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.JFrame;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.*;


public class AutoClicker {

    private Robot robot;
    private int delay;
    private int short_delay;
    private int long_delay;

    // Return random value in miliseconds around average click time.
    public int shortTime() {
        Random random = new Random();
        return short_delay + random.nextInt(20);
    }

    // Return random value in miliseconds around average post-click time.
    public int normalTime() {
        Random random = new Random();
        return delay + random.nextInt(100);
    }

    // Return random value in miliseconds around 1 second.
    public int longTime() {
        Random random = new Random();
        return long_delay + random.nextInt(400);
    }

    

    // Create new autoclicker.
    public AutoClicker() {
        try {
            this.robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.delay = 250;
        this.short_delay = 30;
        this.long_delay = 800;
    }

    // Make autoclicker wait x miliseconds.
    public void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Press mouse button.
    public void clickMouse(int button) {
        try {
            robot.mousePress(button);
            robot.delay(shortTime());
            robot.mouseRelease(button);
            robot.delay(shortTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Press F key
    public void pressF() {
        robot.keyPress(KeyEvent.VK_F);
        sleep(shortTime());
        robot.keyRelease(KeyEvent.VK_F);
    }

    // Press X key
    public void pressX() {
        robot.keyPress(KeyEvent.VK_X);
        sleep(shortTime());
        robot.keyRelease(KeyEvent.VK_X);
    }

    // Press Z key
    public void pressZ() {
        robot.keyPress(KeyEvent.VK_Z);
        sleep(shortTime());
        robot.keyRelease(KeyEvent.VK_Z);
    }

    // Press S key
    public void pressS() {
        robot.keyPress(KeyEvent.VK_S);
        sleep(shortTime());
        robot.keyRelease(KeyEvent.VK_S);
    }

    // Set delay.
    public void setDelay(int ms) {
        delay = ms;
    }

    // Move cursor to position (x, y).
    public void cursorMove(int xCoord, int yCoord) {
        try {
            Robot robot = new Robot();
            robot.mouseMove(xCoord, yCoord);
        } catch (AWTException e) {
            System.out.println("Low level input control is not allowed " + e.getMessage());
        }
    }

    // Attack a monster on position (x, y).
    public void attack(int x, int y) {
        // Create time and screenshot class
        long startTime = System.nanoTime();
        Screenshot screenshot = new Screenshot();
        setDelay(75);

        // Set path to fight screenshots
        BufferedImage fight = null;
        BufferedImage fightpattern = null;
        File FightFile = new File("fight.jpg");
        File FightpatternFile = new File("fightpattern.jpg");

        // Move cursor and attack
        cursorMove(x, y);
        sleep(normalTime());
        clickMouse(InputEvent.BUTTON1_DOWN_MASK);

        // Check if the monster has been attacked by my character
        int counter = 0;
        while (true) {
            //load screenshot and pattern
            Screenshot.makeScreenshot("fight");
            try {
                fight = ImageIO.read(FightFile);
                fightpattern = ImageIO.read(FightpatternFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Color fightPixel = new Color(fight.getRGB(718, 744));
            Color fightpatternPixel = new Color(fightpattern.getRGB(718, 744));
            //search for white flag on the screen
            if (pixelActions.pixelDifference(fightPixel, fightpatternPixel) < 20) {
                System.out.println("Zaatakowano E2! ");
                break;
            }
            //after 6 seconds return
            if (counter > 6) {
                System.out.println("Utracono E2! ");
                break;
            }

            sleep(longTime());
            counter++;
        }

        //enable fast fight
        pressF();
        sleep(longTime());

        //close fight window
        pressZ();
        sleep(longTime());

        //move cursor to safe position
        cursorMove(400, 1000);

        //character front must be visible
        pressS();
    }

    //output enemy and time , attack
    public void enemyDetected(int xEnemy, int yEnemy) {
        System.out.println("Monster Detected!");
        attack(xEnemy, yEnemy);
    }
}