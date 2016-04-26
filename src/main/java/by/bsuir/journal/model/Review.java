package by.bsuir.journal.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "review")
public class Review {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int id;

    @Column(length = 100, columnDefinition = "nvarchar", name = "title")
    private String title;

    @Column(length = 250, columnDefinition = "nvarchar", name = "description")
    private String shortDescription;

    @Column(columnDefinition = "text", name = "text")
    private String text;

    @Column(name = "mark")
    private int mark;

    @Column(length = 255, name = "picture")
    private String pictureSource;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "status")
    private ReviewStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToMany(mappedBy = "review")
    private Set<ReviewComment> reviewComments;

    public enum ReviewStatus {
        NEW, COMPLETE
    }

    public Review() {}



    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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



    public Set<ReviewComment> getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(Set<ReviewComment> reviewComments) {
        this.reviewComments = reviewComments;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


}
