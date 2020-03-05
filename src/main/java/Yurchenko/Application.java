package Yurchenko;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Service ser = new Service();
        HumanDTO alldto = new HumanDTO();
        ser.get(alldto);
        List<HumanDTO> humanDTOS = ser.getAll(5);
        ser.saveAll(humanDTOS);
        System.out.println("Test");
    }
}