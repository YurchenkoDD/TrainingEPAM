package yurchenko;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String UUIDPATH = "src/main/resources/uuidList.txt";
    private static final String SAUSAGEPATH = "src/main/resources/sausageList.txt";

    public static void main(String[] args) throws IOException {
        List<String> uuidList = Service.generateUIID();
        Service.uuidSaveToFile(UUIDPATH, uuidList);
        Service.uuidCounter(UUIDPATH);
        Service.doomsDay(Service.uuidCounter(UUIDPATH));
        Service.generateSausages(SAUSAGEPATH);
    }
}
