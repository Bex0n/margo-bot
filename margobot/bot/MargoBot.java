package bot;

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
                attack(100, 100);
                // if(pixelActions.matches(screenshot, monsterPattern, column, row)) {
                //     for (int i = 0; i < 7; i++) {
                //         for (int j = 0; j < 7; j++) {
                //             System.out.print(pixelActions.pixelDifference(new Color(monsterPattern.getRGB(i, j)), new Color(screenshot.getRGB(column + i, row + j))) + " ");
                //         }
                //         System.out.println();
                //     }
                //     System.out.println(column + " " + row);
                //     System.out.println("Monster Detected!");
                //     attack(column, row);
                //     return;
                // }
        System.out.println("No monster");
        return;
    }

    // Attack a monster on position (x, y).
    public void attack(int x, int y) {
        AutoClicker autoclicker = new AutoClicker();

        // Set path to fight screenshots.
        BufferedImage fight = null;
        BufferedImage fightpattern = null;
        File FightFile = new File(MargoBot.projectPath() + "/bot/fight/screenshot.jpg");
        File FightpatternFile = new File(MargoBot.projectPath() + "/bot/fight/pattern.jpg");
        try {
            fightpattern = ImageIO.read(FightpatternFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Move cursor and attack
        autoclicker.cursorMove(x, y);
        autoclicker.sleep(autoclicker.normalTime());
        autoclicker.clickMouse(InputEvent.BUTTON1_DOWN_MASK);

        // Check if the monster has been attacked by my character.
        int counter = 0;
        while (counter < 6) {
            Screenshot.makeScreenshot(new File(MargoBot.projectPath() + "/bot/fight/screenshot").getAbsolutePath());
            try {
                fight = ImageIO.read(FightFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Search for fight pixels on the screenshot.
            if (pixelActions.matchesPixel(fight, fightpattern, 718, 744)) {
                System.out.println("Zaatakowano E2! ");
                break;
            }
            autoclicker.sleep(autoclicker.longTime());
            counter++;
        }
        if (counter >= 6) {
            System.out.println("Utracono E2!");
            return;
        }
        autoclicker.pressF();
        autoclicker.sleep(autoclicker.longTime());

        autoclicker.pressZ();
        autoclicker.sleep(autoclicker.longTime());

        autoclicker.cursorMove(400, 1000);
        return;
    }

}