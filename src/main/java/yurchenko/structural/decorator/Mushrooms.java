package yurchenko.structural.decorator;

public class Mushrooms extends IngredientDecorator {
    Pizza pizza;

    public Mushrooms(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Mushrooms";
    }

    @Override
    public double cost() {
        return 50 + pizza.cost();
    }
}