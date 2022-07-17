package bot;

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
}