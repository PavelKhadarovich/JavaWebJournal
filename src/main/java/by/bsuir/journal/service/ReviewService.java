package by.bsuir.journal.service;


import by.bsuir.journal.model.Review;

import java.util.List;

/**
 * Created by Вероника on 26.04.2016.
 */
public interface ReviewService {
    Review findById(int id);

    Review findByTitle(String title);

    Review findByTaskId(String taskTitle);

    void saveReview(Review review);

    void updateReview(Review review);

    void deleteReviewByTitle(String title);

    List<Review> findAllReviews();

    boolean isReviewTitleUnique(Integer id, String title);
}
