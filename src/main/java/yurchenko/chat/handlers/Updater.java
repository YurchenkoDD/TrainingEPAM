package yurchenko.chat.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.chat.task.Task;

public class Updater extends TaskHandler {
    private static Logger log = LoggerFactory.getLogger(Updater.class);

    public Updater(Task task, int period) {
        super(task, period);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String modifiedSmsText = executeTask(period);
                log.info("Updater : {}", modifiedSmsText);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
