package Yurchenko;

import Yurchenko.exceptions.EntityNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Application {
    public static void main(String[] args) throws EntityNotFound {
        Service ser = new Service();
        HumanDTO alldto = new HumanDTO();
        ser.get(alldto);
        List<HumanDTO> humanDTOS = ser.getAll(5);
        ser.saveAll(humanDTOS);
        System.out.println("Test");
    }
}