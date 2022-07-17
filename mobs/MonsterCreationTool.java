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

public class MonsterCreationTool {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainPath = new File("").getAbsolutePath();

        System.out.println("Monster creation tool");

        System.out.println("Enter monster name");
        String name = scanner.nextLine();

        System.out.println("Enter screenshot's name in main folder.");
        String screenshot = scanner.nextLine();

        System.out.println("Enter (x, y) coordinates of left-corner pixel.");
        int coordinateX = scanner.nextInt();
        int coordinateY = scanner.nextInt();
        scanner.close();

        Monster.createMonster(name, mainPath + "\\" + screenshot, coordinateX, coordinateY);

        System.out.println("Monster created successfully");
    }
}