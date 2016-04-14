package by.bsuir.journal.model.dao;

import by.bsuir.journal.listener.HibernateListener;
import by.bsuir.journal.model.dao.exception.DaoException;
import by.bsuir.journal.model.entity.User;
import by.bsuir.journal.model.entity.UserType;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Veronika.
 */
public class SignInDao {

    private Session session = ((SessionFactory) ServletActionContext.getServletContext()
            .getAttribute(HibernateListener.getKeyName())).openSession();

    public User getUser(String email) throws DaoException {
        Criteria criteria = session.createCriteria(User.class);
        if (email != null) {
            criteria.add(Restrictions.eq("email", email));
        } else {
            throw new DaoException("Email cannot be null");
        }
        User user;
        try {
            user = (User) criteria.list().get(0);
        } catch (ClassCastException e) {
            throw new DaoException("Non-user entities retrieved from `users` table.", e);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return user;
    }

    public void createNewUser(String email, byte[] encryptedPassword, byte[] salt, String name,
                              String surname, UserType userType) {
        session.beginTransaction();
        User user = new User(email, encryptedPassword, salt, name, surname, userType);
        session.save(user);
        session.getTransaction().commit();
    }
}
