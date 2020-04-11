package yurchenko.racecondition.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter {
    private static int value = 0;
    private static Logger log = LoggerFactory.getLogger(Counter.class);

    public void getValue(){
        log.info("Value = {}", value);
    }

    public synchronized static void incrementedValue() {
        int val = value;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Thread error", e);
        }
        val++;
        value = val;
    }
}