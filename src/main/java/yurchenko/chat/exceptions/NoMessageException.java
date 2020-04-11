package yurchenko.chat.exceptions;

public class NoMessageException extends RuntimeException{
    public NoMessageException(String message){
        super(message);
    }
}
