package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.FileHelper;
import vk.VKManager;

public class Vacancy extends Command {

    public Vacancy(String name) {
        super(name);
    }

    private String getVacancyMessage(){
        return FileHelper.readTxtFile("vacancy");
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(getVacancyMessage(), message.getFromId(), false);
    }
}
