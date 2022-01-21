package commands;
import bot.TrackerBot;
public class CommandParser {

    public static Command getCommandClass(String s){
        switch (s.split("\\s")[0]) {
            case TrackerBot.botPrefix+"start":
                return new StartCommand();
            case TrackerBot.botPrefix+"stop":
                return new StopCommand();
            case TrackerBot.botPrefix+"help":
                return new HelpCommand();
            default: return new HelpCommand();
        }
    }
}
