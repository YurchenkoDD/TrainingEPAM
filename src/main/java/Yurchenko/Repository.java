package Yurchenko;

import java.util.Date;

public class Repository<T extends Human> {

    private String stringGen() {
        String string = "abcdefghty";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 9 + 3);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }

    public Human get(Human human) {
        Human.Address address = new Human().new Address();
        human.setId((int) (Math.random() * 10));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        address.setHouseNumber((int) (Math.random() * 100));
        human.setAddress(address);
        return human;
    }

    public void save(Human human) {
        System.out.println(human);
    }
}