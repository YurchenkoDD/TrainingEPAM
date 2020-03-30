package yurchenko.structural.decorator;

public class Pepperoni extends IngredientDecorator {
    Pizza pizza;

    public Pepperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Pepperoni";
    }

    @Override
    public double cost() {
        return 80 + pizza.cost();
    }
}