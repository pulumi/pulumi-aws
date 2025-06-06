// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityLake.Inputs
{

    public sealed class SubscriberSourceGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Security Lake supports log and event collection for natively supported AWS services. See `aws_log_source_resource` Block below.
        /// </summary>
        [Input("awsLogSourceResource")]
        public Input<Inputs.SubscriberSourceAwsLogSourceResourceGetArgs>? AwsLogSourceResource { get; set; }

        /// <summary>
        /// Amazon Security Lake supports custom source types. See `custom_log_source_resource` Block below.
        /// </summary>
        [Input("customLogSourceResource")]
        public Input<Inputs.SubscriberSourceCustomLogSourceResourceGetArgs>? CustomLogSourceResource { get; set; }

        public SubscriberSourceGetArgs()
        {
        }
        public static new SubscriberSourceGetArgs Empty => new SubscriberSourceGetArgs();
    }
}
