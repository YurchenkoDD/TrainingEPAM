package yurchenko.structural.decorator;

public abstract class Pizza {
    String description = "Default Pizza";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}