// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53RecoveryReadiness.Outputs
{

    [OutputType]
    public sealed class ResourceSetResourceDnsTargetResourceTargetResource
    {
        /// <summary>
        /// NLB resource a DNS Target Resource points to. Required if `r53_resource` is not set.
        /// </summary>
        public readonly Outputs.ResourceSetResourceDnsTargetResourceTargetResourceNlbResource? NlbResource;
        /// <summary>
        /// Route53 resource a DNS Target Resource record points to.
        /// </summary>
        public readonly Outputs.ResourceSetResourceDnsTargetResourceTargetResourceR53Resource? R53Resource;

        [OutputConstructor]
        private ResourceSetResourceDnsTargetResourceTargetResource(
            Outputs.ResourceSetResourceDnsTargetResourceTargetResourceNlbResource? nlbResource,

            Outputs.ResourceSetResourceDnsTargetResourceTargetResourceR53Resource? r53Resource)
        {
            NlbResource = nlbResource;
            R53Resource = r53Resource;
        }
    }
}
