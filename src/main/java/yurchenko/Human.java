package yurchenko;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Human {
    private String fio;
    private int age;
    private Address address;

    public class Address{
        private String city;
        private String street;
        private int house;
        private int flat;
    }

}
