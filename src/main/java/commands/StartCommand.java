package commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import services.SendUserMessageImpl;

public class StartCommand implements Command{
    @Override
    public void req(Update update) {
        System.out.println("startCommand");
        var inMessage=update.getMessage();
        SendMessage outMessage=new SendMessage(inMessage.getChatId().toString(),inMessage.getText()+" startCommand");

        SendUserMessageImpl.sendMessage(outMessage);
    }
}
