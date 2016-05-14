using rest.FileCreation;
using rest.Resources;
using rest.Functionality;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Mvc;
using System.Web.Http;
using System.Web.Mvc;

namespace rest.Controllers
{
    public class UserTypeController : Controller
    {
        public ActionResult Csv()
        {
            MemoryStream result = null;

            using (var context = new journalEntities())
            {
                try
                {
                    result = CsvFileSaver.SaveUserTypeInfo(context.app_user);
                    result.Position = 0;

                    return File(result, CsvStringResources.CsvMimeType, CsvStringResources.FileName);
                }
                catch
                {
                    return new HttpStatusCodeResult(500);
                }
            }
        }
    }
}
