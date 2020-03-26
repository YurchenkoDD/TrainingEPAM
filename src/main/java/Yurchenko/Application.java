package Yurchenko;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Service ser = new Service();
        HumanDto allDto = new HumanDto();
        ser.get(allDto);
        List<HumanDto> humanDtos = ser.getAll(5);
        ser.saveAll(humanDtos);
        System.out.println("Test");
    }
}