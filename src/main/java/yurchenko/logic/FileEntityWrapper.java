package yurchenko.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.annotations.Entity;
import yurchenko.entity.Human;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FileEntityWrapper {
    private static final Logger log = LoggerFactory.getLogger(FileEntityWrapper.class);
    private static Collection<File> names = new ArrayList<>();

    /**
     * Find all classes with Entity annotation
     */
    public void searchClassesWithAnnotation() {
        String folderPath = FileEntityWrapper.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        folderPath = folderPath.substring(1);
        extractFiles(new File(folderPath));

        for (File file : names) {
            String name = file.getPath();
            if (!name.endsWith(".class")) {
                continue;
            }
            name = name.substring(0, name.length() - ".class".length());
            name = name.replace("/", ".");
            name = name.replace("\\", ".");
            int classesPos = name.indexOf(".classes.");
            if (classesPos >= 0) {
                name = name.substring(classesPos + ".classes.".length());
            }
            try {
                if (Class.forName(name).isAnnotationPresent(Entity.class)) {
                    log.info("Find class {} with Entity annotation ", name);
                } else {
                    log.info("No classes with Entity annotation");
                }
            } catch (ClassNotFoundException e) {
                log.warn(String.valueOf(e));
            }
        }
    }

    public void setPeopleValues(String path) {
        String name = "";
        int age = 0;
        List<Human> humanList = new ArrayList<>();
        Class<Human> human = Human.class;
        if (!path.trim().isEmpty()) {
            try {
                Scanner scanner = new Scanner(new FileReader(path));
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] params = line.split("=");
                    if (params.length != 2 || params[1].trim().isEmpty()) {
                        continue;
                    }
                    if (params[0].equalsIgnoreCase("name")) {
                        name = params[1].trim();
                    } else if (params[0].equalsIgnoreCase("age")) {
                        try {
                            age = Integer.parseInt(params[1]);
                        } catch (NumberFormatException e) {
                            log.warn("Invalid age in file - " + e.getMessage());
                        }
                    } else {
                        continue;
                    }
                    if (!name.isEmpty() && age != 0) {
                        try {
                            Human humanInstance = human.newInstance();
                            humanInstance.setAge(age);
                            humanInstance.setName(name);
                            humanList.add(humanInstance);
                        } catch (InstantiationException | IllegalAccessException e) {
                            log.warn(e.getMessage());
                        }
                        name = "";
                        age = 0;
                    }
                }
            } catch (FileNotFoundException e) {
                log.warn(e.getMessage());
            }
        }
        log.info("Generated people with values from file: {}", humanList.toString());
    }

    private void extractFiles(File folder) {
        File[] folderEntries = folder.listFiles();
        try {
            assert folderEntries != null;
            for (File entry : folderEntries) {
                if (entry.isDirectory()) {
                    extractFiles(entry);
                    continue;
                }
                names.add(entry);
            }
        }catch (NullPointerException e){
            log.warn("Path doesn't exist or contains non-latin letters");
        }
    }
}