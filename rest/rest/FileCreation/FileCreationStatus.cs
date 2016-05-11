using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace rest.FileCreation
{
    public enum FileCreationStatus
    {
        Created,
        CannotBeCreatedWithSuchQuery,
        InternalWebServiceError
    }
}