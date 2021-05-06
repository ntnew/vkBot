package core;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Unknown;
import core.modules.Send;
import core.modules.Letter;
import vk.VKManager;

import java.util.Collection;

import static core.commands.ReserveTable.getReserveStepMessage;
import static core.modules.FileHelper.*;
import static vk.VKServer.reserveQueue;

/**
 * Определяет команду
 *
 * @author Артур Куприянов
 * @version 1.1.0
 */
public class CommandDeterminant {

    /*
     * Обработка команд
     */
    public static Command getCommand(Collection<Command> commands, Message message) {
        for (Command command : commands) {
            if (command.getName().equalsIgnoreCase((message.getText()))) {
                return command;
            }
        }
        return new Unknown("unknown");
    }

    /*
     * Обработка при бронировании стола
     */
    public static void reserveQue(Message message) {
        if (reserveQueue.contains(message.getFromId() + "res2")) {
            new VKManager().sendMessage(getReserveStepMessage(2), message.getFromId(), false);
            reserveQueue.remove(message.getFromId() + "res2");
            reserveQueue.add(message.getFromId() + "res3");
            writeLetter(message.getFromId().toString(), "Количество персон: " + message.getText() + ";\n");
        } else if (reserveQueue.contains(message.getFromId() + "res3")) {
            new VKManager().sendMessage(getReserveStepMessage(3), message.getFromId(), false);
            reserveQueue.remove(message.getFromId() + "res3");
            reserveQueue.add(message.getFromId() + "res4");
            writeLetter(message.getFromId().toString(), "Время прибытия гостей: " + message.getText() + ";\n");
        } else if (reserveQueue.contains(message.getFromId() + "res4")) {
            new VKManager().sendMessage(getReserveStepMessage(4), message.getFromId(), false);
            reserveQueue.remove(message.getFromId() + "res4");
            reserveQueue.add(message.getFromId() + "res5");
            writeLetter(message.getFromId().toString(), "Телефон: " + message.getText() + ";\n");
        } else if (reserveQueue.contains(message.getFromId() + "res5")) {
            writeLetter(message.getFromId() + "", "Имя: " + message.getText() + ";\n");
            new VKManager().sendMessage(getReserveStepMessage(5) + "\n" +
                    readLetter(message.getFromId() + ""), message.getFromId(), false);
            new Send().sendKeyboard("keyboardConfirm", message.getFromId());
            reserveQueue.remove(message.getFromId() + "res5");
            reserveQueue.add(message.getFromId() + "res6");
        } else if (reserveQueue.contains(message.getFromId() + "res6") && message.getText().equals("Да")) {
            new VKManager().sendMessage(getReserveStepMessage(6), message.getFromId(), false);
            new Send().sendKeyboard("keyboardStart", message.getFromId());
            reserveQueue.remove(message.getFromId() + "res6");
            Letter letter = new Letter(message.getFromId());
            letter.start();
        } else if (reserveQueue.contains(message.getFromId() + "res6") && message.getText().equals("Нет")) {
            new VKManager().sendMessage("Попробуйте заполнить ещё раз", message.getFromId(), false);
            new Send().sendKeyboard("keyboardStart", message.getFromId());
            reserveQueue.remove(message.getFromId() + "res6");
            clearLetter(message.getFromId().toString());
        }

    }

}
