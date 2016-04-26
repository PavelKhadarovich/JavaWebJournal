package by.bsuir.journal.model.dao;

import by.bsuir.journal.model.dao.exception.DaoException;
import by.bsuir.journal.model.entity.User;
import by.bsuir.journal.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 */
public class UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);

    private Session session = ((SessionFactory) ServletActionContext.getServletContext()
            .getAttribute(HibernateUtil.getKeyName())).openSession();

    public String getPasswordHash(String login) throws DaoException {
        User user = getUser(login);
        return user.getPasswordHash();
    }

    private User getUser(String login)throws DaoException{
        Criteria criteria = session.createCriteria(User.class);
        if(login!=null){
            criteria.add(Restrictions.eq("login",login));
        }else{
            throw new DaoException("Email cannot be null");
        }
        User user;
        try {
            user = (User) criteria.list().get(0);
        } catch (ClassCastException e) {
            throw new DaoException("Non-user entities retrieved from `users` table.", e);
        } catch (IndexOutOfBoundsException e) {
            throw new DaoException("Wrong email or password", e);
        }
        return user;
    }
}
