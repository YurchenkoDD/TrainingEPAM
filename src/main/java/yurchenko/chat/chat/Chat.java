package yurchenko.chat.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.chat.exceptions.NoMessageException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chat {
    private static Logger log = LoggerFactory.getLogger(Chat.class);
    private static final int CAPACITY = 25;
    private List<Sms> chatSmsList = Collections.synchronizedList(new ArrayList<>());
    private List<Sms> bufferSmsList = Collections.synchronizedList(new ArrayList<>());
    private Lock lock = new ReentrantLock();

    public String addSms(String text) {
        lock.lock();
        try {
            if (chatSmsList.size() < CAPACITY) {
                chatSmsList.add(new Sms(text));
                log.info("New message added: {}", text);
            } else {
                bufferSmsList.add(new Sms(text));
                log.info("New message added to buffer: {}", text);
            }
        } finally {
            lock.unlock();
        }
        return text;
    }

    public String readSms() {
        lock.lock();
        try {
            if (!chatSmsList.isEmpty()) {
                Sms sms = chatSmsList.remove(0);
                if (!bufferSmsList.isEmpty()) {
                    chatSmsList.add(bufferSmsList.remove(0));
                    log.info("Messages left in buffer: {}", bufferSmsList.size());
                }
                log.info("Messages left in chat: {}", chatSmsList.size());
                log.info("Read message: {}", sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new NoMessageException("Can't read the message because message list is empty");
    }
    public String updateSms() {
        lock.lock();
        try {
            if (!chatSmsList.isEmpty()) {
                Sms sms = chatSmsList.get(ThreadLocalRandom.current().nextInt(chatSmsList.size()));
                sms.setText(sms.getText() + " updated");
                log.info("Updated message: {}", sms.getText());
                return sms.getText();
            }
        } finally {
            lock.unlock();
        }
        throw new NoMessageException("Can't update the message because message list is empty");
    }
}
