package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.Reader;
import core.modules.Send;
import vk.VKCore;
import vk.VKManager;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Begin extends Command {
    public Begin(String name) {
        super(name);
    }

    private String getStartMessage(){
        String fileName = "startPage.txt";
        return Reader.readTxtFile(fileName);
    }

    @Override
    public void exec(Message message) {
        String filename = "keyboardStart.json";
        new VKManager().sendMessage(getStartMessage(), message.getFromId(), false);
        new Send().sendKeyboard(filename, message.getFromId());
    }
}
