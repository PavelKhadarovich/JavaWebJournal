package by.bsuir.journal.controller.exception;

/**
 * Exception for controller commands.
 */
public class ControllerException extends Exception{
    private static final long serialVersionUID = 1;

    public ControllerException(String message){
        super(message);
    }

    public ControllerException(String message, Exception e){
        super(message, e);
    }
}
