package yurchenko.behavioral.template_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Game game = new Hockey();
        game.play();
        log.debug("\n");
        game = new Football();
        game.play();
    }
}