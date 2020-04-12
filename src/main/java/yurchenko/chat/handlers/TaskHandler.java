package yurchenko.chat.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.chat.task.Task;

import java.util.concurrent.*;

public abstract class TaskHandler implements Runnable {
    private static Logger log = LoggerFactory.getLogger(TaskHandler.class);
    protected Task task;
    protected ExecutorService executorService;
    protected int secFrom;
    protected int secTo;
    protected int period;

    public TaskHandler(Task task, int secFrom, int secTo) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.secFrom = secFrom;
        this.secTo = secTo;
    }

    public TaskHandler(Task task, int period) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.period = period;
    }

    public String executeTask(int time) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(task);
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(time));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        executorService.execute(futureTask);
        return futureTask.get();
    }

}
