using iTextSharp.text;
using iTextSharp.text.pdf;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace rest.Functionality
{
    public class PdfWrapper
    {
        private FileStream _output;
        private PdfWriter _pdfWriter;

        public Document Document { get; private set; }


        public PdfWrapper(string fileName)
        {
            _output = new FileStream(fileName, FileMode.Create, FileAccess.Write, FileShare.None);
        }

        public PdfWrapper StartDocument()
        {
            Document = new Document(PageSize.A4);
            SetWriterAndEncription();
            SetHeaderAndFooterGenerator();
            OpenDocument();

            return this;
        }

        public PdfWrapper StartDocument(int margineft, int marginRight, int marginTop, int marginBottom)
        {
            Document = new Document(PageSize.A4, 40, 40, 100, 100);
            SetWriterAndEncription();
            SetHeaderAndFooterGenerator();
            OpenDocument();

            return this;
        }

        public PdfParagraphWrapper CreateParagraph(string text)
        {
            return new PdfParagraphWrapper(this, text);
        }

        public PdfImageWrapper CreateImage(string path)
        {
            return new PdfImageWrapper(this, path);
        }

        public PdfTableWrapper CreateTable(int columnsCount)
        {
            return new PdfTableWrapper(this, columnsCount);
        }

        public void EndDocument()
        {
            Document.Close();
            _pdfWriter.Close();
            _output.Close();
        }


        private void SetHeaderAndFooterGenerator()
        {
            _pdfWriter.PageEvent = new Footer();
        }

        private void SetWriterAndEncription()
        {
            _pdfWriter = PdfWriter.GetInstance(Document, _output);
            _pdfWriter.SetEncryption(new byte[] { }, new byte[] { }, 0, PdfWriter.ENCRYPTION_AES_128);
        }

        private void OpenDocument()
        {
            Document.Open();
            Document.NewPage();
        }

        //private void 
    }
}