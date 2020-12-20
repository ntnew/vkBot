package core;

import core.commands.*;

import java.util.HashSet;



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
