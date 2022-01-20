package bot;

import commands.CommandName;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import services.SendUserMessageImpl;

public class TrackerBot extends TelegramLongPollingBot {
    protected String botName = "TestoPlsletMeRegisterThisNameBot";
    protected String botToken = "5256506946:AAFMb-TOlVmpb5482_Ki3KxansDsTDGFQBU";
    protected final String botPrefix="/";

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            SendUserMessageImpl s= new SendUserMessageImpl(this);

            if (messageText.startsWith(botPrefix)){
                CommandName.getCommandClass(messageText).req(chatId.toString(),messageText+" "+update.getMessage().getChat().getUserName());
            }

        }

    }
}
