package Yurchenko;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repository<P extends HumanDTO> {

    private String stringGen() {
        String string = "abcdefghijklmnop";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 9 + 3);
        ;
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }

    HumanDTO get(HumanDTO dto) {
        HumanDTO humanDTO = new HumanDTO();
        HumanDTO.Address address = humanDTO.new Address();
        dto.setId((int) (Math.random() * 10));
        dto.setName(stringGen());
        dto.setBirthDate(new Date((long) (Math.random() * 100000000)));
        address.setCity(stringGen());
        address.setStreet(stringGen());
        address.setHouseNumber((int) (Math.random() * 100));
        dto.setAddress(address);
        return dto;
    }

    List<HumanDTO> getAll(int i) {
        Repository rep = new Repository();
        ArrayList<HumanDTO> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            HumanDTO dto = new HumanDTO();
            list.add(rep.get(dto));
        }
        return list;
    }

    void save(HumanDTO dto) {
        System.out.println(dto);
    }

    void saveAll(List<HumanDTO> dtos) {
        for (HumanDTO go : dtos) {
            System.out.println(go);
        }
    }
}