// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2TransitGateway.Outputs
{

    [OutputType]
    public sealed class GetVpnAttachmentFilterResult
    {
        /// <summary>
        /// Name of the filter field. Valid values can be found in the [EC2 DescribeTransitGatewayAttachments API Reference](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeTransitGatewayAttachments.html).
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Set of values that are accepted for the given filter field. Results will be selected if any given value matches.
        /// </summary>
        public readonly ImmutableArray<string> Values;

        [OutputConstructor]
        private GetVpnAttachmentFilterResult(
            string name,

            ImmutableArray<string> values)
        {
            Name = name;
            Values = values;
        }
    }
}
