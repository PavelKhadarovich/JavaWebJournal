package by.bsuir.journal.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "reviews")
public class ReviewComment {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(length = 500, columnDefinition = "nvarchar", name = "text")
    private String text;

    @Column(name = "mark")
    private int mark;

    @ManyToOne
    @JoinColumn(name = "id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "id")
    private Review review;

    public ReviewComment() {}

    public ReviewComment(String text, int mark, User author, Review review) {
        this.text = text;
        this.mark = mark;
        this.author = author;
        this.review = review;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewComment)) return false;

        ReviewComment that = (ReviewComment) o;

        if (getId() != that.getId()) return false;
        if (getMark() != that.getMark()) return false;
        if (!getText().equals(that.getText())) return false;
        if (!getAuthor().equals(that.getAuthor())) return false;
        return getReview().equals(that.getReview());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getText().hashCode();
        result = 31 * result + getMark();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getReview().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ReviewComment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", mark=" + mark +
                ", author=" + author +
                ", review=" + review +
                '}';
    }
}
