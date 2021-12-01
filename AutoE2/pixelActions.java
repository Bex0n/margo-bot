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
    
    //return the sum of difference in RGB values
    public static int pixelCompare(Color a, Color b){
        int Difference = 0;
        Difference += Math.abs(a.getRed()-b.getRed());
        Difference += Math.abs(a.getGreen()-b.getGreen());
        Difference += Math.abs(a.getBlue()-b.getBlue());
        return Difference;
    }

    //check if the pixel set belongs to pattern
    public static int pixelCheck(BufferedImage image, BufferedImage pattern, int col, int row, int pcol, int prow, int wide, int high){
        int sum = 0;
        
        // a - x in coordinate system
        // b - y in coordinate system
        int a = wide;
        int b = high;
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                Color d = new Color(image.getRGB(col+i, row+j));
                Color e = new Color(pattern.getRGB(pcol+i, prow+j));
                sum += pixelCompare(d,e);
            }
        }
        return sum;
    }
}