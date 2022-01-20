package commands;

import services.SendUserMessageImpl;

public class StopCommand implements Command {

    @Override
    public void req(String chatId,String messageText) {
        System.out.println("stopCommand");
        SendUserMessageImpl.sendMessage(chatId,"this is stop command "+messageText);
    }
}
