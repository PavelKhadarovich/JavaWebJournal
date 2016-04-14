package by.bsuir.journal.model.service.exception;

import by.bsuir.journal.exception.ProjectException;

/**
 * Created by egors.
 */
public class ServiceException extends ProjectException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception maskedException) {
        super(message, maskedException);
    }

    public ServiceException(Exception e) {
        super(e);
    }

}
