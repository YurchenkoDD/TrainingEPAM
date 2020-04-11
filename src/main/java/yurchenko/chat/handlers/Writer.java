package yurchenko.chat.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.chat.task.Task;

import java.util.Random;

public class Writer extends TaskHandler {
    private static Logger log = LoggerFactory.getLogger(Writer.class);

    public Writer(Task task, int secFrom, int secTo) {
        super(task, secFrom, secTo);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            int time = rnd.nextInt(secTo - secFrom) + secFrom;
            try {
                String writedSmsText = executeTask(time);
                log.info("Writer :" + Thread.currentThread().getName() + ": Write: " + writedSmsText);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
