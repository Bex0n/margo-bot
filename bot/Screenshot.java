package bot;

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystem;
  
public class Screenshot { 
    public static void makeScreenshot(String folder) { 
        try { 
            Robot robot = new Robot(); 
    
            // It saves screenshot to desired path 
            String path = folder + ".jpg"; 
    
            // Used to get ScreenSize and capture image 
            Rectangle capture =  
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
            BufferedImage Image = robot.createScreenCapture(capture); 
            ImageIO.write(Image, "jpg", new File(path));
            Image = null;
            capture = null;
        }
        catch (AWTException | IOException ex) { 
            System.out.println(ex); 
        } 
    }

    public static BufferedImage readScreenshot(Path path) {
        if(Files.exists(path))
            try {
                Thread.sleep(500); 
                return ImageIO.read(new File(path.toString()));
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        return null;
    }

    public static BufferedImage makeAndReadScreenshot() {
        makeScreenshot(new File(MargoBot.projectPath() + "/bot/screen/capture").getAbsolutePath());
        String projectPath = MargoBot.projectPath();
        Path screenshotPath = Paths.get(projectPath + "/bot/screen/capture.jpg");
        BufferedImage screenshot = Screenshot.readScreenshot(screenshotPath);

        return screenshot;
    }

    public static void main(final String[] args) {
        System.out.println("Screenshot in 3 seconds.");
        try {
            Thread.sleep(3000); 
        }
        catch (InterruptedException ex) { 
            System.out.println(ex); 
        } 
        makeScreenshot(new File(MargoBot.projectPath() + "/bot/screen/capture").getAbsolutePath());
        System.out.println("Screenshot done.");
    }
} 