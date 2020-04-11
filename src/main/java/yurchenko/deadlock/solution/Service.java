package yurchenko.deadlock.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
    private static Logger log = LoggerFactory.getLogger(Service.class);
    final Counter first = new Counter();
    final Counter second = new Counter();
    Runnable block1 = () -> {
        synchronized (second) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Thread Error", e);
            }
            synchronized (first) {
                first.setValue();
                log.info("Counter's value is = {} ", first.getValue());
            }
        }
    };
    Runnable block2 = () -> {
        synchronized (second) {
            first.setValue();
            synchronized (first) {
                log.info("Counter's value is = {} ", first.getValue());
            }
        }
    };
}
