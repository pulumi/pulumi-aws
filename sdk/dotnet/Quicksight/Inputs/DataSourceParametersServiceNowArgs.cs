// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class DataSourceParametersServiceNowArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The base URL of the Jira instance's site to which to connect.
        /// </summary>
        [Input("siteBaseUrl", required: true)]
        public Input<string> SiteBaseUrl { get; set; } = null!;

        public DataSourceParametersServiceNowArgs()
        {
        }
        public static new DataSourceParametersServiceNowArgs Empty => new DataSourceParametersServiceNowArgs();
    }
}
