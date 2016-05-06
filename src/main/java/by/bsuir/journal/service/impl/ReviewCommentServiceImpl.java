package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.ReviewCommentDao;
import by.bsuir.journal.dao.impl.ReviewCommentDaoImpl;
import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.ReviewComment;
import by.bsuir.journal.service.ReviewCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reviewCommentService")
@Transactional
public class ReviewCommentServiceImpl implements ReviewCommentService{
    @Autowired
    private ReviewCommentDao dao;

    public ReviewCommentServiceImpl(){}
    public ReviewCommentServiceImpl(ReviewCommentDaoImpl dao){
        this.dao = dao;
    }

    public void saveReviewComment(ReviewComment reviewComment) {
        dao.save(reviewComment);
    }

    public List<ReviewComment> findAllReviewComments(Review review) {
        return dao.findAllReviewComments(review);
    }
}
