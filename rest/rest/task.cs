//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace rest
{
    using System;
    using System.Collections.Generic;
    
    public partial class task
    {
        public int task_id { get; set; }
        public string title { get; set; }
        public string description { get; set; }
        public System.DateTime datecreated { get; set; }
        public string status { get; set; }
        public Nullable<System.DateTime> changeddate { get; set; }
        public int user_id { get; set; }
        public int place_id { get; set; }
    
        public virtual app_user app_user { get; set; }
        public virtual place place { get; set; }
    }
}