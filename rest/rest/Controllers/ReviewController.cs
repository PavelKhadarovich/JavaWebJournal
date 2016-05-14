using rest.Functionality;
using rest.Resources;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Mvc;

namespace rest.Controllers
{
    public class ReviewController : Controller
    {
        public ActionResult Pdf(int id)
        {
            MemoryStream result = null;

            using (var context = new journalEntities())
            {
                var review = context.review.FirstOrDefault(r => r.place_id == id);
                if (review != null)
                {
                    try
                    {
                        result = PdfFileSaver.SavePlaceDescription(review);
                        result.Position = 0;

                        return File(result, PdfStringResources.PdfMimeType, PdfStringResources.PlaceDescriptionFileName);
                    }
                    catch
                    {
                        return new HttpStatusCodeResult(500);
                    }
                }
                else
                {
                    return new HttpStatusCodeResult(400);
                }
            }
        }
    }
}
