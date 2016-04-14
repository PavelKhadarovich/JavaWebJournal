package by.bsuir.journal.model.dao;

import by.bsuir.journal.model.entity.User;
import by.bsuir.journal.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 *
 */
public class UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);

    public boolean find(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = " from User u where u.name=:name and u.passwordHash=:passwordHash";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        query.setParameter("passwordHash", password);
        List<User> list = query.list();
        if (list.size() > 0) {
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}
