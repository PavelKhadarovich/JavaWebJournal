package by.bsuir.journal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "reviewcomment")
public class ReviewComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewcomment_id")
    private int id;

    @Column(length = 500, columnDefinition = "nvarchar", name = "text")
    private String text;

    @Column(name = "mark")
    private int mark;

    @ManyToOne
    @JoinColumn(name = "review_id")
    @JsonBackReference
    private Review review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public ReviewComment() {
    }

    public ReviewComment(String text, int mark, Review review, User user) {
        this.text = text;
        this.mark = mark;
        this.review = review;
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ReviewComment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", mark=" + mark +
                ", review=" + review +
                ", user=" + user +
                '}';
    }
}
