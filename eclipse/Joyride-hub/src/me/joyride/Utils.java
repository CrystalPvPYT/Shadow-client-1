package me.joyride;

import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Utils
{
    public static Properties properties;
    public static String hubServer;
    public static String permission;
    public static String command;
    public static String[] aliases;
    public static String message;
    public static String alreadyConnectedMessage;
    
    public static void loadProperties() {
        try (final FileReader reader = new FileReader("plugins/Pixelhub/config.properties")) {
            Utils.properties.load(reader);
        }
        catch (FileNotFoundException e3) {
            File f = new File("plugins/Pixelhub");
            f.mkdirs();
            f = new File("plugins/Pixelhub/config.properties");
            try {
                Files.copy(Main.class.getResourceAsStream("/config.properties"), f.toPath(), new CopyOption[0]);
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    
    static {
        Utils.properties = new Properties();
    }
}
