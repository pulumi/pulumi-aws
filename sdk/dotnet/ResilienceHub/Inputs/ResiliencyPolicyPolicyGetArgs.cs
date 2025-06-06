// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ResilienceHub.Inputs
{

    public sealed class ResiliencyPolicyPolicyGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies Availability Zone failure policy. See `policy.az`
        /// </summary>
        [Input("az")]
        public Input<Inputs.ResiliencyPolicyPolicyAzGetArgs>? Az { get; set; }

        /// <summary>
        /// Specifies Infrastructure failure policy. See `policy.hardware`
        /// </summary>
        [Input("hardware")]
        public Input<Inputs.ResiliencyPolicyPolicyHardwareGetArgs>? Hardware { get; set; }

        /// <summary>
        /// Specifies Region failure policy. `policy.region`
        /// </summary>
        [Input("region")]
        public Input<Inputs.ResiliencyPolicyPolicyRegionGetArgs>? Region { get; set; }

        /// <summary>
        /// Specifies Application failure policy. See `policy.software`
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("software")]
        public Input<Inputs.ResiliencyPolicyPolicySoftwareGetArgs>? Software { get; set; }

        public ResiliencyPolicyPolicyGetArgs()
        {
        }
        public static new ResiliencyPolicyPolicyGetArgs Empty => new ResiliencyPolicyPolicyGetArgs();
    }
}
