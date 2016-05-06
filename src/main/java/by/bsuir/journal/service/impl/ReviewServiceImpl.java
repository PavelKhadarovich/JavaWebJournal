package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.impl.ReviewDaoImpl;
import by.bsuir.journal.model.Review;
import by.bsuir.journal.service.ReviewService;
import by.bsuir.journal.dao.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reviewService")
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao dao;


    public ReviewServiceImpl(){}
    public ReviewServiceImpl(ReviewDaoImpl dao){
        this.dao = dao;
    }

    public Review findById(int id) {
        return dao.findById(id);
    }

    public Review findByTitle(String title) {
        Review review = dao.findByTitle(title);
        return review;
    }

    public Review findByTaskId(String id) {
        Review review = dao.findByTaskId(id);
        return review;
    }

    public void saveReview(Review review) {
        dao.save(review);
    }

    public void updateReview(Review review) {
        Review entity = dao.findById(review.getId());
        if(entity!=null){
            entity.setTitle(review.getTitle());
            entity.setShortDescription(review.getShortDescription());
            entity.setText(review.getText());
            entity.setPictureSource(review.getPictureSource());
            entity.setMark(review.getMark());
        }
    }

    public void deleteReviewByTitle(String title) {
        dao.deleteByTitle(title);
    }

    public List<Review> findAllReviews() {
        return dao.findAllReviews();
    }

    public boolean isReviewTitleUnique(Integer id, String title) {
        Review review = dao.findById(id);
        return (review==null||
                ((id!=null)&&(review.getId()==id)));
    }
}
