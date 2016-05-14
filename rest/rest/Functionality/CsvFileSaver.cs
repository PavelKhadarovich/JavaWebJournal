using rest.FileCreation;
using rest.Resources;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Web.Configuration;

namespace rest.Functionality
{
    public static class CsvFileSaver
    {
        private const string separator = ",";
        private const string quote = "\"";

        public static MemoryStream SaveUserTypeInfo(IEnumerable<app_user> users)
        {
            var output = new MemoryStream();

            try
            {
                var headers = new[] { CsvStringResources.UserHeader, CsvStringResources.TypeHeader };
                WriteLineToStream(output, headers);

                foreach (var user in users)
                {
                    foreach (var type in user.user_profile)
                    {
                        WriteLineToStream(output, new[] { String.Format("{0} {1}", user.first_name, user.last_name), type.type });
                    }
                }
            }
            catch
            {
                output.Dispose();
                throw;
            }

            return output;
        }


        private static void WriteLineToStream(Stream stream, IEnumerable<string> elementsOfCsvLine)
        {
            var concatedMessage = String.Join(separator, elementsOfCsvLine.Select(x => ChangeIfContainsQuoteOrSeparator(x)));
            concatedMessage += Environment.NewLine;

            var messageInBytes = Encoding.UTF8.GetBytes(concatedMessage);
            stream.Write(messageInBytes, 0, messageInBytes.Length);
        }

        private static string ChangeIfContainsQuoteOrSeparator(string text)
        {
            if (text.Contains(separator) || text.Contains(quote))
                text = quote + text.Replace(quote, "\"\"") + quote;

            return text;
        }

    }
}