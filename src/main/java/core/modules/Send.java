package core.modules;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import static core.modules.RandomId.setRandomId;
import static vk.VKManager.vkCore;

public class Send {

    public void sendKeyboard(String fileName, int peerId){
        try {
            vkCore.getVk().messages()
                    .send(vkCore.getActor())
                    .peerId(peerId)
                    .randomId(setRandomId())
                    .message("Воспользуйтесь клавиатурой!")
                    .unsafeParam("keyboard", Reader.readTxtFile(fileName))
                    .execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

}
