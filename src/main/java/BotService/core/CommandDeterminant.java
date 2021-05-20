package BotService.core;

import com.vk.api.sdk.objects.messages.Message;
import BotService.core.commands.Unknown;
import java.util.Collection;

/**
 * Определитель команд
 */
public class CommandDeterminant {

  /*
   * Обработка команд
   */
  public static Command getCommand(Collection<Command> commands, Message message) {
    for (Command command : commands) {
      if (command.getName().equalsIgnoreCase((message.getText()))) {
        return command;
      }
    }
    return new Unknown("unknown");
  }
}
