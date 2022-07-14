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

import mobs.*;
import bot.*;

public class Main {
    public static void main(final String[] args) {
        MargoBot bot = new MargoBot();

        System.out.println("---Margonem Bot---");

        // Get monster information.
        BufferedImage monsterPattern = Monster.loadMonster();

        // Start program.
        System.out.println("The program is starting in 3 seconds.");
        bot.action.sleep(3000);

        // Main loop.
        boolean running = true;
        while (running)
        {   
            BufferedImage screenshot = Screenshot.makeAndReadScreenshot();
            bot.scanForMonster(screenshot, monsterPattern);
            bot.action.sleep(1000);
        }

        System.out.println("AutoElita Complete");
    }
}
