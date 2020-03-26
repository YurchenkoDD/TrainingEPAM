package yurchenko;

import java.util.Comparator;

public class ComparatorAdress implements Comparator<Human> {
    @Override
    public int compare(Human address1, Human address2) {
        return address1.getAddress().compareTo(address2.getAddress());
    }
}
