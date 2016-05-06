package by.bsuir.journal.controller;


import by.bsuir.journal.model.Review;
import by.bsuir.journal.service.ReviewService;
import by.bsuir.journal.model.User;
import by.bsuir.journal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    //==============JSON===========================



    //==============JSP===========================

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
    public String updateReview(@Valid Review review, ModelMap model, BindingResult result, @PathVariable String title) {

        reviewService.updateReview(review);
        return "redirect:/reviewslist";
    }

    @RequestMapping(value = {"/reviews-delete-{title}"}, method = RequestMethod.GET)
    public String deleteReview(@PathVariable String title) {
        reviewService.deleteReviewByTitle(title);
        return "redirect:/reviewslist";
    }
}
