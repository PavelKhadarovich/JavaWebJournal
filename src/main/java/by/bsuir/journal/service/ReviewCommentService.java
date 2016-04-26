package by.bsuir.journal.service;

import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.ReviewComment;

import java.util.List;

/**
 * Created by Вероника on 26.04.2016.
 */
public interface ReviewCommentService {
    void saveReviewComment(ReviewComment reviewComment);

    List<ReviewComment> findAllReviewComments(Review review);
}
