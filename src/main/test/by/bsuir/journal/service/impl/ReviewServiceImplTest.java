package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.impl.ReviewDaoImpl;
import by.bsuir.journal.model.Review;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Вероника on 05.05.2016.
 */
public class ReviewServiceImplTest {

    private ReviewDaoImpl daoMock;
    private ReviewServiceImpl serviceMock;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(ReviewDaoImpl.class);
        serviceMock = new ReviewServiceImpl(daoMock);
    }


    @Test
    public void testFindById() throws Exception {
        Review review = new Review();
        when(serviceMock.findById(any(Integer.class))).thenReturn(review);
        assertEquals(review, serviceMock.findById(any(Integer.class)));
    }

    @Test
    public void testFindByTitle() throws Exception {
        Review review = new Review();
        when(serviceMock.findByTitle(any(String.class))).thenReturn(review);
        assertEquals(review, serviceMock.findByTitle(any(String.class)));
    }

    @Test
    public void testFindByTaskId() throws Exception {
        Review task = new Review();
        when(serviceMock.findByTaskId(any(String.class))).thenReturn(task);
        assertEquals(task, serviceMock.findByTaskId(any(String.class)));
    }

    @Test
    public void testSaveReview() throws Exception {
        Review review = new Review();
        when(serviceMock.findById(any(Integer.class))).thenReturn(review);

        serviceMock.saveReview(review);
        verify(daoMock).save(any(Review.class));

        verify(daoMock, times(1)).save(any(Review.class));
    }


    @Test
    public void testDeleteReviewByTitle() throws Exception {
        Review review = new Review();
        when(serviceMock.findById(any(Integer.class))).thenReturn(review);

        serviceMock.saveReview(review);
        serviceMock.deleteReviewByTitle(review.getTitle());
        verify(daoMock).save(any(Review.class));
        verify(daoMock).deleteByTitle(review.getTitle());

        verify(daoMock, times(1)).save(any(Review.class));
        verify(daoMock, times(1)).deleteByTitle(any(String.class));
    }

    @Test
    public void testFindAllReviews() throws Exception {
        assertNotNull(serviceMock.findAllReviews());
    }

    @Test
    public void testIsReviewTitleUnique() throws Exception {
        Review review = new Review();
        when(daoMock.findById(anyInt())).thenReturn(review);
        assertTrue(serviceMock.isReviewTitleUnique(review.getId(), review.getTitle()));
    }
}