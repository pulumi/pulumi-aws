// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Outputs
{

    [OutputType]
    public sealed class ApplicationApplicationConfigurationSqlApplicationConfigurationOutputKinesisFirehoseOutput
    {
        /// <summary>
        /// The ARN of the destination delivery stream to write to.
        /// </summary>
        public readonly string ResourceArn;

        [OutputConstructor]
        private ApplicationApplicationConfigurationSqlApplicationConfigurationOutputKinesisFirehoseOutput(string resourceArn)
        {
            ResourceArn = resourceArn;
        }
    }
}
