package commands;

import services.SendUserMessageImpl;

public class HelpCommand implements Command{
    @Override
    public void req(String chatId, String messageText) {
        System.out.println("helpCommand");

        SendUserMessageImpl.sendMessage(chatId,"this is help command");
    }
}
