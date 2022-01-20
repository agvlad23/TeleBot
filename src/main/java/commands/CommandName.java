package commands;

public enum CommandName {
    START,
    STOP,
    HELP,
    ECHO;

    public static Command getCommandClass(String s){
        switch (s) {
            case "start":
                return new StartCommand();
            default: return new StartCommand();
        }
    }
}
