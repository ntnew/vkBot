package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.FileHelper;
import vk.VKManager;

public class Question extends Command {

    public Question(String name) {
        super(name);
    }

    private String getQuestionMessage(){
        String fileName = "question";
        return FileHelper.readTxtFile(fileName);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(getQuestionMessage(), message.getFromId(), false);
    }
}
