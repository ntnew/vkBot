package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.FileHelper;
import vk.VKManager;

/**
 * Класс неизвестной команды
 */
public class Unknown extends Command {

  public Unknown(String name) {
    super(name);
  }

  @Override
  public void exec(Message message) {
    new VKManager().sendMessage(FileHelper.readTxtFile("unknown"), message.getFromId(), true);
  }
}
