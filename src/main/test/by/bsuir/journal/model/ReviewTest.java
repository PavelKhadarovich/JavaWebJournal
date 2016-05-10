package by.bsuir.journal.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Вероника on 07.05.2016.
 */
public class ReviewTest {

    private Review review = new Review();
    private Review reviewForSet  = new Review();

    @Before
    public void setUp() throws Exception {
        review.setMark(10);
        review.setTitle("title");
        review.setShortDescription("description");
        review.setText("text");
        review.setPictureSource("image.jpg");
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("title", review.getTitle());
    }

    @Test
    public void testSetTitle() throws Exception {
        reviewForSet.setTitle("title");
        assertEquals("title", reviewForSet.getTitle());
    }

    @Test
    public void testGetShortDescription() throws Exception {
        assertEquals("description", review.getShortDescription());
    }

    @Test
    public void testSetShortDescription() throws Exception {
        reviewForSet.setShortDescription("description");
        assertEquals("description", reviewForSet.getShortDescription());
    }

    @Test
    public void testGetText() throws Exception {
        assertNotNull("text", review.getText());
    }

    @Test
    public void testSetText() throws Exception {
        reviewForSet.setText("text");
        assertNotNull("text", reviewForSet.getText());
    }

    @Test
    public void testGetMark() throws Exception {
        assertNotNull(String.valueOf(10), String.valueOf(review.getMark()));
    }

    @Test
    public void testSetMark() throws Exception {
        reviewForSet.setMark(10);
        assertNotNull(String.valueOf(10), String.valueOf(reviewForSet.getMark()));
    }

    @Test
    public void testGetPictureSource() throws Exception {
        assertEquals("image.jpg", review.getPictureSource());
    }

    @Test
    public void testSetPictureSource() throws Exception {
        reviewForSet.setPictureSource("image.jpg");
        assertEquals("image.jpg", reviewForSet.getPictureSource());
    }
}