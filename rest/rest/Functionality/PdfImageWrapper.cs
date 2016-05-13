using iTextSharp.text;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace rest.Functionality
{
    public sealed class PdfImageWrapper
    {
        private PdfWrapper _parent;

        private string _imageUrl;
        private int _alignment;
        private float _identationLeft;
        private float _identationRight;
        private float _spacingAfter;
        private bool _wasScailingSet;
        private float _scailingWidth;
        private float _scailingHeight;


        public PdfImageWrapper(PdfWrapper wrapper, string imageUrl)
        {
            _parent = wrapper;

            _imageUrl = imageUrl;
        }


        public PdfImageWrapper Alignment(int alignment)
        {
            _alignment = alignment;

            return this;
        }

        public PdfImageWrapper IdentationLeft(float identationLeft)
        {
            _identationLeft = identationLeft;

            return this;
        }

        public PdfImageWrapper IdentationRight(float identationRight)
        {
            _identationRight = identationRight;

            return this;
        }

        public PdfImageWrapper SpacingAfter(float spacingAfter)
        {
            _spacingAfter = spacingAfter;

            return this;
        }

        public PdfImageWrapper ScaleAbsolute(float width, float height)
        {
            _wasScailingSet = true;
            _scailingWidth = width;
            _scailingHeight = height;

            return this;
        }

        public PdfWrapper End()
        {
            var image = Image.GetInstance(_imageUrl);
            if (_wasScailingSet)
            {
                image.ScaleAbsolute(_scailingWidth, _scailingHeight);
            }
            image.Alignment = _alignment;
            image.IndentationLeft = _identationLeft;
            image.IndentationRight = _identationRight;
            image.SpacingAfter = _spacingAfter;

            var success = _parent.Document.Add(image);

            return _parent;
        }
    }
}
