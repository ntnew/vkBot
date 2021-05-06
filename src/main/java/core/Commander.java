package core;

import com.vk.api.sdk.objects.messages.Message;

import static vk.VKServer.reserveQueue;

public class Commander {
    /**
     * Обработка сообщений, получаемых через сервис Вконтакте. Iмеет ряд дополнительной информации.
     *
     * @param message сообщение (запрос) пользователя
     */
    public static void execute(Message message) {
        if (!reserveQueue.isEmpty()) {
            CommandDeterminant.reserveQue(message);
        } else {
            CommandDeterminant.getCommand(CommandManager.getCommands(), message).exec(message);
        }
    }

}
