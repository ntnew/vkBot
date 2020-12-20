package core.modules;

import vk.VKServer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    public static void createNewFile(String fileName) {
        try {
            File f = new File(getLettersPath(fileName));
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void writeLetter(String fileName, String data) {
        try {
            Files.write(Paths.get(getLettersPath(fileName)),
                    data.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLetter(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(getLettersPath(fileName)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("\n", lines);
    }
    /*
     * Очистить txt
     */
    public static void clearLetter(String fileName) {
        try {
            Files.write(Paths.get(getLettersPath(fileName)),
                    "".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Прочитать txt
     */
    public static String readTxtFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(getResourcesPath(fileName)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("\n", lines);
    }

    /*
     * Прочитать txt с клавиатурой
     */
    public static String readKeyboardFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(getKeyboardPath(fileName)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("\n", lines);
    }


    private static String getLettersPath(String fileName){
        return VKServer.programPath + VKServer.pathToLetters + "/" + fileName + ".txt";
    }
    private static String getResourcesPath(String fileName){
        return VKServer.programPath + VKServer.resourcesPath + "/" + fileName + ".txt";
    }
    private static String getKeyboardPath(String fileName){
        return VKServer.programPath + VKServer.resourcesPath + "/" + fileName + ".json";
    }
}
