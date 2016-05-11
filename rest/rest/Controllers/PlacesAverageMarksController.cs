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
    public class PlacesAverageMarksController : ApiController
    {
        public FileCreationResult Get()
        {
            using (var context = new journalEntities())
            {
                var places = context.place.Where(x => true).ToList();
                return ExcelFileSaver.SavePlacesAverageMarks(places);
            }
        }
    }
}
