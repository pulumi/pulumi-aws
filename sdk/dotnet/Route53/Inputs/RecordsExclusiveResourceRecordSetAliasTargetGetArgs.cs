// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Inputs
{

    public sealed class RecordsExclusiveResourceRecordSetAliasTargetGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// DNS domain name for another resource record set in this hosted zone.
        /// </summary>
        [Input("dnsName", required: true)]
        public Input<string> DnsName { get; set; } = null!;

        /// <summary>
        /// Set to `true` if you want Route 53 to determine whether to respond to DNS queries using this resource record set by checking the health of the resource record set. Some resources have special requirements, see [the AWS documentation](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/resource-record-sets-values.html#rrsets-values-alias-evaluate-target-health) for additional details.
        /// </summary>
        [Input("evaluateTargetHealth", required: true)]
        public Input<bool> EvaluateTargetHealth { get; set; } = null!;

        /// <summary>
        /// Hosted zone ID for a CloudFront distribution, S3 bucket, ELB, AWS Global Accelerator, or Route 53 hosted zone. See `resource_elb.zone_id` for an example.
        /// </summary>
        [Input("hostedZoneId", required: true)]
        public Input<string> HostedZoneId { get; set; } = null!;

        public RecordsExclusiveResourceRecordSetAliasTargetGetArgs()
        {
        }
        public static new RecordsExclusiveResourceRecordSetAliasTargetGetArgs Empty => new RecordsExclusiveResourceRecordSetAliasTargetGetArgs();
    }
}
