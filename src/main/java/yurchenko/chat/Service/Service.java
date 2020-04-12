package yurchenko.chat.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.chat.chat.Chat;
import yurchenko.chat.handlers.Reader;
import yurchenko.chat.handlers.TaskHandler;
import yurchenko.chat.handlers.Updater;
import yurchenko.chat.handlers.Writer;
import yurchenko.chat.task.Read;
import yurchenko.chat.task.Task;
import yurchenko.chat.task.Update;
import yurchenko.chat.task.Write;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private Chat chat;
    private AtomicInteger atomicInteger;
    private static final int WRITER_COUNT = 3;
    private static final int READER_COUNT = 3;
    private static final int UPDATER_COUNT = 1;

    private static Logger log = LoggerFactory.getLogger(Service.class);

    public Service() {
        chat = new Chat();
        atomicInteger = new AtomicInteger(0);
    }

    public void startChat() {
        Task writerTask = new Write(chat, atomicInteger);
        Task readerTask = new Read(chat);
        Task updaterTask = new Update(chat);

        TaskHandler writerTaskExecutor = new Writer(writerTask, 20, 60);
        TaskHandler readerTaskExecutor = new Reader(readerTask, 30, 50);
        TaskHandler updaterTaskExecutor = new Updater(updaterTask, 40);

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (int i = 0; i < WRITER_COUNT; i++) {
            executorService.execute(writerTaskExecutor);
        }
        for (int i = 0; i < READER_COUNT; i++) {
            executorService.execute(readerTaskExecutor);
        }
        for (int i = 0; i < UPDATER_COUNT; i++) {
            executorService.execute(updaterTaskExecutor);
        }

        executorService.shutdown();

    }
}