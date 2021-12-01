import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.TextArea;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.Thread;
import java.util.Scanner;
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

	private static Robot robot;
	private static int delay;
  
  //create new robot to click
	public AutoClicker() {
		try{
			robot = new Robot();
		} catch(Exception e) {
			e.printStackTrace();
		}
		delay = 300;
  }
  
  public static void sleep(int x){
    try{
      Thread.sleep(x);
    } catch(Exception e){
      e.printStackTrace();
    }
  }
  
  //press button with mouse
  public static void clickMouse(int button) {
    try{
      robot.mousePress(button);
      robot.delay(50);
      robot.mouseRelease(button);
      robot.delay(delay-50);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  //set delay after click
  public static void setDelay(int ms){
    delay = ms;
  }

  //move cursor to position x, y
  public static void cursorMove(int xCoord, int yCoord) {
    try {
      Robot robot = new Robot();
      robot.mouseMove(xCoord, yCoord);
    }catch (AWTException e) {
      System.out.println("Low level input control is not allowed " + e.getMessage());
    }
  }

  //press F
  public static void pressF() {
    robot.keyPress(KeyEvent.VK_F);
    AutoClicker.sleep(GenerateRandom.main(20,40));
    robot.keyRelease(KeyEvent.VK_F);
  }

  //press X
  public static void pressX() {
    robot.keyPress(KeyEvent.VK_X);
    AutoClicker.sleep(GenerateRandom.main(20,40));
    robot.keyRelease(KeyEvent.VK_X);
  }

  //press Z
  public static void pressZ() {
    robot.keyPress(KeyEvent.VK_Z);
    AutoClicker.sleep(GenerateRandom.main(20,40));
    robot.keyRelease(KeyEvent.VK_Z);
  }

  //press S
  public static void pressS() {
    robot.keyPress(KeyEvent.VK_S);
    AutoClicker.sleep(GenerateRandom.main(20,40));
    robot.keyRelease(KeyEvent.VK_S);
  }

  public static void attack(int x, int y){
    long startTime = System.nanoTime();
    Screenshot screenshot = new Screenshot();
    AutoClicker.setDelay(75);
    //read images
    BufferedImage fight = null;
    BufferedImage fightpattern = null;
    File FightFile = new File("fight.jpg");
    File FightpatternFile = new File("fightpattern.jpg");

    //move cursor and attack
    AutoClicker.cursorMove(x, y);
    AutoClicker.sleep(GenerateRandom.main(80,110));
    AutoClicker.clickMouse(InputEvent.BUTTON1_DOWN_MASK);
    AutoClicker.sleep(GenerateRandom.main(200,400));
    AutoClicker.clickMouse(InputEvent.BUTTON1_DOWN_MASK);

    //check if the monster has been attacked by me
    int counter = 0;
    while(true){
      //load screenshot and pattern
      screenshot.makeScreenshot("fight");
      try{fight = ImageIO.read(FightFile);fightpattern = ImageIO.read(FightpatternFile);} catch(Exception e){e.printStackTrace();}
      Color fightPixel = new Color(fight.getRGB(718, 744));
      Color fightpatternPixel = new Color(fightpattern.getRGB(718, 744));
      //search for white flag on the screen
      if(pixelActions.pixelCompare(fightPixel, fightpatternPixel) < 20){
        System.out.print("Zaatakowano E2! ");
        break;
      }
      //after 6 seconds return
      if(counter > 6){
        System.out.print("Utracono E2! ");
        break;
      }
      
      AutoClicker.sleep(GenerateRandom.main(800,1100));
      counter++;
    }

    //output time
    LocalTime.main(null);

    //enable fast fight
    AutoClicker.pressF();
    AutoClicker.sleep(GenerateRandom.main(1000,1300));

    //close fight window
    AutoClicker.pressZ();
    AutoClicker.sleep(GenerateRandom.main(1000,1300));

    //move cursor to safe position
    AutoClicker.cursorMove(400, 1000);

    //character front must be visible
    AutoClicker.pressS();
  }

  //output enemy and time , attack
  public static void enemyDetected(int xEnemy, int yEnemy){
    System.out.print("Wykryto E2! ");
    LocalTime.main(null);
    AutoClicker.attack(xEnemy, yEnemy);
  }
}