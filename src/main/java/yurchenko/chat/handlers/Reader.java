package yurchenko.chat.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.chat.task.Task;

import java.util.Random;

public class Reader extends TaskHandler {
    private static Logger log = LoggerFactory.getLogger(Reader.class);

    public Reader(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            int time = rnd.nextInt(secTo - secFrom) + secFrom;
            try {
                String smsText = executeTask(time);
                log.info("Reader " + Thread.currentThread().getName() + " this sms: " + smsText);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
