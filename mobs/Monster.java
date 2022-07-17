package mobs;

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

public class Monster {

    private static final int monsterPatternSize = 7;

    public static String mainDirectory() {
        File empty = new File("");
        return empty.getAbsolutePath();
    }

    public static BufferedImage loadMonster() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the mob to camp.");
        while(true){
            String monster = scanner.nextLine();
           String monsterPath = mainDirectory() + "/mobs/" + monster + "/pattern.jpg";

            if(Files.exists(Paths.get(monsterPath))){
                BufferedImage monsterImage = null;
                try {
                    monsterImage = ImageIO.read(new File(monsterPath));
                }
                catch(IOException exception) {
                    System.out.println(exception);
                }
                scanner.close();
                return monsterImage;
            }
            else{
                System.out.println("There is no data about this mob.");
                System.out.println("Enter another one.");
            }
        }
    }

    public static void createMonster(String name, String screenshotPath, int pixelX, int pixelY) {
        File monsterFolder = new File(mainDirectory() + "\\" + "mobs" + "\\" + name);
        String monsterPath = monsterFolder.getAbsolutePath() + "\\pattern.jpg";

        if (monsterFolder.exists()) {
            System.out.println("Directory already exists.");
        }
        else if (monsterFolder.mkdir())
            System.out.println("Directory has been created successfully.");
        else
            System.out.println("Directory cannot be created.");
        BufferedImage screenshot = null;
        try {
            screenshot = ImageIO.read(new File(screenshotPath));
        }
        catch(IOException exception) {
            System.out.println(exception);
        }

        BufferedImage monsterPattern = new BufferedImage(monsterPatternSize, monsterPatternSize, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < monsterPatternSize; i++)
            for (int j = 0; j < monsterPatternSize; j++)
                monsterPattern.setRGB(i, j, screenshot.getRGB(pixelX + i, pixelY + j));

        try {
            ImageIO.write(monsterPattern, "jpg", new File(monsterPath));
        }
        catch(IOException exception) {
            System.out.println(exception);
        }

        return;
    }
}