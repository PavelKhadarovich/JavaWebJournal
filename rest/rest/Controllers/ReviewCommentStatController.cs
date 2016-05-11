using rest.FileCreation;
using rest.Functionality;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace rest.Controllers
{
    public class ReviewCommentStatController : ApiController
    {
        public FileCreationResult Get([FromUri] int id)
        {
            using (var context = new journalEntities())
            {
                var review = context.review.FirstOrDefault(r => r.review_id == id);
                if (review != null)
                {
                    var usersThatCommentedTheReview = context.app_user.Where(a => a.reviewcomment.Any(r => r.review_id == id));
                    return ExcelFileSaver.SaveReviewCommentStatistics(usersThatCommentedTheReview, review);
                }

                return FileCreationResult.CreateUnsuccessful(FileCreationStatus.CannotBeCreatedWithSuchQuery);
            }
        }
    }
}
