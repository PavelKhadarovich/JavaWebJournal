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
    public class EmployeeController : Controller
    {

        public ActionResult Pdf()
        {
            MemoryStream stream;

            using (var context = new journalEntities())
            {
                try
                {
                    var employees = context.app_user.Where(a => a.user_profile.Any(u => String.Compare(u.type, "employee", StringComparison.OrdinalIgnoreCase) == 0));
                    stream = PdfFileSaver.SaveEmployeesBuisinessByMonth(employees);
                    stream.Position = 0;

                    return File(stream, PdfStringResources.PdfMimeType, PdfStringResources.EmployeeBuisinessFileName);
                }
                catch
                {
                    return new HttpStatusCodeResult(500);
                }
            }
        }
    }
}
