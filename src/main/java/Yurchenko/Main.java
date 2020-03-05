package Yurchenko;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human human = new Human();
        Service ser = new Service();
        Repository rep = new Repository();
        Converter converter = new Converter<>();
        ser.get(human);

        HumanDTO dto = new HumanDTO();

        System.out.println("Конвертер");
        dto = converter.ConvertToDTO(human);
        ser.save(human);
        rep.save(dto);
        rep.get(dto);
        human = converter.ConvertToEntity(dto);
        rep.save(dto);
        ser.save(human);
    }
}