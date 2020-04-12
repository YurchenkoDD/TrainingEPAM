package yurchenko.chat.task;

import yurchenko.chat.chat.Chat;

public class Read extends Task {
    public Read(Chat chat) {
        super(chat);
    }

    @Override
    public String call() {
        return chat.readSms();
    }
}