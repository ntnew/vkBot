package core;

import core.commands.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

import static core.modules.Reader.programPath;


public class CommandManager {
    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new ReserveTable("забронировать стол"));
        commands.add(new Unknown("unknown"));
        commands.add(new Begin("начать"));
        commands.add(new Sale("акции"));
        commands.add(new Menu("меню"));
        commands.add(new Vacancy("вакансии"));
        commands.add(new Question("вопрос/отзыв"));
    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
