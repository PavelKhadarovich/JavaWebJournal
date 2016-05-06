package by.bsuir.journal.controller;

import by.bsuir.journal.model.ReviewComment;
import by.bsuir.journal.model.User;
import by.bsuir.journal.service.ReviewCommentService;
import by.bsuir.journal.service.ReviewService;
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

@Controller
@RequestMapping
public class ReviewCommentController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewCommentService reviewCommentService;

    @Autowired
    MessageSource messageSource;

    //==============JSON===========================



    //==============JSP===========================

    @RequestMapping(value = {"/reviewsComment-create-{reviewId}"}, method = RequestMethod.GET)
    public String newTask(ModelMap model, @PathVariable String reviewId) {
        ReviewComment reviewComment = new ReviewComment();
        model.addAttribute("reviewComment", reviewComment);
        model.addAttribute("edit", false);
        return "createReviewComment";
    }

    @RequestMapping(value = {"/reviewsComment-create-{reviewId}"}, method = RequestMethod.POST)
    public String saveTask(@Valid ReviewComment reviewComment, ModelMap model, BindingResult result,
                           HttpSession session, @PathVariable int reviewId) {
        if (result.hasErrors()) {
            return "createReviewComment";
        }

        reviewComment.setUser((User) session.getAttribute("user"));
        reviewComment.setReview(reviewService.findById(reviewId));
        reviewCommentService.saveReviewComment(reviewComment);

        return "redirect:/reviewslist";
    }
}
