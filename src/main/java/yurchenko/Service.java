package yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service {
    private static Logger log = LoggerFactory.getLogger(Service.class);

    /**
     * Generates UUID list
     *
     * @return list of UUID
     */
    public static List<String> generateUIID() {
        List<UUID> uuids = Stream.generate(UUID::randomUUID)
                .limit(10000)
                .collect(Collectors.toList());

        List<String> uuidList = uuids.stream()
                .map(UUID::toString)
                .collect(Collectors.toList());
        return uuidList;
    }


    /**
     * Write UUID list to file
     *
     * @param filePath to file with UUID
     * @param uuidList UUID list
     */
    public static void uuidSaveToFile(String filePath, List<String> uuidList) {
        filePath = Optional
                .ofNullable(filePath)
                .orElse("");
        try {
            Files.write(Paths.get(filePath), uuidList);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Counts number of UUID in file with value > 100
     *
     * @param filePath path to file
     * @return number of UUID in file with value > 100
     */
    public static long uuidCounter(String filePath) {
        long count = 0;
        filePath = Optional
                .ofNullable(filePath)
                .orElse("");
        try {
            count = Files.lines(Paths.get(filePath))
                    .map(x -> x.replaceAll("\\D", ""))
                    .map(x -> x.chars().map(Character::getNumericValue).sum())
                    .filter(sum -> sum > 100)
                    .count();
            log.info("Number of UUID > 100: {}", count);
        } catch (IOException e) {
            log.error("File write error ", e);
        }
        return count;
    }

    /**
     * Generates date of doomsday
     *
     * @param startDate initial value for N and M count
     */
    public static void doomsDay(long startDate) {
        try {
            String stringDate = Optional
                    .ofNullable(String.format("%04d", startDate))
                    .orElse(String.format("%04d", 0));
            int n = Integer.parseInt(stringDate.substring(0, 2).replaceAll("\\D", ""));
            int m = Integer.parseInt(stringDate.substring(2, 4).replaceAll("\\D", ""));
            log.info("n = {}", n);
            log.info("m = {}", m);
            ZonedDateTime doomsdayDate = ZonedDateTime.now(ZoneId.of("America/Chicago")).plusMonths(n).plusDays(m);
            log.info("The end is coming at {}", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(doomsdayDate));
        } catch (NumberFormatException e) {
            log.error("Incorrect input time.");
        }

    }

    /**
     * Decodes strings to sausages
     *
     * @param filePath to file with encoded sausages
     */
    public static void generateSausages(String filePath) {
        filePath = Optional
                .ofNullable(filePath)
                .orElse("");
        try {
            List<Sausage> sausages = Files.lines(Paths.get(filePath))
                    .map(Base64.getDecoder()::decode)
                    .map(String::new)
                    .map(line -> Arrays.stream(line.split(","))
                            .map(elem -> elem.split("=")[1]).collect(Collectors.toList()))
                    .map(Sausage::new)
                    .collect(Collectors.toList());
            log.info("Generated list of sausages: {}", sausages);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }
}