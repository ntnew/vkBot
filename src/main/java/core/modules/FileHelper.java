package core.modules;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static core.modules.Reader.programPath;

public class FileHelper {
    private static String pathToLetters = "\\src\\main\\Reservers\\";

    public static void createNewFile(String fileName) {
        try {
            File f = new File(getFileNamePath(fileName));
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
            Files.write(Paths.get(getFileNamePath(fileName)),
                    data.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLetter(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(getFileNamePath(fileName)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("\n", lines);
    }

    public static void clearLetter(String fileName) {
        try {
            Files.write(Paths.get(getFileNamePath(fileName)),
                    "".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getFileNamePath(String fileName){
        return programPath + pathToLetters + fileName + ".txt";
    }
}
