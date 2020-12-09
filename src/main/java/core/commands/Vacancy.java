package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.Reader;
import vk.VKManager;

public class Vacancy extends Command {

    public Vacancy(String name) {
        super(name);
    }

    private String getVacancyMessage(){
        String fileName = "vacancy.txt";
        return Reader.readTxtFile(fileName);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage(getVacancyMessage(), message.getFromId(), false);
    }
}
