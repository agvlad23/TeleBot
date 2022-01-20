package services;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SendUserMessageImpl {
    static TelegramLongPollingBot teleBot;
    private static final Logger LOGGER = Logger.getLogger(SendUserMessageImpl.class.getName());

    public SendUserMessageImpl(TelegramLongPollingBot teleBot2) {
        if (teleBot == null)
            teleBot = teleBot2;
    }


    public static void sendMessage(String chatID, String messageText) {

            SendMessage message= new SendMessage();
            message.setChatId(chatID);
            message.setText(messageText);
            try {
                teleBot.execute(message);
            } catch (TelegramApiException e) {
                LOGGER.log(Level.SEVERE,"TELegram !! "+e );
                System.out.println("Errrr");
                e.printStackTrace();
            }



    }

}
