package BotService.core;

import BotService.core.commands.*;

import java.util.HashSet;


public class CommandManager {

  private static HashSet<Command> commands = new HashSet<>();

  static {
    commands.add(new ReserveTable("забронировать стол"));
    commands.add(new Unknown("unknown"));
    commands.add(new Begin("начать"));
  }

  public static HashSet<Command> getCommands() {
    return commands;
  }

  public static void addCommand(Command command) {
    commands.add(command);
  }
}
