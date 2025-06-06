// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Outputs
{

    [OutputType]
    public sealed class FlowDestinationFlowConfigDestinationConnectorPropertiesZendeskErrorHandlingConfig
    {
        /// <summary>
        /// Name of the Amazon S3 bucket.
        /// </summary>
        public readonly string? BucketName;
        /// <summary>
        /// Amazon S3 bucket prefix.
        /// </summary>
        public readonly string? BucketPrefix;
        /// <summary>
        /// If the flow should fail after the first instance of a failure when attempting to place data in the destination.
        /// </summary>
        public readonly bool? FailOnFirstDestinationError;

        [OutputConstructor]
        private FlowDestinationFlowConfigDestinationConnectorPropertiesZendeskErrorHandlingConfig(
            string? bucketName,

            string? bucketPrefix,

            bool? failOnFirstDestinationError)
        {
            BucketName = bucketName;
            BucketPrefix = bucketPrefix;
            FailOnFirstDestinationError = failOnFirstDestinationError;
        }
    }
}
