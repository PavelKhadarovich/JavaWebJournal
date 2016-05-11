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
    public class UserTypeController : ApiController
    {
        public FileCreationResult Get()
        {
            using (var context = new journalEntities())
            {
                return CsvFileSaver.SaveUserTypeInfo(context.app_user);
            }
        }
    }
}
