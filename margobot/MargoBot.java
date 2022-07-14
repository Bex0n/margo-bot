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



public class MargoBot {

    public AutoClicker action;

    public MargoBot() {
        this.action = new AutoClicker();
    }

    public static String projectPath() {
        File empty = new File("");
        return empty.getAbsolutePath();
    }

    public void scanForMonster(BufferedImage screenshot, BufferedImage monsterPattern) {
        // Window size - 1,113,110 pixels total.
        final int screenWidthStart = 260;
        final int screenWidthEnd = 1669;
        final int screenHeightStart = 190;
        final int screenHeightEnd = 980;

        for (int row = screenHeightStart; row < screenHeightEnd; row++)
            for (int column = screenWidthStart; column < screenWidthEnd; column++)
                if(pixelActions.matches(screenshot, monsterPattern, column, row)) {
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print(pixelActions.pixelDifference(new Color(monsterPattern.getRGB(i, j)), new Color(screenshot.getRGB(column + i, row + j))) + " ");
                        }
                        System.out.println();
                    }
                    System.out.println(column + " " + row);
                    action.enemyDetected(column, row);
                    return;
                }
        System.out.println("No monster");
        return;
    }

}