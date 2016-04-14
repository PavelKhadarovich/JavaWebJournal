package by.bsuir.journal.model.dao.exception;

import by.bsuir.journal.exception.ProjectException;

/**
 * Created by egors.
 */
public class DaoException extends ProjectException {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Exception maskedException) {
        super(message, maskedException);
    }
}
