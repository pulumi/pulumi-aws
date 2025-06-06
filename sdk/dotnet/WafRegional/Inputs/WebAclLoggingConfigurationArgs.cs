// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafRegional.Inputs
{

    public sealed class WebAclLoggingConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of Kinesis Firehose Delivery Stream
        /// </summary>
        [Input("logDestination", required: true)]
        public Input<string> LogDestination { get; set; } = null!;

        /// <summary>
        /// Configuration block containing parts of the request that you want redacted from the logs. Detailed below.
        /// </summary>
        [Input("redactedFields")]
        public Input<Inputs.WebAclLoggingConfigurationRedactedFieldsArgs>? RedactedFields { get; set; }

        public WebAclLoggingConfigurationArgs()
        {
        }
        public static new WebAclLoggingConfigurationArgs Empty => new WebAclLoggingConfigurationArgs();
    }
}
