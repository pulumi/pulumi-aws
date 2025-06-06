// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fms.Inputs
{

    public sealed class PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The beginning port number of the range.
        /// </summary>
        [Input("from")]
        public Input<int>? From { get; set; }

        /// <summary>
        /// The ending port number of the range.
        /// </summary>
        [Input("to")]
        public Input<int>? To { get; set; }

        public PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeGetArgs()
        {
        }
        public static new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeGetArgs Empty => new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeGetArgs();
    }
}
