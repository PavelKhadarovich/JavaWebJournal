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
    public class PlacesAverageMarksController : Controller
    {
        public ActionResult Excel()
        {
            using (var context = new journalEntities())
            {
                var stream = new MemoryStream();

                var places = context.place.Where(x => true).ToList();

                try
                {
                    stream = ExcelFileSaver.SavePlacesAverageMarks(places);
                    stream.Position = 0;

                    return File(stream, ExcelStringResources.ExcelMimeType, ExcelStringResources.PlacesStatisticsFileName);
                }

                catch
                {
                    return new HttpStatusCodeResult(500);
                }
            }
        }
    }
}
