package yurchenko.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yurchenko.annotations.Entity;
import yurchenko.annotations.Value;
import yurchenko.exceptions.NoValueAnnotationException;
import java.lang.reflect.Field;

public class EntityCheck {

    private static final Logger log = LoggerFactory.getLogger(EntityCheck.class);

    public Class<?> loadClass(String classpath) {
        Class<?> clazz = null;
        {
            try {
                clazz = Class.forName(classpath);
            } catch (ClassNotFoundException e) {
                log.warn(String.valueOf(e));
            }
        }
        return clazz;
    }

    public void checkValueAnnotation(Class<?> clazz) {
        assert clazz != null;
        if (!clazz.isAnnotationPresent(Entity.class)) {
            log.warn("{} doesn't have Entity annotation", clazz);
            if (checkFields(clazz)) {
                try {
                    throw new IllegalStateException("Class doesn't have Entity annotation, " +
                            "but has Value annotated fields");
                } catch (IllegalStateException e) {
                    log.warn(String.valueOf(e));
                }
            }
        } else {
            log.info("Class has annotation: {} ", clazz.getAnnotation(Entity.class));
            if (!checkFields(clazz)) {
                try {
                    throw new NoValueAnnotationException("Class doesn't have Value annotation on all fields");
                } catch (NoValueAnnotationException e) {
                    log.warn(String.valueOf(e));
                }
            }
        }
    }

    public void insertValueInFields(Class<?> clazz) {

        Field annotatedField = null;
        Value annotation = null;
        try {
            annotatedField = clazz.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            log.warn(String.valueOf(e));
        }
        try {
            assert annotatedField != null;
            annotation = annotatedField.getAnnotation(Value.class);
        } catch (NullPointerException e) {
            log.warn(String.valueOf(e));
        }
        if (annotation != null) {
            log.info("Human name: {} ", annotation.name());
        }
    }

    private boolean checkFields(Class<?> clazz) {
        boolean isMoreThanOneAnnotationField = false;
        Field[] field = clazz.getDeclaredFields();
        for (Field fd : field) {
            if (fd.isAnnotationPresent(Value.class)) {
                isMoreThanOneAnnotationField = true;
            }
        }
        return isMoreThanOneAnnotationField;
    }
}