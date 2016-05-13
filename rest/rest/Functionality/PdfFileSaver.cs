
using iTextSharp.text;
using iTextSharp.text.pdf;
using rest.FileCreation;
using rest.Resources;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Configuration;

namespace rest.Functionality
{
    public static class PdfFileSaver
    {
        public static FileCreationResult SaveEmployeesBuisinessByMonth(IEnumerable<app_user> employees)
        {
            var pdfWrapper = new PdfWrapper(WebConfigurationManager.AppSettings["documentsDirectory"] + PdfStringResources.EmployeeBuisinessFileName);

            try
            {
                var wrapper = pdfWrapper.StartDocument(40, 40, 100, 100)
                    .CreateParagraph(PdfStringResources.EmployeeParagraph)
                        .SetFont(BaseFont.TIMES_ROMAN, 25, Font.BOLD, BaseColor.BLUE)
                        .Alignment(Element.ALIGN_CENTER)
                        .SpacingBefore(30)
                    .EndParagraph()
                    .CreateTable(3)
                        .SpacingBefore(50)
                        .Cell(PdfStringResources.MergedEmployeeHeader)
                            .Colspan(3)
                            .BackgroundColor(155, 155, 155)
                        .End()
                        .Cell("Employee")
                        .End()
                        .Cell("Tasks in month")
                        .End()
                        .Cell("Tasks enumeration")
                        .End();

                if (employees.Count() == 0)
                {
                    wrapper = wrapper.Cell("No Employees! Hire someone!")
                            .Colspan(3)
                        .End();
                }
                else
                {
                    foreach (var employee in employees)
                    {
                        wrapper = wrapper.Cell(String.Format("{0} {1}", employee.first_name, employee.last_name))
                            .End()
                            .Cell(employee.task.Count.ToString())
                            .End();

                        var tasksThisMonth = String.Empty;
                        tasksThisMonth = String.Join(Environment.NewLine, employee.task.Where(t => t.datecreated > DateTime.Now.AddMonths(-1)).Select(t => t.title));
                        if (String.Compare(tasksThisMonth, String.Empty) == 0)
                        {
                            wrapper = wrapper.Cell(tasksThisMonth)
                                    .BackgroundColor(255, 0, 0)
                                .End();
                        }
                        else
                        {
                            wrapper = wrapper.Cell(tasksThisMonth)
                                .End();
                        }
                    }
                }

                wrapper.End()
                    .EndDocument();
            }
            catch
            {
                return FileCreationResult.CreateUnsuccessful(FileCreationStatus.InternalWebServiceError);
            }
            finally
            {
                pdfWrapper.EndDocument();
            }

            return FileCreationResult.CreateSuccessful();
        }

        public static FileCreationResult SavePlaceDescription(review review)
        {
            var pdfWrapper = new PdfWrapper(WebConfigurationManager.AppSettings["documentsDirectory"] + PdfStringResources.PlaceDescriptionFileName);

            try
            {
                pdfWrapper.StartDocument(40, 40, 100, 100)
                    .CreateParagraph(review.title)
                        .SetFont(BaseFont.TIMES_ROMAN, 25, Font.BOLD, BaseColor.BLUE)
                        .Alignment(Element.ALIGN_CENTER)
                        .SpacingAfter(20)
                    .EndParagraph()
                    .CreateImage(review.picture)
                        .ScaleAbsolute(170f, 170f)
                        .Alignment(Image.TEXTWRAP | Image.ALIGN_RIGHT)
                        .IdentationLeft(9f)
                        .SpacingAfter(9f)
                    .End()
                    .CreateParagraph(review.text)
                        .SetFont(BaseFont.TIMES_ROMAN, 18, Font.NORMAL, BaseColor.BLACK)
                    .EndPhrase()
                    .CreateParagraph("Review made by " + review.app_user.first_name + " " + review.app_user.last_name)
                        .SetFont(BaseFont.COURIER, 25, Font.BOLD, BaseColor.BLUE)
                        .SpacingBefore(20)
                    .EndParagraph();
            }
            catch
            {
                return FileCreationResult.CreateUnsuccessful(FileCreationStatus.InternalWebServiceError);
            }
            finally
            {
                pdfWrapper.EndDocument();
            }

            return FileCreationResult.CreateSuccessful();
        }
    }
}
