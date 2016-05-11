using iTextSharp.text.pdf;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace rest.Functionality
{
    public class PdfTableWrapper
    {
        private PdfWrapper _parent;

        public PdfPTable Table { get; private set; }


        public PdfTableWrapper(PdfWrapper wrapper, int columnsCount)
        {
            _parent = wrapper;
            Table = new PdfPTable(columnsCount);
        }


        public PdfTableWrapper SpacingBefore(float space)
        {
            Table.SpacingBefore = space;

            return this;
        }

        public PdfCellWrapper Cell(string text)
        {
            return new PdfCellWrapper(this, text);
        }

        public PdfWrapper End()
        {
            _parent.Document.Add(Table);

            return _parent;
        }
    }
}