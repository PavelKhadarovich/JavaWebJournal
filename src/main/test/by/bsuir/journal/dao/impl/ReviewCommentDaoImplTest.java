package by.bsuir.journal.dao.impl;

import by.bsuir.journal.model.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Вероника on 07.05.2016.
 */
public class ReviewCommentDaoImplTest {
    private ReviewCommentDaoImpl daoMock;
    @Before
    public void setUp() throws Exception {
        daoMock = mock(ReviewCommentDaoImpl.class);
    }

    @Test
    public void testFindAllReviewComments() throws Exception {
        Review r = new Review();
        assertNotNull(daoMock.findAllReviewComments(r));
    }
}