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



public class createPattern {
    public static void main(final String[] args){
        Scanner scanner = new Scanner(System.in);

        BufferedImage image = null;
        BufferedImage pattern = null;
        File CaptureFile = new File("Capture.jpg");
        File PatternFile = new File("Pattern.jpg");
        try{
            image = ImageIO.read(CaptureFile);
            pattern = ImageIO.read(PatternFile);
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Podaj współrzędne");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String path = "C:/Users/jakub/Desktop/AutoE2/Pattern.jpg";
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                
            }
        }
        ImageIO.write(Image, "jpg", new File(path));  

        System.out.println("Creating pattern complete");
    }
}