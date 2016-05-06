package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.impl.ReviewCommentDaoImpl;
import by.bsuir.journal.dao.impl.ReviewDaoImpl;
import by.bsuir.journal.model.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Вероника on 05.05.2016.
 */
public class ReviewCommentServiceImplTest {

    private ReviewCommentDaoImpl daoMock;
    private ReviewCommentServiceImpl serviceMock;

    private ReviewDaoImpl daoMock2;
    private ReviewServiceImpl serviceMock2;

    @Before
    public void setUp() throws Exception {
        daoMock = mock(ReviewCommentDaoImpl.class);
        serviceMock = new ReviewCommentServiceImpl(daoMock);

        daoMock2 = mock(ReviewDaoImpl.class);
        serviceMock2 = new ReviewServiceImpl(daoMock2);
    }

    @Test
    public void testFindAllReviewComments() throws Exception {
        Review review = new Review();
        when(serviceMock2.findById(any(Integer.class))).thenReturn(review);


        assertNotNull(serviceMock.findAllReviewComments(review));
    }
}