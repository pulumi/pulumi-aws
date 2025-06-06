// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Dlm.Inputs
{

    public sealed class LifecyclePolicyPolicyDetailsEventSourceGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("parameters", required: true)]
        public Input<Inputs.LifecyclePolicyPolicyDetailsEventSourceParametersGetArgs> Parameters { get; set; } = null!;

        /// <summary>
        /// The source of the event. Currently only managed CloudWatch Events rules are supported. Valid values are `MANAGED_CWE`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public LifecyclePolicyPolicyDetailsEventSourceGetArgs()
        {
        }
        public static new LifecyclePolicyPolicyDetailsEventSourceGetArgs Empty => new LifecyclePolicyPolicyDetailsEventSourceGetArgs();
    }
}
