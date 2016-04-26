package by.bsuir.journal.service.impl;

import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.ReviewComment;
import by.bsuir.journal.service.ReviewCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reviewCommentService")
@Transactional
public class ReviewCommentServiceImpl implements ReviewCommentService{
    public void saveReviewComment(ReviewComment reviewComment) {

    }

    public List<ReviewComment> findAllReviewComments(Review review) {
        return null;
    }
}
