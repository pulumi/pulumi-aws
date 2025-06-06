// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ApiGateway.Outputs
{

    [OutputType]
    public sealed class StageAccessLogSettings
    {
        /// <summary>
        /// ARN of the CloudWatch Logs log group or Kinesis Data Firehose delivery stream to receive access logs. If you specify a Kinesis Data Firehose delivery stream, the stream name must begin with `amazon-apigateway-`. Automatically removes trailing `:*` if present.
        /// </summary>
        public readonly string DestinationArn;
        /// <summary>
        /// Formatting and values recorded in the logs.
        /// For more information on configuring the log format rules visit the AWS [documentation](https://docs.aws.amazon.com/apigateway/latest/developerguide/set-up-logging.html)
        /// </summary>
        public readonly string Format;

        [OutputConstructor]
        private StageAccessLogSettings(
            string destinationArn,

            string format)
        {
            DestinationArn = destinationArn;
            Format = format;
        }
    }
}
