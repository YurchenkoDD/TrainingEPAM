package yurchenko.structural.decorator;

public class Cucumber extends IngredientDecorator {
    Pizza pizza;

    public Cucumber(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Cucumber";
    }

    @Override
    public double cost() {
        return 30 + pizza.cost();
    }
}