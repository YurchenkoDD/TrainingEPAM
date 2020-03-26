package Yurchenko.exceptions;

/**
 * Unchecked exception
 */
public class CanNotSaveEntity extends RuntimeException {
    public CanNotSaveEntity(String message) {
        super(message);
    }
}
