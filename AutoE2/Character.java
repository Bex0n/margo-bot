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


public class Character {

    // Coordinates of character's pixel in characterpattern.jpg.
    private static final int characterX = 1181;
    private static final int characterY = 573;

    // Scan character once, return position (0, 0) if not found.
    public static Pair tryToScan() {

        BufferedImage screenshot = null;
        BufferedImage characterpattern = null;
        File CaptureFile = new File("capture.jpg");
        File CharacterPatternFile = new File("characterpattern.jpg");

        Screenshot.makeScreenshot("capture");

        try {
            screenshot = ImageIO.read(CaptureFile);
            characterpattern = ImageIO.read(CharacterPatternFile);
        } 
        catch(Exception e){e.printStackTrace();}

        int screenWidthStart = 20; 
        int screenWidthEnd = 1669;
        int screenHeightStart = 190;
        int screenHeightEnd = 980;

        for (int row = screenHeightStart; row < screenHeightEnd; row++)
            for (int column = screenWidthStart; column < screenHeightEnd; column++) {
                Color analyzedPixel = new Color(screenshot.getRGB(column, row));
                Color characterPatternPixel = new Color(characterpattern.getRGB(characterX, characterY));
                if(pixelActions.pixelDifference(analyzedPixel, characterPatternPixel) < 50)
                    if(pixelActions.pixelsDifference(screenshot, characterpattern, column, row, characterX, characterY, 3, 3) < 150)
                        return new Pair(column, row);
            }

        return new Pair(0, 0);
    }

    // Scan a character and return his coordinates.
    public static Pair scan(AutoClicker action) {
        Pair characterCoordinates = new Pair(0, 0);
        while (characterCoordinates.getFirst() == 0){
            System.out.println("Character not found. Scanning again in 1 second");
            action.sleep(1000);
            characterCoordinates = Character.tryToScan();
        }
        System.out.println("Character successfully scanned.");

        return characterCoordinates;
    }
}