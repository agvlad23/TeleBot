package commands;

import services.SendUserMessageImpl;

public class StartCommand implements Command{
    @Override
    public void req(String chatId,String messageText) {
        System.out.println("startCommand");
        SendUserMessageImpl.sendMessage(chatId,messageText+" "+chatId);
    }
}
