using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace rest.FileCreation
{
    public sealed class FileCreationResult
    {
        public FileCreationStatus FileCreationStatus { get; }

        public bool IsSuccessful
        {
            get
            {
                return FileCreationStatus == FileCreationStatus.Created;
            }
        }


        private FileCreationResult(FileCreationStatus fileCreationStatus)
        {
            FileCreationStatus = fileCreationStatus;
        }


        public static FileCreationResult CreateSuccessful()
        {
            return new FileCreationResult(FileCreationStatus.Created);
        }

        public static FileCreationResult CreateUnsuccessful(FileCreationStatus fileCreatingStatus)
        {
            if (fileCreatingStatus == FileCreationStatus.Created)
            {
                throw new InvalidOperationException();
            }

            return new FileCreationResult(fileCreatingStatus);
        }
    }
}