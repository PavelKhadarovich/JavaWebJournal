using iTextSharp.text;
using iTextSharp.text.pdf;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace rest.Functionality
{
    public sealed class PdfCellWrapper
    {
        private PdfTableWrapper _parentTableWrapper;
        private PdfPCell _cell;


        public PdfCellWrapper(PdfTableWrapper tableWrapper, string text)
        {
            _parentTableWrapper = tableWrapper;
            _cell = new PdfPCell(new Phrase(text));
        }


        public PdfCellWrapper Colspan(int colspan)
        {
            _cell.Colspan = colspan;

            return this;
        }

        public PdfCellWrapper BackgroundColor(int red, int green, int blue)
        {
            _cell.BackgroundColor = new BaseColor(red, green, blue);

            return this;
        }

        public PdfTableWrapper End()
        {
            _parentTableWrapper.Table.AddCell(_cell);

            return _parentTableWrapper;
        }
    }
}