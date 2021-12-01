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

public class cameraActions {
    public static Pair main(){
        BufferedImage image = null;
        BufferedImage characterpattern = null;
        File CaptureFile = new File("capture.jpg");
        File CharacterpatternFile = new File("characterpattern.jpg");
        try{
            image = ImageIO.read(CaptureFile);
            characterpattern = ImageIO.read(CharacterpatternFile);} 
        catch(Exception e){e.printStackTrace();}

        int widthbegin = 20; // zmiana z 260 dnia 10.11.2020
        int widthend = 1669;
        int heightbegin = 190;
        int heightend = 980;
        
        Pair characterposition = new Pair(0, 0);
        for (int row = heightbegin; row < heightend; row++) {
            for (int col = widthbegin; col < widthend; col++) {
                Color c = new Color(image.getRGB(col, row));
                Color p = new Color(characterpattern.getRGB(1181, 573)); //1181 573 na fobosie, 1236 807 pandora
                if(pixelActions.pixelCompare(c, p) < 50){
                    if(pixelActions.pixelCheck(image, characterpattern, col, row,1181,573,3,3) < 150){
                        characterposition = new Pair(col, row);
                    }
                }
            }
        }
        image = null;
        characterpattern = null;
        return characterposition;
    }
}