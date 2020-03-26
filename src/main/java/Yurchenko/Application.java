package Yurchenko;

import Yurchenko.exceptions.EntityNotFound;

import java.util.List;

public class Application {
    public static void main(String[] args){
        Service ser = new Service();
        HumanDto alldto = new HumanDto();
        ser.get(alldto);
        List<HumanDto> humanDTOS = ser.getAll(5);
        ser.saveAll(humanDTOS);
        System.out.println("Test");
    }
}