package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.FileHelper;
import core.modules.Send;
import vk.VKManager;

public class Begin extends Command {

    public Begin(String name) {
        super(name);
    }

    private String getStartMessage() {
        return FileHelper.readTxtFile("startPage");
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(getStartMessage(), message.getFromId(), false);
        new Send().sendKeyboard("keyboardStart", message.getFromId());
    }
}
