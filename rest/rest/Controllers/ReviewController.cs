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
    public class ReviewController : ApiController
    {
        public FileCreationResult Get([FromUri] int id)
        {
            using (var context = new journalEntities())
            {
                var review = context.review.FirstOrDefault(r => r.place_id == id);
                if (review != null)
                {
                    return PdfFileSaver.SavePlaceDescription(review);
                }

                return FileCreationResult.CreateUnsuccessful(FileCreationStatus.CannotBeCreatedWithSuchQuery);
            }
        }
    }
}
