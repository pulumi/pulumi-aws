// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Inputs
{

    public sealed class LifecyclePolicyPolicyDetailActionIncludeResourcesGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies whether the lifecycle action should apply to distributed AMIs.
        /// </summary>
        [Input("amis")]
        public Input<bool>? Amis { get; set; }

        /// <summary>
        /// Specifies whether the lifecycle action should apply to distributed containers.
        /// </summary>
        [Input("containers")]
        public Input<bool>? Containers { get; set; }

        /// <summary>
        /// Specifies whether the lifecycle action should apply to snapshots associated with distributed AMIs.
        /// </summary>
        [Input("snapshots")]
        public Input<bool>? Snapshots { get; set; }

        public LifecyclePolicyPolicyDetailActionIncludeResourcesGetArgs()
        {
        }
        public static new LifecyclePolicyPolicyDetailActionIncludeResourcesGetArgs Empty => new LifecyclePolicyPolicyDetailActionIncludeResourcesGetArgs();
    }
}
