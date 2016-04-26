package by.bsuir.journal.dao;

import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.ReviewComment;

import java.util.List;

/**
 * Created by Вероника on 25.04.2016.
 */
public interface ReviewCommentDao {

    void save(ReviewComment reviewComment);

    List<ReviewComment> findAllReviewComments(Review review);
}
