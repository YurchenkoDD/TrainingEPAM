package yurchenko.entity;

import yurchenko.annotations.Entity;
import yurchenko.annotations.Value;

@Entity
public class Human {
    @Value(pathToFile = "src/main/resources/humanValues.txt")
    private int age;
    @Value(name = "dd", pathToFile = "src/main/resources/humanValues.txt")
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

    }

    @Override
    public String toString() {
        return "Human{age=" + age +
                ", name='" + name + '\'' + '}';
    }
}