package by.bsuir.journal.dao.impl;

import by.bsuir.journal.dao.AbstractDao;
import by.bsuir.journal.dao.ReviewDao;
import by.bsuir.journal.model.Review;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reviewDao")
public class ReviewDaoImpl extends AbstractDao<Integer, Review> implements ReviewDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Review findById(int id) {
        Review review = getByKey(id);
        return review;
    }

    public Review findByTitle(String title) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Review review = (Review) crit.uniqueResult();
        return review;
    }

    public Review findByTaskId(String id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("task_id", id));
        Review review = (Review) crit.uniqueResult();
        return review;
    }

    public void save(Review review) {
        persist(review);
    }

    public void deleteByTitle(String title) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Review review = (Review) crit.uniqueResult();
        delete(review);
    }

    public List<Review> findAllReviews() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Review.class);
        return criteria.list();
    }
}
