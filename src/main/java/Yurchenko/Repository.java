package Yurchenko;

import Yurchenko.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repository<T extends Human> {

    private Logger consoleLogger = LoggerFactory.getLogger(Service.class);
    private static final int BOOKED_ID = 2;

    private String stringGen() {
        String string = "abcdefghty";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 8 + 2);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }

    /**
     * Create one person
     *
     * @param human created person
     * @return human object
     */
    public Human get(Human human) {
        Human.Address address = new Human().new Address();
        human.setId((int) (Math.random() * 15 + 1));
        human.setName(stringGen());
        human.setBirthDate(new Date((long) (Math.random() * 100000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        address.setHouseNumber((int) (Math.random() * 100));
        human.setAddress(address);
        return human;
    }

    /**
     * Generate list with i persons
     *
     * @param i number of persons
     * @return list of persons
     */
    public List<Human> getAll(int i) throws EntityNotFound {
        ArrayList<Human> humanList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Human human = new Human();
            humanList.add(get(human));
        }
        return humanList;
    }

    /**
     * Save human in DB
     *
     * @param human object human
     */
    public void save(Human human) {
        if (human.getId() <= BOOKED_ID) {
            consoleLogger.warn("Человек с id = {} не может быть сохранен в БД. Этот ID занят", human.getId());
            throw new CanNotSaveEntity("Человек с id=" + human.getId() + " не может быть сохранен в БД. Этот ID занят");
        }
        System.out.println(human);
        consoleLogger.info("Человек с id = {} сохранен", human.getId());
    }
}