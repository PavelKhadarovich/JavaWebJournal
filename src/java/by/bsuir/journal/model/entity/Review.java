package by.bsuir.journal.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.List;

/**
 * Created by test on 09.03.2016.
 */
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(length = 100, columnDefinition = "nvarchar", name = "title")
    private String title;

    @Column(length = 250, columnDefinition = "nvarchar", name = "short_description")
    private String shortDescription;

    @Column(columnDefinition = "text", name = "text")
    private String text;

    @Column(name = "mark")
    private int mark;

    @Column(length = 255, name = "picture_source")
    private String pictureSource;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "status")
    private ReviewStatus status;

    @ManyToOne
    @JoinColumn(name = "id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "id")
    private Place place;

    @OneToMany(mappedBy = "review")
    private List<ReviewComment> reviewComments;

    @OneToMany(mappedBy = "review")                 // review could have no tasks, should i have to specify this in a special way or not?
    private List<Task> tasks;

    public enum ReviewStatus {
        NEW, PUBLISHED, DELETED
    }

    public Review() {}

    public Review(String title, String shortDescription, String text, int mark, String pictureSource, Timestamp dateCreated, Place place, ReviewStatus status, User author, List<ReviewComment> reviewComments, List<Task> tasks) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.text = text;
        this.mark = mark;
        this.pictureSource = pictureSource;
        this.dateCreated = dateCreated;
        this.place = place;
        this.status = status;
        this.author = author;
        this.reviewComments = reviewComments;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public String getPictureSource() {
        return pictureSource;
    }

    public void setPictureSource(String pictureSource) {
        this.pictureSource = pictureSource;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public ReviewStatus getStatus() {
        return status;
    }

    public void setStatus(ReviewStatus status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<ReviewComment> getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(List<ReviewComment> reviewComments) {
        this.reviewComments = reviewComments;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;

        Review review = (Review) o;

        if (getId() != review.getId()) return false;
        if (getMark() != review.getMark()) return false;
        if (!getTitle().equals(review.getTitle())) return false;
        if (!getShortDescription().equals(review.getShortDescription())) return false;
        if (!getText().equals(review.getText())) return false;
        if (!getPictureSource().equals(review.getPictureSource())) return false;
        if (!getDateCreated().equals(review.getDateCreated())) return false;
        if (!getPlace().equals(review.getPlace())) return false;
        if (getStatus() != review.getStatus()) return false;
        if (!getAuthor().equals(review.getAuthor())) return false;
        if (!getReviewComments().equals(review.getReviewComments())) return false;
        return getTasks() != null ? getTasks().equals(review.getTasks()) : review.getTasks() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getShortDescription().hashCode();
        result = 31 * result + getText().hashCode();
        result = 31 * result + getMark();
        result = 31 * result + getPictureSource().hashCode();
        result = 31 * result + getDateCreated().hashCode();
        result = 31 * result + getPlace().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getReviewComments().hashCode();
        result = 31 * result + (getTasks() != null ? getTasks().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", text='" + text + '\'' +
                ", mark=" + mark +
                ", pictureSource='" + pictureSource + '\'' +
                ", dateCreated=" + dateCreated +
                ", place=" + place +
                ", status=" + status +
                ", author=" + author +
                ", reviewComments=" + reviewComments +
                ", tasks=" + tasks +
                '}';
    }
}
