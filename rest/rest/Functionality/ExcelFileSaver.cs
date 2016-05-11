using ClosedXML.Excel;
using rest.FileCreation;
using rest.Resources;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Configuration;

namespace rest.Functionality
{
    public class ExcelFileSaver
    {
        public static FileCreationResult SavePlacesAverageMarks(IEnumerable<place> places)
        {
            var workbook = new XLWorkbook();
            try
            {
                var worksheet = workbook.Worksheets.Add("some");

                if (places.Count() == 0)
                {
                    worksheet.Cell(1, 1).Value = "No places yet";
                }
                else
                {
                    worksheet.Cell(1, 1).Value = "Average mark for places";

                    worksheet.Cell(3, 1).Value = "Place Name";
                    worksheet.Cell(3, 2).Value = "Place type";
                    worksheet.Cell(3, 3).Value = "City";
                    worksheet.Cell(3, 4).Value = "Street";
                    worksheet.Cell(3, 5).Value = "Average mark";

                    var headerrange = worksheet.Range(worksheet.Cell(3, 1), worksheet.Cell(3, 5));
                    headerrange.Style.Fill.SetBackgroundColor(XLColor.Gray);

                    headerrange.Style.Border.BottomBorder = XLBorderStyleValues.Medium;
                    headerrange.Style.Border.LeftBorder = XLBorderStyleValues.Medium;
                    headerrange.Style.Border.RightBorder = XLBorderStyleValues.Medium;
                    headerrange.Style.Border.TopBorder = XLBorderStyleValues.Medium;

                    int currentrow = 4;

                    foreach (var place in places)
                    {
                        worksheet.Cell(currentrow, 1).Value = place.name;
                        worksheet.Cell(currentrow, 2).Value = place.type;
                        worksheet.Cell(currentrow, 3).Value = place.city;
                        worksheet.Cell(currentrow, 4).Value = place.street;
                        worksheet.Cell(currentrow, 5).Value = (place.review.Average(r => r.mark)).ToString();

                        var range = worksheet.Range(worksheet.Cell(currentrow, 1), worksheet.Cell(currentrow, 5));
                        range.Style.Border.BottomBorder = XLBorderStyleValues.Medium;
                        range.Style.Border.LeftBorder = XLBorderStyleValues.Medium;
                        range.Style.Border.RightBorder = XLBorderStyleValues.Medium;

                        currentrow++;
                    }

                }

                worksheet.Columns().AdjustToContents();

                workbook.SaveAs(WebConfigurationManager.AppSettings["documentsDirectory"] + ExcelStringResources.PlacesStatisticsFileName);
            }
            catch
            {
                return FileCreationResult.CreateUnsuccessful(FileCreationStatus.InternalWebServiceError);
            }
            finally
            {
                workbook.Dispose();
            }

            return FileCreationResult.CreateSuccessful();
        }

        public static FileCreationResult SaveReviewCommentStatistics(IEnumerable<app_user> users, review review)
        {
            var workbook = new XLWorkbook();
            try
            {
                var worksheet = workbook.Worksheets.Add("some");

                if (users.Count() == 0)
                {
                    worksheet.Cell(1, 1).Value = "No comments for this review";
                }
                else
                {
                    worksheet.Cell(1, 1).Value = String.Format("Comments for review {0}", review.title);

                    worksheet.Cell(3, 1).Value = "Name";
                    worksheet.Cell(3, 2).Value = "Surname";
                    worksheet.Cell(3, 3).Value = "Average mark";
                    worksheet.Cell(3, 4).Value = "Comments count";

                    var headerrange = worksheet.Range(worksheet.Cell(3, 1), worksheet.Cell(3, 4));
                    headerrange.Style.Fill.SetBackgroundColor(XLColor.Gray);

                    headerrange.Style.Border.BottomBorder = XLBorderStyleValues.Medium;
                    headerrange.Style.Border.LeftBorder = XLBorderStyleValues.Medium;
                    headerrange.Style.Border.RightBorder = XLBorderStyleValues.Medium;
                    headerrange.Style.Border.TopBorder = XLBorderStyleValues.Medium;

                    int currentrow = 4;

                    foreach (var user in users)
                    {
                        worksheet.Cell(currentrow, 1).Value = user.first_name;
                        worksheet.Cell(currentrow, 2).Value = user.last_name;

                        var reviewComments = user.reviewcomment.Where(r => r.review_id == review.review_id);

                        worksheet.Cell(currentrow, 3).Value = reviewComments.Average(r => r.mark);
                        worksheet.Cell(currentrow, 4).Value = reviewComments.Count();

                        var range = worksheet.Range(worksheet.Cell(currentrow, 1), worksheet.Cell(currentrow, 4));
                        range.Style.Border.BottomBorder = XLBorderStyleValues.Medium;
                        range.Style.Border.LeftBorder = XLBorderStyleValues.Medium;
                        range.Style.Border.RightBorder = XLBorderStyleValues.Medium;

                        currentrow++;
                    }

                }

                worksheet.Columns().AdjustToContents();

                workbook.SaveAs(WebConfigurationManager.AppSettings["documentsDirectory"] + ExcelStringResources.ReviewStatisticsFileName);
            }
            catch
            {
                return FileCreationResult.CreateUnsuccessful(FileCreationStatus.InternalWebServiceError);
            }
            finally
            {
                workbook.Dispose();
            }

            return FileCreationResult.CreateSuccessful();
        }
    }
}