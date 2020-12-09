package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.Reader;
import vk.VKManager;

public class Sale extends Command {
    public Sale (String name) {
        super(name);
    }

    private String getSaleMessage(){
        String fileName = "sale.txt";
        return Reader.readTxtFile(fileName);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(getSaleMessage(), message.getFromId(), false);
    }
}
