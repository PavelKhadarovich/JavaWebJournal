package by.bsuir.journal.dao.impl;

import by.bsuir.journal.model.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Вероника on 06.05.2016.
 */
public class ReviewDaoImplTest {
    private ReviewDaoImpl daoMock;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(ReviewDaoImpl.class);
    }

    @Test
    public void testFindById() throws Exception {
        Review review = new Review();
        when(daoMock.findById(any(Integer.class))).thenReturn(review);
        assertEquals(review, daoMock.findById(any(Integer.class)));

    }

    @Test
    public void testFindByTitle() throws Exception {
        Review review = new Review();
        when(daoMock.findByTitle(any(String.class))).thenReturn(review);
        assertEquals(review, daoMock.findByTitle(any(String.class)));

    }

    @Test
    public void testFindByTaskId() throws Exception {
        Review task = new Review();
        when(daoMock.findByTaskId(any(String.class))).thenReturn(task);
        assertEquals(task, daoMock.findByTaskId(any(String.class)));

    }

    @Test
    public void testSave() throws Exception {
        Review review = new Review();
        when(daoMock.findById(any(Integer.class))).thenReturn(review);

        daoMock.save(review);
        verify(daoMock).save(any(Review.class));

        verify(daoMock, times(1)).save(any(Review.class));
    }

    @Test
    public void testDeleteByTitle() throws Exception {
        Review review = new Review();
        when(daoMock.findById(any(Integer.class))).thenReturn(review);

        daoMock.save(review);
        daoMock.deleteByTitle(review.getTitle());
        verify(daoMock).save(any(Review.class));
        verify(daoMock).deleteByTitle(review.getTitle());

        verify(daoMock, times(1)).save(any(Review.class));
        verify(daoMock, times(1)).deleteByTitle(any(String.class));

    }

    @Test
    public void testFindAllReviews() throws Exception {
        assertNotNull(daoMock.findAllReviews());
    }
}