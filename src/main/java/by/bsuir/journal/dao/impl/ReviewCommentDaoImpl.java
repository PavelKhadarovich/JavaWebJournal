package by.bsuir.journal.dao.impl;

import by.bsuir.journal.dao.AbstractDao;
import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.ReviewComment;
import by.bsuir.journal.dao.ReviewCommentDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reviewCommentDao")
public class ReviewCommentDaoImpl extends AbstractDao<Integer, ReviewComment> implements ReviewCommentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(ReviewComment reviewComment) {
        persist(reviewComment);
    }

    public List<ReviewComment> findAllReviewComments(Review review) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ReviewComment.class);
        return criteria.list();
    }
}
