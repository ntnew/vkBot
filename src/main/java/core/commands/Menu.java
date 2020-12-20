package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.FileHelper;
import vk.VKManager;

public class Menu extends Command {
    public Menu(String name) {
        super(name);
    }

    private String getSaleMessage() {
        String fileName = "menu";
        return FileHelper.readTxtFile(fileName);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(getSaleMessage(), message.getFromId(), false);
    }
}
