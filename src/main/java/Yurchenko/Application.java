package Yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Service ser = new Service();
        HumanDTO alldto = new HumanDTO();
        Converter converter = new Converter();
        Human human = converter.ConvertToEntity(alldto);
        ser.get(alldto);
        List<HumanDTO> humanDTOS = ser.getAll(5);
        ser.saveAll(humanDTOS);
        System.out.println("Test");
    }
}