package Yurchenko.exceptions;

/**
 * Checked exception
 */
public class EntityNotFound extends Exception {
    public EntityNotFound(String message) {
        super(message);
    }
}
