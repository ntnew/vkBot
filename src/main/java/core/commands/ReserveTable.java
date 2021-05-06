package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.FileHelper;
import vk.VKManager;
import static vk.VKServer.reserveQueue;

public class ReserveTable extends Command {

    public ReserveTable(String name) {
        super(name);
    }

    private String getReserveMessage(){
        String fileName = "reserve1";
        return FileHelper.readTxtFile(fileName);
    }
    public static String getReserveStepMessage(int reserveStep){
        String fileName = "reserve" + reserveStep;
        return FileHelper.readTxtFile(fileName);
    }

    @Override
    public void exec(Message message) {
        reserveQueue.add(message.getFromId() + "res2");
        new VKManager().sendMessage(getReserveMessage(), message.getFromId(), false);
        FileHelper.createNewLetterFile(message.getFromId().toString());
    }
}
