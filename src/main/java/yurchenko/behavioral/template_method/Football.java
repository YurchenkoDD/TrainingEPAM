package yurchenko.behavioral.template_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Football extends Game {

    private static final Logger log = LoggerFactory.getLogger(Football.class);

    @Override
    void endPlay() {
        log.debug("Football Game Finished!");
    }

    @Override
    void initialize() {
        log.debug("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        log.debug("Football Game Started. Enjoy the game!");
    }
}