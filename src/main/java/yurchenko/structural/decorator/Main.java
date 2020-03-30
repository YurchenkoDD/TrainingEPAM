package yurchenko.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Pizza pizza = new DefaultPizza();

        log.info(pizza.getDescription() + " " + pizza.cost() + " rub");

        pizza = new Mushrooms(pizza);
        pizza = new Pepperoni(pizza);
        pizza = new Cucumber(pizza);

        log.info(pizza.getDescription() + " " + pizza.cost() + " rub");

    }

}

