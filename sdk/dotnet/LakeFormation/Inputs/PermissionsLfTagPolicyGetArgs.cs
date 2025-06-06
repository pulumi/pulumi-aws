// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation.Inputs
{

    public sealed class PermissionsLfTagPolicyGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier for the Data Catalog. By default, it is the account ID of the caller.
        /// </summary>
        [Input("catalogId")]
        public Input<string>? CatalogId { get; set; }

        [Input("expressions", required: true)]
        private InputList<Inputs.PermissionsLfTagPolicyExpressionGetArgs>? _expressions;

        /// <summary>
        /// A list of tag conditions that apply to the resource's tag policy. Configuration block for tag conditions that apply to the policy. See `expression` below.
        /// 
        /// The following argument is optional:
        /// </summary>
        public InputList<Inputs.PermissionsLfTagPolicyExpressionGetArgs> Expressions
        {
            get => _expressions ?? (_expressions = new InputList<Inputs.PermissionsLfTagPolicyExpressionGetArgs>());
            set => _expressions = value;
        }

        /// <summary>
        /// The resource type for which the tag policy applies. Valid values are `DATABASE` and `TABLE`.
        /// </summary>
        [Input("resourceType", required: true)]
        public Input<string> ResourceType { get; set; } = null!;

        public PermissionsLfTagPolicyGetArgs()
        {
        }
        public static new PermissionsLfTagPolicyGetArgs Empty => new PermissionsLfTagPolicyGetArgs();
    }
}
