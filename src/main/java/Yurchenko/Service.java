package Yurchenko;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

    public class Service<T extends Human> {

        private String stringGen() {
            String string = "abcdefghijklmnop";
            StringBuilder randString = new StringBuilder();
            int count = (int) (Math.random() * 8 + 2);
            for (int i = 0; i < count; i++)
                randString.append(string.charAt((int) (Math.random() * string.length())));
            return randString.toString();
        }


        Human get(Human human) {
            Human.Address address = new Human(). new Address();
            human.setId((int) (Math.random() * 10));
            human.setName(stringGen());
            human.setBirthDate(new Date((long) (Math.random() * 100000000)));
            address.setCity(stringGen());
            address.setStreet(stringGen());
            address.setHouseNumber((int) (Math.random() * 100));
            human.setAddress(address);
            return human;
        }


        List<Human> getAll(int i) {
            Service ser = new Service();
            List<Human> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                Human human = new Human();
                list.add(ser.get(human));
            }
            return list;
        }

        void save(Human human) {
            System.out.println(human);
        }

        void saveAll(List<Human> people) {
            for (Human human : people) {
                System.out.println(human);
            }
        }
    }