package by.bsuir.journal.exception;

/**
 * Created by Veronika.
 */
public class ProjectException extends Exception{
    private Exception maskedException;

    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(String message, Exception maskedException) {
        super(message);
        this.maskedException = maskedException;
    }

    public ProjectException(Exception e) {
        super(e.getMessage());
        maskedException = e;
    }

    public Exception getMaskedException() {
        return maskedException;
    }

    public void setMaskedException(Exception maskedException) {
        this.maskedException = maskedException;
    }
}
