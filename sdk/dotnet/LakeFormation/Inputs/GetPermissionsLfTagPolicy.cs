// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation.Inputs
{

    public sealed class GetPermissionsLfTagPolicyArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Identifier for the Data Catalog. By default, it is the account ID of the caller.
        /// </summary>
        [Input("catalogId", required: true)]
        public string CatalogId { get; set; } = null!;

        [Input("expressions", required: true)]
        private List<Inputs.GetPermissionsLfTagPolicyExpressionArgs>? _expressions;

        /// <summary>
        /// List of tag conditions that apply to the resource's tag policy. Configuration block for tag conditions that apply to the policy. See `expression` below.
        /// 
        /// The following argument is optional:
        /// </summary>
        public List<Inputs.GetPermissionsLfTagPolicyExpressionArgs> Expressions
        {
            get => _expressions ?? (_expressions = new List<Inputs.GetPermissionsLfTagPolicyExpressionArgs>());
            set => _expressions = value;
        }

        /// <summary>
        /// Resource type for which the tag policy applies. Valid values are `DATABASE` and `TABLE`.
        /// </summary>
        [Input("resourceType", required: true)]
        public string ResourceType { get; set; } = null!;

        public GetPermissionsLfTagPolicyArgs()
        {
        }
        public static new GetPermissionsLfTagPolicyArgs Empty => new GetPermissionsLfTagPolicyArgs();
    }
}
