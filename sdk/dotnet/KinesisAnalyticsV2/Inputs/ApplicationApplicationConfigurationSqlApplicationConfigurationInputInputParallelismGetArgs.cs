// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Inputs
{

    public sealed class ApplicationApplicationConfigurationSqlApplicationConfigurationInputInputParallelismGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The number of in-application streams to create.
        /// </summary>
        [Input("count")]
        public Input<int>? Count { get; set; }

        public ApplicationApplicationConfigurationSqlApplicationConfigurationInputInputParallelismGetArgs()
        {
        }
        public static new ApplicationApplicationConfigurationSqlApplicationConfigurationInputInputParallelismGetArgs Empty => new ApplicationApplicationConfigurationSqlApplicationConfigurationInputInputParallelismGetArgs();
    }
}
