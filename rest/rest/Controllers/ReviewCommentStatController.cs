using rest.FileCreation;
using rest.Functionality;
using rest.Resources;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Mvc;

namespace rest.Controllers
{
    public class ReviewCommentStatController : Controller
    {
        public ActionResult Excel([FromUri] int id)
        {
            MemoryStream result = null;

            using (var context = new journalEntities())
            {
                var review = context.review.FirstOrDefault(r => r.review_id == id);
                if (review != null)
                {
                    var usersThatCommentedTheReview = context.app_user.Where(a => a.reviewcomment.Any(r => r.review_id == id));
                    
                    try
                    {
                        result = ExcelFileSaver.SaveReviewCommentStatistics(usersThatCommentedTheReview, review);

                        result.Position = 0;
                        return File(result, ExcelStringResources.ExcelMimeType, ExcelStringResources.ReviewStatisticsFileName);
                    }
                    catch
                    {
                        return new HttpStatusCodeResult(500);
                    }
                }

                return new HttpStatusCodeResult(400);
            }
        }
    }
}
