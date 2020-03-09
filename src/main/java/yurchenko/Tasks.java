package yurchenko;

import java.util.*;

public class Tasks {


    public List<Human> fillList() {

        Address address1 = new Address("Ростов", "Первая", 58, 3);
        Human human1 = new Human("Юрченко Д.Д.", 68, address1);
        Address address2 = new Address("Ростов", "Первая", 58, 3);
        Human human2 = new Human("Юрченко Д.Д.", 68, address2);
        Address address3 = new Address("Тольятти", "Вторая", 8, 33);
        Human human3 = new Human("Рыбаков И.Ю.", 20, address3);
        Address address4 = new Address("Тольятти", "Вторая", 8, 33);
        Human human4 = new Human("Рыбаков И.Ю.", 20, address3);
        Address address5 = new Address("Самара", "Третья", 9, 13);
        Human human5 = new Human("Виктор М.Д.", 42, address5);
        Address address6 = new Address("Хабаровск", "Четвертая", 18, 121);
        Human human6 = new Human("Антон Р.Р.", 42, address6);
        Address address7 = new Address("Москва", "Пятая", 528, 311);
        Human human7 = new Human("Герман Т.Т.", 34, address7);
        Address address8 = new Address("Саратов", "Шестая", 11, 111);
        Human human8 = new Human("Левый Б.Б.", 26, address8);
        Address address9 = new Address("Терек", "Седьмая", 18, 321);
        Human human9 = new Human("Иваныч И.И.", 28, address9);
        Address address10 = new Address("Терек", "Седьмая", 18, 321);
        Human human10 = new Human("Иваныч И.И.", 28, address9);

        List<Human> humansList = new ArrayList<>();
        humansList.add(human1);
        humansList.add(human2);
        humansList.add(human3);
        humansList.add(human4);
        humansList.add(human5);
        humansList.add(human6);
        humansList.add(human7);
        humansList.add(human8);
        humansList.add(human9);
        humansList.add(human10);
        return humansList;
    }

    public void printCollection(List<Human> humansList) {
        System.out.println("1. Исходная коллекция");
        for (int i = 0; i < humansList.size(); i++) {
            System.out.println(humansList.get(i));
        }
    }

    public void findDoubles(List<Human> humansList) {
        Map<Human, Integer> mapHumans = new HashMap<>();
        for (Human human : humansList) {
            mapHumans.put(human, mapHumans.get(human) == null ? 1 : mapHumans.get(human) + 1);
        }
        System.out.println("---------------------------------------");
        System.out.println("2. Найдены след дубли");
        for (Map.Entry<Human, Integer> entry : mapHumans.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    public void removeDoubles(List<Human> humansList) {
        Map<Human, Integer> mapHumans = new HashMap<>();
        for (Human human : humansList) {
            mapHumans.put(human, mapHumans.get(human) == null ? 1 : mapHumans.get(human) + 1);
        }
        for (Map.Entry<Human, Integer> entry : mapHumans.entrySet()) {
            if (entry.getValue() > 1) {
                Human h = entry.getKey();
                humansList.remove(h);
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("3. Коллекция без дублей");
        for (int i = 0; i < humansList.size(); i++) {
            System.out.println(humansList.get(i));
        }
    }

    public void sortByFio(List<Human> humansList) {
        Comparator<Human> compareByFio = Comparator.comparing(Human::getFio);
        humansList.sort(compareByFio);
        System.out.println("---------------------------------------");
        System.out.println("4. Коллекция, сортированная по ФИО");
        for (int i = 0; i < humansList.size(); i++) {
            System.out.println(humansList.get(i));
        }
    }

    public void sortByAge(List<Human> humansList) {
        Comparator<Human> compareByAge = Comparator.comparing(Human::getAge);
        humansList.sort(compareByAge);
        System.out.println("---------------------------------------");
        System.out.println("5. Коллекция, сортированная по Возрасту");
        for (int i = 0; i < humansList.size(); i++) {
            System.out.println(humansList.get(i));
        }
    }

    public void sortByAddress(List<Human> humansList) {
        ComparatorAdress comparatorAdress = new ComparatorAdress();
        Collections.sort(humansList, comparatorAdress);
        System.out.println("---------------------------------------");
        System.out.println("6. Коллекция, сортированная по адресу:");
        for (int i = 0; i < humansList.size(); i++) {
            System.out.println(humansList.get(i));
        }
    }

    public List<User> fillUsers() {
        User user1 = new User("Шустров Владислав", Role.ADMIN);
        User user2 = new User("Геннадий Букин", Role.MODERATOR);
        User user3 = new User("Дмитрий Мисюряев", Role.USER);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    public void greetUsers(List<User> users) {
        System.out.println("---------------------------------------");
        Map<String, Role> map = new HashMap<>();
        for (int i = 0; i < users.size(); i++){
            String key = users.get(i).getFio();
            Role role = users.get(i).getRole();
            map.put(key,role);
            System.out.println("Приветствуем пользователя "+users.get(i).getFio()+" c ролью "+ map.get(key));
    }

}


    public HashMap<Integer, String> fillMap() {
        HashMap<Integer, String> footballers = new HashMap<>();
        footballers.put(1, "Akinfeev");
        footballers.put(3, "Ignashevich");
        footballers.put(28, "Fernandes");
        footballers.put(99, "Gatagov");
        footballers.put(14, "Denisov");
        footballers.put(11, "Arshavin");
        footballers.put(2, "Zhirkov");
        footballers.put(10, "Dzyuba");
        return footballers;
    }

    public void sortByKey(HashMap<Integer, String> footballers) {
        Map<Integer, String> treeMap = new TreeMap<>(footballers);
        System.out.println("---------------------------------------");
        System.out.println("9. HashMap, cортированная по ключу");
        System.out.println(treeMap);

    }

    public void sortByValue(HashMap<Integer, String> footballers) {
        SortedSet<String> sortedSet = new TreeSet<String>(footballers.values());
        System.out.println("---------------------------------------");
        System.out.println("10. HashMap, cортированная по значению");
        System.out.println(sortedSet);

    }

    public void randLinkList() {
        List<Integer> list = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println("---------------------------------------");
        System.out.println("11. Вывод содержимого каждого элемента LinkedList и его индекс");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Значение " + list.get(1) + " c индексом " + (i));
        }
    }

}