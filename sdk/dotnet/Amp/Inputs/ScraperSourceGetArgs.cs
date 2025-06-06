// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Amp.Inputs
{

    public sealed class ScraperSourceGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for an EKS cluster source. See `eks`.
        /// </summary>
        [Input("eks")]
        public Input<Inputs.ScraperSourceEksGetArgs>? Eks { get; set; }

        public ScraperSourceGetArgs()
        {
        }
        public static new ScraperSourceGetArgs Empty => new ScraperSourceGetArgs();
    }
}
