package DesktopManager.EntityUtils;

import BotService.core.modules.Utils;
import DesktopManager.Entities.Bot;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BotUtils {

  static String botVariableFolder = System.getProperty("user.dir") + "/var";

  public static void initializeBotSettings(Bot bot) {
    try {
      File file = new File(String.format("%1$s/%2$s", botVariableFolder, bot.getName()));
      if (file.createNewFile()) {
        System.out.println("File created");
      } else {
        System.out.println("File already exists");
      }

      Files.write(Paths.get(file.getAbsolutePath()),
          Utils.getGsonInstance().toJson(bot).getBytes(StandardCharsets.UTF_8),
          StandardOpenOption.APPEND);

    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public static List<Bot> getLocalBotSettings() throws IOException {
    File folder = new File(botVariableFolder);
    List<Bot> bots = new ArrayList<>();
    for (final File fileEntry : folder.listFiles()) {
      List<String> lines = Files.readAllLines(Paths.get(fileEntry.getAbsolutePath()), StandardCharsets.UTF_8);
      bots.add(Utils.getGsonInstance().fromJson(String.join("\n", lines), Bot.class));
    }
    return bots;
  }
}
