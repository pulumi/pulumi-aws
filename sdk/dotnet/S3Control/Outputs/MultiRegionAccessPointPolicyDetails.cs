// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Control.Outputs
{

    [OutputType]
    public sealed class MultiRegionAccessPointPolicyDetails
    {
        /// <summary>
        /// The name of the Multi-Region Access Point.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// A valid JSON document that specifies the policy that you want to associate with this Multi-Region Access Point. Once applied, the policy can be edited, but not deleted. For more information, see the documentation on [Multi-Region Access Point Permissions](https://docs.aws.amazon.com/AmazonS3/latest/userguide/MultiRegionAccessPointPermissions.html).
        /// 
        /// &gt; **NOTE:** When you update the `policy`, the update is first listed as the proposed policy. After the update is finished and all Regions have been updated, the proposed policy is listed as the established policy. If both policies have the same version number, the proposed policy is the established policy.
        /// </summary>
        public readonly string Policy;

        [OutputConstructor]
        private MultiRegionAccessPointPolicyDetails(
            string name,

            string policy)
        {
            Name = name;
            Policy = policy;
        }
    }
}
