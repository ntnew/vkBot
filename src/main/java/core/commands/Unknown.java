package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;

import static core.modules.Reader.readTxtFile;

/**
 * @author Arthur Kupriyanov
 */
public class Unknown extends Command {

    public Unknown(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(readTxtFile("unknown.txt"), message.getFromId(),true);
    }
}
