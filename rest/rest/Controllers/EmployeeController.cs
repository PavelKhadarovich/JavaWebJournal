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
    public class EmployeeController : ApiController
    {
        public FileCreationResult Get()
        {
            using (var context = new journalEntities())
            {
                var employees = context.app_user.Where(a => a.user_profile.Any(u => String.Compare(u.type, "employee", StringComparison.OrdinalIgnoreCase) == 0));
                return PdfFileSaver.SaveEmployeesBuisinessByMonth(employees);
            }
        }
    }
}
