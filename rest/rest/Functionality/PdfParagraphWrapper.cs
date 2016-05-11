using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using iTextSharp.text;
using iTextSharp.text.pdf;

namespace rest.Functionality
{
    public sealed class PdfParagraphWrapper
    {
        private PdfWrapper _parent;

        private string _text;
        private Font _font;
        private int _aligment;
        private float _spacingBefore;
        private float _spacingAfter;

        public PdfParagraphWrapper(PdfWrapper wrapper, string text)
        {
            _parent = wrapper;
            _text = text;
        }

        public PdfParagraphWrapper Alignment(int alignment)
        {
            _aligment = alignment;

            return this;
        }

        public PdfParagraphWrapper SpacingBefore(float spacing)
        {
            _spacingBefore = spacing;

            return this;
        }

        public PdfParagraphWrapper SpacingAfter(float spacing)
        {
            _spacingAfter = spacing;

            return this;
        }

        public PdfParagraphWrapper SetFont(string baseFont, int size, int style, BaseColor color)
        {
            var basefont = BaseFont.CreateFont(baseFont, BaseFont.CP1252, false);
            _font = new Font(basefont, size, style, color);

            return this;
        }

        public PdfWrapper EndParagraph()
        {
            Paragraph paragraph = null;

            if (_font != null)
            {
                paragraph = new Paragraph(_text, _font);
            }
            else
            {
                paragraph = new Paragraph(_text); 
            }

            paragraph.Alignment = _aligment;
            paragraph.SpacingAfter = _spacingAfter;
            paragraph.SpacingBefore = _spacingBefore;

            if (_font != null)
            {
                paragraph.Font = _font;
            }

            _parent.Document.Add(paragraph);

            return _parent;
        }

        public PdfWrapper EndPhrase()
        {
            Phrase phrase = null;

            if (_font != null)
            {
                phrase = new Phrase(_text, _font);
            }
            else
            {
                phrase = new Phrase(_text);
            }

            _parent.Document.Add(phrase);

            return _parent;
        }
    }
}