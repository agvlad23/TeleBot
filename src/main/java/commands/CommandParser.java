package commands;

public class CommandParser {

    public static Command getCommandClass(String s){
        switch (s.split("\\s")[0]) {
            case "/start":
                return new StartCommand();
            case "/stop":
                return new StopCommand();
            case "/help":
                return new HelpCommand();
            default: return new StartCommand();
        }
    }
}
