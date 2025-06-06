// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fms.Inputs
{

    public sealed class PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Defines NACL entries for Network ACL policy. See the `network_acl_entry_set` block.
        /// </summary>
        [Input("networkAclEntrySet")]
        public Input<Inputs.PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetArgs>? NetworkAclEntrySet { get; set; }

        public PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyArgs()
        {
        }
        public static new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyArgs Empty => new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyArgs();
    }
}
