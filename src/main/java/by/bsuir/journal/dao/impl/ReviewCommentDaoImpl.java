package by.bsuir.journal.dao.impl;

import by.bsuir.journal.dao.AbstractDao;
import by.bsuir.journal.dao.ReviewCommentDao;
import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.ReviewComment;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reviewCommentDao")
public class ReviewCommentDaoImpl extends AbstractDao<Integer, ReviewComment> implements ReviewCommentDao {

    public void save(ReviewComment reviewComment) {
        persist(reviewComment);
    }

    @SuppressWarnings("unchecked")
    public List<ReviewComment> findAllReviewComments(Review review) {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<ReviewComment> comments = (List<ReviewComment>)criteria.list();
        return comments;
    }
}
