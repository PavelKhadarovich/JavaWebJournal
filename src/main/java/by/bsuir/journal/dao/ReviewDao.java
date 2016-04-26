package by.bsuir.journal.dao;

import by.bsuir.journal.model.Review;

import java.util.List;

/**
 * Created by Вероника on 25.04.2016.
 */
public interface ReviewDao {
    Review findById(int id);

    Review findByTitle(String title);

    Review findByTaskId(String title);

    void save(Review review);

    void deleteByTitle(String title);

    List<Review> findAllReviews();
}
