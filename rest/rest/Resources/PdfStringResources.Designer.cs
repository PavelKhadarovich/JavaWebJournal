﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace rest.Resources {
    using System;
    
    
    /// <summary>
    ///   A strongly-typed resource class, for looking up localized strings, etc.
    /// </summary>
    // This class was auto-generated by the StronglyTypedResourceBuilder
    // class via a tool like ResGen or Visual Studio.
    // To add or remove a member, edit your .ResX file then rerun ResGen
    // with the /str option, or rebuild your VS project.
    [global::System.CodeDom.Compiler.GeneratedCodeAttribute("System.Resources.Tools.StronglyTypedResourceBuilder", "4.0.0.0")]
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
    [global::System.Runtime.CompilerServices.CompilerGeneratedAttribute()]
    internal class PdfStringResources {
        
        private static global::System.Resources.ResourceManager resourceMan;
        
        private static global::System.Globalization.CultureInfo resourceCulture;
        
        [global::System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1811:AvoidUncalledPrivateCode")]
        internal PdfStringResources() {
        }
        
        /// <summary>
        ///   Returns the cached ResourceManager instance used by this class.
        /// </summary>
        [global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced)]
        internal static global::System.Resources.ResourceManager ResourceManager {
            get {
                if (object.ReferenceEquals(resourceMan, null)) {
                    global::System.Resources.ResourceManager temp = new global::System.Resources.ResourceManager("rest.Resources.PdfStringResources", typeof(PdfStringResources).Assembly);
                    resourceMan = temp;
                }
                return resourceMan;
            }
        }
        
        /// <summary>
        ///   Overrides the current thread's CurrentUICulture property for all
        ///   resource lookups using this strongly typed resource class.
        /// </summary>
        [global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced)]
        internal static global::System.Globalization.CultureInfo Culture {
            get {
                return resourceCulture;
            }
            set {
                resourceCulture = value;
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to Journal Portal.
        /// </summary>
        internal static string DocumentIntro {
            get {
                return ResourceManager.GetString("DocumentIntro", resourceCulture);
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to With regards, journals portal.
        /// </summary>
        internal static string DocumentOutro {
            get {
                return ResourceManager.GetString("DocumentOutro", resourceCulture);
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to EmployeeBuisiness.pdf.
        /// </summary>
        internal static string EmployeeBuisinessFileName {
            get {
                return ResourceManager.GetString("EmployeeBuisinessFileName", resourceCulture);
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to Employee.
        /// </summary>
        internal static string EmployeeParagraph {
            get {
                return ResourceManager.GetString("EmployeeParagraph", resourceCulture);
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to Employees buisiness in month.
        /// </summary>
        internal static string MergedEmployeeHeader {
            get {
                return ResourceManager.GetString("MergedEmployeeHeader", resourceCulture);
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to application/pdf.
        /// </summary>
        internal static string PdfMimeType {
            get {
                return ResourceManager.GetString("PdfMimeType", resourceCulture);
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to PlaceDescription.pdf.
        /// </summary>
        internal static string PlaceDescriptionFileName {
            get {
                return ResourceManager.GetString("PlaceDescriptionFileName", resourceCulture);
            }
        }
    }
}