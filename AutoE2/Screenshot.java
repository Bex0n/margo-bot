import java.awt.AWTException; 
import java.awt.Rectangle; 
import java.awt.Toolkit; 
import java.awt.Robot; 
import java.awt.image.BufferedImage; 
import java.io.IOException; 
import java.io.File; 
import javax.imageio.ImageIO;
import java.awt.event.InputEvent;
import java.lang.Thread;
import java.util.Scanner; 
  
public class Screenshot { 
    public static final long serialVersionUID = 1L; 
    //public static void main(String[] args)
    public void makeScreenshot(String k) 
    { 
        for(int i=0;i<1;i++){
            try { 
                Thread.sleep(2000); 
                Robot r = new Robot(); 
    
                // It saves screenshot to desired path 
                 String path = "C:/Users/jakub/Desktop/AutoE2/" + "capture" + ".jpg"; 
    
                // Used to get ScreenSize and capture image 
                Rectangle capture =  
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
                BufferedImage Image = r.createScreenCapture(capture); 
                ImageIO.write(Image, "jpg", new File(path));
                Image = null;
                capture = null;
            }
            catch (AWTException | IOException | InterruptedException ex) { 
                System.out.println(ex); 
            }
        } 
    } 
} 