package yurchenko.behavioral.template_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hockey extends Game {

    private static final Logger log = LoggerFactory.getLogger(Hockey.class);

    @Override
    void endPlay() {
        log.debug("Hockey Game Finished!");
    }

    @Override
    void initialize() {
        log.debug("Hockey Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        log.debug("Hockey Game Started. Enjoy the game!");
    }
}