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

public class pixelActions{

    private static final int maxPixelDifference = 38;
    
    //  Return the RGB difference between pixels 
    public static int pixelDifference(Color a, Color b){
        int Difference = 0;
        Difference += Math.abs(a.getRed()-b.getRed());
        Difference += Math.abs(a.getGreen()-b.getGreen());
        Difference += Math.abs(a.getBlue()-b.getBlue());
        return Difference;
    }

    // Return the RGB difference between set of pixels on 2 images
    public static int pixelsDifference(BufferedImage image, BufferedImage pattern, int col, int row, int patterncol, int patternrow, int wide, int high){
        int sum = 0;
    
        for(int i = 0; i < wide; i++) {
            for(int j = 0; j < high; j++) {
                Color imagePixel = new Color(image.getRGB(col + i, row + j));
                Color patternPixel = new Color(pattern.getRGB(patterncol + i, patternrow + j));
                sum += pixelDifference(imagePixel, patternPixel);
            }
        }

        return sum;
    }

    public static boolean matches(BufferedImage image, BufferedImage pattern, int col, int row) {
        return pixelsDifference(image, pattern, col, row, 0, 0, 7, 7) < 49 * maxPixelDifference;
    }

    public static boolean matchesPixel(BufferedImage image, BufferedImage pattern, int col, int row) {
        return pixelsDifference(image, pattern, col, row, 0, 0, 2, 2) < 4 * maxPixelDifference;
    }
}