package yurchenko.structural.decorator;

public class DefaultPizza extends Pizza {

    public DefaultPizza() {
        description = "This is Default Pizza";
    }

    @Override
    public double cost() {
        return 200;
    }
}
