// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Inputs
{

    public sealed class FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverArgs : global::Pulumi.ResourceArgs
    {
        [Input("bucketName", required: true)]
        public Input<string> BucketName { get; set; } = null!;

        [Input("bucketPrefix")]
        public Input<string>? BucketPrefix { get; set; }

        [Input("s3OutputFormatConfig", required: true)]
        public Input<Inputs.FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverS3OutputFormatConfigArgs> S3OutputFormatConfig { get; set; } = null!;

        public FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverArgs()
        {
        }
        public static new FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverArgs Empty => new FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverArgs();
    }
}
