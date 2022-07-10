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

public class Test {
    public static void main(final String[] args) {
        String projectPath = AutoClickerMain.projectPath();
        Path screenshotPath = Paths.get(projectPath + "/capture.jpg");
        Path monsterPath = Paths.get(projectPath + "/E2/Szkielet rycerza/pattern.jpg");
        BufferedImage screenshot = Screenshot.readScreenshot(screenshotPath);
        BufferedImage pattern = Screenshot.readScreenshot(monsterPath);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(pixelActions.pixelDifference(new Color(pattern.getRGB(i, j)), new Color(screenshot.getRGB(1312 + i, 350 + j))) + " ");
            }
            System.out.println();
        }
        System.out.println(pixelActions.pixelsDifference(screenshot, pattern, 1312, 350, 0, 0, 7, 7));
    }
}
