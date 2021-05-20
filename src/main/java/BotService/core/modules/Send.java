package BotService.core.modules;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import static BotService.core.modules.Utils.getRandomInt;
import static BotService.vk.VKManager.vkCore;

public class Send {

  public void sendKeyboard(String fileName, int peerId) {
    try {
      vkCore.getVk().messages()
          .send(vkCore.getActor())
          .peerId(peerId)
          .randomId(getRandomInt())
          .message("Воспользуйтесь клавиатурой!")
          .unsafeParam("keyboard", FileHelper.readKeyboardFile(fileName))
          .execute();
    } catch (ApiException | ClientException e) {
      e.printStackTrace();
    }
  }
}
