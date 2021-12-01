import java.awt.event.InputEvent;
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



public class elitesCompare {

    public static void main(final String[] args){
        AutoClicker action = new AutoClicker();
        action.setDelay(75);
        Screenshot screenshot = new Screenshot();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        BufferedImage elite = null;
        BufferedImage elite1 = null;
        BufferedImage elite2 = null;
        File EliteFile = new File("elite.jpg");
        File Elite1File = new File("elite1.jpg");
        File Elite2File = new File("elite2.jpg");

        try{
            elite = ImageIO.read(EliteFile);
            elite1 = ImageIO.read(Elite1File);
            elite2 = ImageIO.read(Elite2File);

        } catch(Exception e){
            e.printStackTrace();
        }

        while (running)
        {   
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            Color aColor = new Color(elite.getRGB(x-64, y+96));
            Color bColor = new Color(elite1.getRGB(x, y));
            Color cColor = new Color(elite2.getRGB(x, y));
            System.out.println("RGB E0: " + aColor.getRed() + " " + aColor.getGreen() + " " + aColor.getBlue());
            System.out.println("RGB E1: " + bColor.getRed() + " " + bColor.getGreen() + " " + bColor.getBlue());
            System.out.println("RGB E2: " + cColor.getRed() + " " + cColor.getGreen() + " " + cColor.getBlue());
            

            boolean Monster = false;
            int xMonster = 0;
            int yMonster = 0;
            /*
            for (int row = heightbegin; row < heightend; row++) {
                for (int col = widthbegin; col < widthend; col++) {
                        Color c = new Color(image.getRGB(col, row));
                        Color p = new Color(pattern.getRGB(1238, 805));
                        if(pixelCompare(c, p) < 10){
                            if(pixelCheck(image, pattern, col, row)){
                                System.out.println("Wykryto E2!");
                                Monster = true;
                                xMonster = col;
                                yMonster = row;
                            }
                        }
                }
            }
            */
    }
        }
}