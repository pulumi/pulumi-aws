// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fis.Outputs
{

    [OutputType]
    public sealed class ExperimentTemplateStopCondition
    {
        /// <summary>
        /// Source of the condition. One of `none`, `aws:cloudwatch:alarm`.
        /// </summary>
        public readonly string Source;
        /// <summary>
        /// ARN of the CloudWatch alarm. Required if the source is a CloudWatch alarm.
        /// </summary>
        public readonly string? Value;

        [OutputConstructor]
        private ExperimentTemplateStopCondition(
            string source,

            string? value)
        {
            Source = source;
            Value = value;
        }
    }
}
