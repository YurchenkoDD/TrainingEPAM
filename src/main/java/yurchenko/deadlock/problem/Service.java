package yurchenko.deadlock.problem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
    private static Logger log = LoggerFactory.getLogger(Service.class);
    final Counter first = new Counter();
    final Counter second = new Counter();
    Runnable block1 = () -> {
        synchronized (first) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Thread Error", e);
            }
            synchronized (second) {
                first.setValue();
                log.info("Counter's value is = {} ", first.getValue());
            }
        }
    };
    Runnable block2 = () -> {
        synchronized (second) {
            second.setValue();
            synchronized (first) {
                log.info("Counter's value is = {} ", first.getValue());
            }
        }
    };
}
