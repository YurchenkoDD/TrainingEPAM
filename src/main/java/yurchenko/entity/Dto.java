package yurchenko.entity;

import yurchenko.annotations.Value;

public class Dto {
    @Value
    private int age;
    @Value(name = "dd")
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
}