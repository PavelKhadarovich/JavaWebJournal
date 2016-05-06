package by.bsuir.journal.controller;

import by.bsuir.journal.model.Review;
import by.bsuir.journal.model.ReviewComment;
import by.bsuir.journal.model.User;
import by.bsuir.journal.service.ReviewCommentService;
import by.bsuir.journal.service.ReviewService;
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
import java.util.List;

@Controller
@RequestMapping
public class ReviewCommentController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewCommentService reviewCommentService;

    @Autowired
    MessageSource messageSource;

    //--------------------------------------------------------------------------------------------------//
    //--------------------------------------------JSON--------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//

    @RequestMapping(value = {"/reviewComment/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<List<ReviewComment>> reviewCommentListOfConcreteReview(@PathVariable("id") int id) {

        Review review = reviewService.findById(id);

        System.out.println("Try to print list of comments");
        List<ReviewComment> comments = reviewCommentService.findAllReviewComments(review);
        if (comments.isEmpty()) {
            return new ResponseEntity<List<ReviewComment>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ReviewComment>>(comments, HttpStatus.OK);
    }



    @RequestMapping(value = "/reviewComment/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> createComment(HttpSession session, @PathVariable("id") int id, @RequestBody ReviewComment comment, UriComponentsBuilder ucBuilder) {

        Review review = reviewService.findById(id);

        comment.setUser((User) session.getAttribute("user"));
        comment.setReview(review);

        reviewCommentService.saveReviewComment(comment);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/reviewComment/{id}").buildAndExpand(review.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //--------------------------------------------------------------------------------------------------//
    //------------------------------------------JSP-----------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//

    @RequestMapping(value = {"/reviewsComment-create-{reviewId}"}, method = RequestMethod.GET)
    public String newReviewComment(ModelMap model, @PathVariable String reviewId) {
        ReviewComment reviewComment = new ReviewComment();
        model.addAttribute("reviewComment", reviewComment);
        model.addAttribute("edit", false);
        return "createReviewComment";
    }

    @RequestMapping(value = {"/reviewsComment-create-{reviewId}"}, method = RequestMethod.POST)
    public String saveReviewComment(@Valid ReviewComment reviewComment, ModelMap model, BindingResult result,
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
