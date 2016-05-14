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
        private PdfWriter _pdfWriter;


        public MemoryStream Output { get; private set; }

        public Document Document { get; private set; }


        public PdfWrapper(string fileName)
        {
            Output = new MemoryStream();
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
        }

        public void MakeStreamClosable()
        {
            if (_pdfWriter.CloseStream)
            {
                throw new InvalidOperationException();
            }

            _pdfWriter.CloseStream = true;
        }

        private void SetHeaderAndFooterGenerator()
        {
            _pdfWriter.PageEvent = new Footer();
        }

        private void SetWriterAndEncription()
        {
            _pdfWriter = PdfWriter.GetInstance(Document, Output);
            _pdfWriter.CloseStream = false;
            _pdfWriter.SetEncryption(new byte[] { }, new byte[] { }, 0, PdfWriter.ENCRYPTION_AES_128);
        }

        private void OpenDocument()
        {
            Document.Open();
            Document.NewPage();
        }
    }
}