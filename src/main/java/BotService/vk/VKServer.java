package BotService.vk;


import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import BotService.core.CommandManager;
import BotService.core.commands.ReadableCommand;
import BotService.core.modules.FileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VKServer {

  static int RECONNECT_TIME = 10000;
  public static VKCore vkCore;
  public static List<String> reserveQueue = new ArrayList<>();
  public static final String pathToLetters = "/Reserves";
  public static final String programPath = System.getProperty("user.dir");
  public static final String resourcesPath = "/Resources";

  static {
    try {
      vkCore = new VKCore();
    } catch (ApiException | ClientException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("Running server...");
    //Заполняем команды
    FileHelper.readCommandFile().forEach(x -> {
      String[] c = x.split("-");
      CommandManager.addCommand(new ReadableCommand(c[0], c[1]));
    });
    //Основной цикл
    while (true) {
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      try {
        Message message = vkCore.getMessage();
        if (message != null) {
          ExecutorService exec = Executors.newCachedThreadPool();
          exec.execute(new Messenger(message));
          exec.shutdown();
        }
      } catch (ClientException e) {
        System.out.println("Возникли проблемы");
        System.out.println("Повторное соединение через " + RECONNECT_TIME / 1000 + " секунд");
        try {
          Thread.sleep(RECONNECT_TIME);
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        }
      } catch (ApiException e) {
        System.out.println("Возникли проблемы с ApiException");
        e.printStackTrace();
        try {
          vkCore = new VKCore();
        } catch (ApiException | ClientException z) {
          z.printStackTrace();
        }
      } catch (Exception e) {
        System.out.println("Возникли проблемы с непонятной эксепшн........");
        e.printStackTrace();
        try {
          vkCore = new VKCore();
        } catch (ApiException | ClientException z) {
          z.printStackTrace();
        }
      }
    }
  }
}
