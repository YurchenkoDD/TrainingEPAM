package Yurchenko.exceptions;

//checked exception
public class EntityNotFound extends Exception {
    public EntityNotFound(String message){
        super(message);
    }
}
