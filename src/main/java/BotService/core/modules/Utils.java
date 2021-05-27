package BotService.core.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Random;

public class Utils {

  /*
   * Возвращает рандомное число int
   */
  public static int getRandomInt() {
    return new Random().nextInt();
  }

  /*
   * Возвращает гсон билдер
   */
  public static Gson getGsonInstance() {
    GsonBuilder builder = new GsonBuilder();
    return builder.create();
  }
}
