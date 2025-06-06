// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iam.Inputs
{

    public sealed class GetPrincipalPolicySimulationContextArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The context _condition key_ to set.
        /// 
        /// If you have policies containing `Condition` elements or using dynamic interpolations then you will need to provide suitable values for each condition key your policies use. See [Actions, resources, and condition keys for AWS services](https://docs.aws.amazon.com/service-authorization/latest/reference/reference_policies_actions-resources-contextkeys.html) to find the various condition keys that are normally provided for real requests to each action of each AWS service.
        /// </summary>
        [Input("key", required: true)]
        public string Key { get; set; } = null!;

        /// <summary>
        /// An IAM value type that determines how the policy simulator will interpret the strings given in `values`.
        /// 
        /// For more information, see the `ContextKeyType` field of [`iam.ContextEntry`](https://docs.aws.amazon.com/IAM/latest/APIReference/API_ContextEntry.html) in the underlying API.
        /// </summary>
        [Input("type", required: true)]
        public string Type { get; set; } = null!;

        [Input("values", required: true)]
        private List<string>? _values;

        /// <summary>
        /// A set of one or more values for this context entry.
        /// </summary>
        public List<string> Values
        {
            get => _values ?? (_values = new List<string>());
            set => _values = value;
        }

        public GetPrincipalPolicySimulationContextArgs()
        {
        }
        public static new GetPrincipalPolicySimulationContextArgs Empty => new GetPrincipalPolicySimulationContextArgs();
    }
}
