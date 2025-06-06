// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class AnalysisSourceEntityArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The source template. See source_template.
        /// </summary>
        [Input("sourceTemplate")]
        public Input<Inputs.AnalysisSourceEntitySourceTemplateArgs>? SourceTemplate { get; set; }

        public AnalysisSourceEntityArgs()
        {
        }
        public static new AnalysisSourceEntityArgs Empty => new AnalysisSourceEntityArgs();
    }
}
