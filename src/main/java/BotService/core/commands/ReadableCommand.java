package BotService.core.commands;

import com.vk.api.sdk.objects.messages.Message;
import BotService.core.Command;
import BotService.core.modules.FileHelper;
import BotService.vk.VKManager;

public class ReadableCommand extends Command {

    private String fileName;

    public ReadableCommand(String name) {
        super(name);
    }

    public ReadableCommand(String name, String filename){
        super(name);
        this.fileName = filename;
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(FileHelper.readTxtFile(fileName), message.getFromId(), false);
    }
}
