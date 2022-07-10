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
        Path monsterPath = Paths.get(projectPath + "/E2/Alghul/pattern.jpg");
        BufferedImage screenshot = Screenshot.readScreenshot(screenshotPath);
        BufferedImage pattern = Screenshot.readScreenshot(monsterPath);

        System.out.println(pixelActions.pixelDifference(new Color(pattern.getRGB(2, 2)), new Color(screenshot.getRGB(760, 567))));
        System.out.println(pixelActions.pixelsDifference(screenshot, pattern, 758, 565, 0, 0, 3, 3));
    }
}
