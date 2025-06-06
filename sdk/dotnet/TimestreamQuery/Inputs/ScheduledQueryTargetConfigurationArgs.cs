// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamQuery.Inputs
{

    public sealed class ScheduledQueryTargetConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for information needed to write data into the Timestream database and table. See below.
        /// </summary>
        [Input("timestreamConfiguration")]
        public Input<Inputs.ScheduledQueryTargetConfigurationTimestreamConfigurationArgs>? TimestreamConfiguration { get; set; }

        public ScheduledQueryTargetConfigurationArgs()
        {
        }
        public static new ScheduledQueryTargetConfigurationArgs Empty => new ScheduledQueryTargetConfigurationArgs();
    }
}
