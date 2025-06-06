// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53RecoveryReadiness.Inputs
{

    public sealed class ResourceSetResourceDnsTargetResourceTargetResourceNlbResourceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// NLB resource ARN.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        public ResourceSetResourceDnsTargetResourceTargetResourceNlbResourceArgs()
        {
        }
        public static new ResourceSetResourceDnsTargetResourceTargetResourceNlbResourceArgs Empty => new ResourceSetResourceDnsTargetResourceTargetResourceNlbResourceArgs();
    }
}
