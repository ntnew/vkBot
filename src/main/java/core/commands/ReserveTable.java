package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.Reader;
import vk.VKManager;

import static core.modules.FileHelper.createNewFile;
import static vk.VKServer.reserveQueue;

public class ReserveTable extends Command {

    public ReserveTable(String name) {
        super(name);
    }

    private static String getReserveMessage(){
        String fileName = "reserve1.txt";
        return Reader.readTxtFile(fileName);
    }
    public static String getReserveStepMessage(int reserveStep){
        String fileName = "reserve" + reserveStep + ".txt";
        return Reader.readTxtFile(fileName);
    }

    @Override
    public void exec(Message message) {
        reserveQueue.add(message.getFromId() + "res2");
        new VKManager().sendMessage(getReserveMessage(), message.getFromId(), false);
        createNewFile(message.getFromId().toString());
    }
}
