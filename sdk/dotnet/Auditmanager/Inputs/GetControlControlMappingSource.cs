// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Auditmanager.Inputs
{

    public sealed class GetControlControlMappingSourceArgs : global::Pulumi.InvokeArgs
    {
        [Input("sourceDescription", required: true)]
        public string SourceDescription { get; set; } = null!;

        [Input("sourceFrequency", required: true)]
        public string SourceFrequency { get; set; } = null!;

        [Input("sourceId", required: true)]
        public string SourceId { get; set; } = null!;

        [Input("sourceKeyword")]
        public Inputs.GetControlControlMappingSourceSourceKeywordArgs? SourceKeyword { get; set; }

        [Input("sourceName", required: true)]
        public string SourceName { get; set; } = null!;

        [Input("sourceSetUpOption", required: true)]
        public string SourceSetUpOption { get; set; } = null!;

        [Input("sourceType", required: true)]
        public string SourceType { get; set; } = null!;

        [Input("troubleshootingText", required: true)]
        public string TroubleshootingText { get; set; } = null!;

        public GetControlControlMappingSourceArgs()
        {
        }
        public static new GetControlControlMappingSourceArgs Empty => new GetControlControlMappingSourceArgs();
    }
}
