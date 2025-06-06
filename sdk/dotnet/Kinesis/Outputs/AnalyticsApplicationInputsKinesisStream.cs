// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Outputs
{

    [OutputType]
    public sealed class AnalyticsApplicationInputsKinesisStream
    {
        /// <summary>
        /// The ARN of the Kinesis Stream.
        /// </summary>
        public readonly string ResourceArn;
        /// <summary>
        /// The ARN of the IAM Role used to access the stream.
        /// </summary>
        public readonly string RoleArn;

        [OutputConstructor]
        private AnalyticsApplicationInputsKinesisStream(
            string resourceArn,

            string roleArn)
        {
            ResourceArn = resourceArn;
            RoleArn = roleArn;
        }
    }
}
