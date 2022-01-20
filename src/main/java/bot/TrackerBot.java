package bot;

import commands.CommandName;
import commands.CommandParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import services.SendUserMessageImpl;

public class TrackerBot extends TelegramLongPollingBot {
    protected String botName = "TestoPlsletMeRegisterThisNameBot";
    protected String botToken = "5256506946:AAFMb-TOlVmpb5482_Ki3KxansDsTDGFQBU";
    protected final String botPrefix="/";

    public TrackerBot() {
         SendUserMessageImpl.init(this);
    }

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

            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (messageText.startsWith(botPrefix)){
                CommandParser.getCommandClass(messageText).req(update);
            }

        } else if (update.hasCallbackQuery()) {

            String call_data = update.getCallbackQuery().getData();
            String  message_id = update.getCallbackQuery().getMessage().getMessageId().toString();
            String chat_id = update.getCallbackQuery().getMessage().getChatId().toString();

            if (call_data.equals("update_msg_text")) {
                String answer = "Updated message text";

                EditMessageText new_message = new EditMessageText();
                new_message.setChatId(chat_id);
                new_message.setMessageId(Integer.parseInt(message_id));
                new_message.setText(answer);

                SendUserMessageImpl.sendMessage(new_message);

            }
        }

    }
}
