package by.bsuir.journal.model.service;

import by.bsuir.journal.model.service.exception.ServiceException;
import by.bsuir.journal.model.dao.SignInDao;
import by.bsuir.journal.model.dao.exception.DaoException;
import by.bsuir.journal.model.entity.UserType;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Veronika.
 */
public class SignInService {
    private static List<UserType> userTypes = new ArrayList<>();

    static {
        userTypes.add(UserType.employee);
        userTypes.add(UserType.employer);
    }

    public static List<UserType> getUserTypes() {
        return userTypes;
    }

    private SignInDao signInDao = new SignInDao();

    public void checkIsThisEmailRegistered(String email) throws ServiceException {
        try {
            if (signInDao.getUser(email) != null) {
                throw new ServiceException("User with this email is already registered");
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void signInNewUser(String email, String password, String name,
                                     String surname, UserType userType) throws ServiceException {
        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
        byte[] salt;
        try {
            salt = passwordEncryptionService.generateSalt();
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        }

        byte[] encryptedPassword;
        try {
            encryptedPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        } catch (Exception e) {
            throw new ServiceException(e);
        }

        signInDao.createNewUser(email, encryptedPassword, salt, name, surname, userType);

    }
}
