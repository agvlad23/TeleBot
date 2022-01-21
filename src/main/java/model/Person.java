package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import roles.Role;


@AllArgsConstructor
public class Person {

    @Getter
    Role role=Role.User;
    @Getter
    Update update;

}
