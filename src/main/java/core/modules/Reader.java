package core.modules;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static String programPath = System.getProperty("user.dir");

    public static String readTxtFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(programPath + "\\src\\main\\resources\\" + fileName),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join("\n", lines);
    }

}
