package by.bsuir.journal.controller;


import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.User;
import by.bsuir.journal.service.ReviewService;
import by.bsuir.journal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    TaskService taskService;

    @Autowired
    MessageSource messageSource;

    //--------------------------------------------------------------------------------------------------//
    //--------------------------------------------JSON--------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//

    @RequestMapping(value = {"/review/"}, method = RequestMethod.GET)
    public ResponseEntity<List<Review>> reviewList() {
        System.out.println("Try to print list of users");
        List<Review> users = reviewService.findAllReviews();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Review>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = {"/review/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Review> getReview(@PathVariable("id") int id) {
        Review review = reviewService.findById(id);
        if (review == null) {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @RequestMapping(value = "/task/{id}/review/", method = RequestMethod.POST)
    public ResponseEntity<Void> createReview (HttpSession session,@RequestBody Review review,
                                              UriComponentsBuilder ucBuilder){
        if(!reviewService.isReviewTitleUnique(review.getId(),review.getTitle())){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());

        review.setMark(0);
        review.setDate(time);
        review.setStatus(Review.ReviewStatus.NEW);
        //todo
//        review.setTask(taskService.findByTitle(taskTitle));
        review.setCreator((User) session.getAttribute("user"));
//        review.setPlace(taskService.findByTitle(taskTitle).getPlace());

        reviewService.saveReview(review);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/review/{id}").buildAndExpand(review.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/review/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Review> updateReview(@PathVariable("id") int id, @RequestBody Review review) {
        Review currentReview  = reviewService.findById(id);

        if (currentReview == null) {
            System.out.println("Review with id " + id + " not found");
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }

        reviewService.updateReview(currentReview);
        return new ResponseEntity<Review>(currentReview, HttpStatus.OK);
    }

    @RequestMapping(value = "/review/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Review> deleteReview(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Review with id " + id);

        Review currentReview  = reviewService.findById(id);

        if (currentReview == null) {
            System.out.println("Review with id " + id + " not found");
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }

        reviewService.deleteReviewByTitle(currentReview.getTitle());
        return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
    }

    //--------------------------------------------------------------------------------------------------//
    //------------------------------------------JSP-----------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//

    @RequestMapping(value = {"/reviewslist"}, method = RequestMethod.GET)

    public String reviewsList(ModelMap model) {
        List<Review> reviews = reviewService.findAllReviews();
        model.addAttribute("reviews", reviews);
        return "reviewslist";
    }

    @RequestMapping(value = {"/reviews-create-{taskTitle}"}, method = RequestMethod.GET)
    public String newReview(ModelMap model, @PathVariable String taskTitle) {
        Review review = new Review();
        model.addAttribute("review", review);
        model.addAttribute("edit", false);
        return "createReview";
    }

    @RequestMapping(value = {"/reviews-create-{taskTitle}"}, method = RequestMethod.POST)
    public String saveReview(@Valid Review review, ModelMap model, BindingResult result,
                             HttpSession session, @PathVariable String taskTitle) {
        if (result.hasErrors()) {
            return "createReview";
        }
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());

        review.setMark(0);
        review.setDate(time);
        review.setStatus(Review.ReviewStatus.NEW);
        review.setTask(taskService.findByTitle(taskTitle));
        review.setCreator((User) session.getAttribute("user"));
        review.setPlace(taskService.findByTitle(taskTitle).getPlace());

        reviewService.saveReview(review);

        return "redirect:/reviewslist";
    }

    @RequestMapping(value = {"/reviews-edit-{title}"}, method = RequestMethod.GET)
    public String editReview(@PathVariable String title, ModelMap model) {
        Review review = reviewService.findByTitle(title);
        model.addAttribute("review", review);
        model.addAttribute("edit", true);
        return "createReview";
    }

    @RequestMapping(value = {"/reviews-edit-{title}"}, method = RequestMethod.POST)
    public String updateReviews(@Valid Review review, ModelMap model, BindingResult result, @PathVariable String title) {

        reviewService.updateReview(review);
        return "redirect:/reviewslist";
    }

    @RequestMapping(value = {"/reviews-delete-{title}"}, method = RequestMethod.GET)
    public String deleteReviews(@PathVariable String title) {
        reviewService.deleteReviewByTitle(title);
        return "redirect:/reviewslist";
    }
}
